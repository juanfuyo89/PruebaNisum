package cl.nisum.techtest;

import cl.nisum.techtest.data.entities.User;
import cl.nisum.techtest.data.repositories.PhoneRepository;
import cl.nisum.techtest.data.repositories.UserRepository;
import cl.nisum.techtest.exception.InternalValidationException;
import cl.nisum.techtest.model.dto.Phones;
import cl.nisum.techtest.model.request.RegisterRequest;
import cl.nisum.techtest.security.TokenGenerator;
import cl.nisum.techtest.services.RegisterService;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

/**
 * Clase de pruebas unitarias con Mockito para la capa de Servicios
 *
 * @author Juan Carlos Fuyo
 *
 */
@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class RegisterServiceTest {

    private final Logger logger = LogManager.getRootLogger();

    @Mock
    private UserRepository userRepoMock;

    @Mock
    private PhoneRepository phoneRepoMock;

    @Mock
    private TokenGenerator tokenGeneratorMock;

    @InjectMocks
    private RegisterService registerService = new RegisterService();

    @Before
    public void setUp() throws Exception {
        logger.info("Inicio de Test Services");
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getAllUsers() {
        when(userRepoMock.findAll()).thenReturn(new ArrayList<User>());
        assertThat(registerService.getAllUsers(), is(notNullValue()));
        verify(userRepoMock).findAll();
    }

    @Test
    public void registerUser() {
        when(userRepoMock.findByEmail(Mockito.anyString())).thenReturn(null);
        when(tokenGeneratorMock.getJWTToken(Mockito.anyString())).thenReturn("token");
        RegisterRequest request = new RegisterRequest();
        request.setEmail("mail@dominio.cl");
        List<Phones> phones = new ArrayList<>();
        phones.add(new Phones());
        request.setPhones(phones);
        registerService.register(request);
        verify(userRepoMock).save(Mockito.any());
        verify(phoneRepoMock).save(Mockito.any());
    }

    @Test
    public void registerUserAlreadyExists() {
        User user = new User();
        user.setId("UUID");
        String email = "mail@dominio.cl";
        user.setEmail(email);
        when(userRepoMock.findByEmail(Mockito.anyString())).thenReturn(user);
        RegisterRequest request = new RegisterRequest();
        request.setEmail(email);
        Assertions.assertThrows(InternalValidationException.class, () -> {
            registerService.register(request);
        });
    }

}