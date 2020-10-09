package cl.nisum.techtest.util;

import cl.nisum.techtest.data.entities.Phone;
import cl.nisum.techtest.data.entities.User;
import cl.nisum.techtest.model.dto.Phones;
import cl.nisum.techtest.model.request.RegisterRequest;
import cl.nisum.techtest.model.response.RegisterResponse;

import static java.time.LocalDate.now;

public class GenericBuilder {

    public static final String ACTIVE = "Y";
    public static final String INACTIVE = "N";

    public static User buildUser(RegisterRequest request, String token) {
        return new UserBuilder(UUIDGenerator.generateUUID().toString())
                .setName(request.getName())
                .setEmail(request.getEmail())
                .setPassword(request.getPassword())
                .setToken(token)
                .setCreated(now())
                .setModified(null)
                .setLastLogin(now())
                .setIsActive(ACTIVE)
                .build();
    }

    public static Phone buildPhone(Phones phoneReq, User user) {
        return new PhoneBuilder()
                .setNumber(phoneReq.getNumber())
                .setCityCode(phoneReq.getCityCode())
                .setCountryCode(phoneReq.getCountryCode())
                .setUser(user)
                .build();
    }

    public static RegisterResponse buildPhoneRegisterResponse(User user, String message) {
        return new RegisterResponseBuilder(user.getId())
                .setMessage(message)
                .setCreated(user.getCreated())
                .setModified(user.getModified())
                .setLastLogin(user.getLastLogin())
                .setToken(user.getToken())
                .setIsActive(user.getIsActive())
                .build();
    }

}
