package cl.nisum.techtest.util;

import cl.nisum.techtest.model.response.RegisterResponse;

import java.time.LocalDate;

public class RegisterResponseBuilder {

    private String message;
    private String id;
    private LocalDate created;
    private LocalDate modified;
    private LocalDate lastLogin;
    private String token;
    private String isActive;

    public RegisterResponseBuilder(String id){
        this.id = id;
    }

    public RegisterResponseBuilder setMessage(String id){
        this.id = id;
        return this;
    }

    public RegisterResponseBuilder setCreated(LocalDate created) {
        this.created = created;
        return this;
    }

    public RegisterResponseBuilder setModified(LocalDate modified) {
        this.modified = modified;
        return this;
    }

    public RegisterResponseBuilder setLastLogin(LocalDate lastLogin) {
        this.lastLogin = lastLogin;
        return this;
    }

    public RegisterResponseBuilder setToken(String token) {
        this.token = token;
        return this;
    }

    public RegisterResponseBuilder setIsActive(String isActive) {
        this.isActive = isActive;
        return this;
    }

    public RegisterResponse build() {
        return new RegisterResponse(message,id,created,modified,lastLogin,token,isActive);
    }
}
