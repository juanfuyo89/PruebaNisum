package cl.nisum.techtest.services;

import cl.nisum.techtest.data.entities.User;
import cl.nisum.techtest.data.repositories.PhoneRepository;
import cl.nisum.techtest.data.repositories.UserRepository;
import cl.nisum.techtest.exception.InternalValidationException;
import cl.nisum.techtest.model.dto.Phones;
import cl.nisum.techtest.model.request.RegisterRequest;
import cl.nisum.techtest.model.response.RegisterResponse;
import cl.nisum.techtest.model.response.Response;
import cl.nisum.techtest.security.TokenGenerator;
import cl.nisum.techtest.util.GenericBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class RegisterService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    PhoneRepository phoneRepository;
    @Autowired
    TokenGenerator tokenGenerator;

    @Transactional
    public RegisterResponse register(RegisterRequest request) {
        User user = userRepository.findByEmail(request.getEmail());
        if (user != null && user.getId() != null && !user.getId().isEmpty())
            throw new InternalValidationException(Response.EMAIL_ALREADY_EXISTS_MSG);
        return this.saveUser(request);
    }

    private RegisterResponse saveUser(RegisterRequest request) {
        User user = GenericBuilder.buildUser(request,tokenGenerator.getJWTToken(request.getEmail()));
        userRepository.save(user);
        this.savePhones(request.getPhones(), user);
        return GenericBuilder.buildPhoneRegisterResponse(user,Response.OK_MSG);
    }

    private void savePhones(List<Phones> phones, User user) {
        phones.forEach(phoneReq -> {
            phoneRepository.save(GenericBuilder.buildPhone(phoneReq,user));
        });
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
