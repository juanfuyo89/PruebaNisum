package cl.nisum.techtest.util;

import cl.nisum.techtest.data.entities.User;

import java.time.LocalDate;

public class UserBuilder {

    private String id;
    private String name;
    private String email;
    private String password;
    private String token;
    private LocalDate created;
    private LocalDate modified;
    private LocalDate lastLogin;
    private String isActive;

    public UserBuilder(String id) {
        this.id = id;
    }

    public UserBuilder setId(String id) {
        this.id = id;
        return this;
    }

    public UserBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public UserBuilder setEmail(String email) {
        this.email = email;
        return this;
    }

    public UserBuilder setPassword(String password) {
        this.password = password;
        return this;
    }

    public UserBuilder setToken(String token) {
        this.token = token;
        return this;
    }

    public UserBuilder setCreated(LocalDate created) {
        this.created = created;
        return this;
    }

    public UserBuilder setModified(LocalDate modified) {
        this.modified = modified;
        return this;
    }

    public UserBuilder setLastLogin(LocalDate lastLogin) {
        this.lastLogin = lastLogin;
        return this;
    }

    public UserBuilder setIsActive(String isActive) {
        this.isActive = isActive;
        return this;
    }

    public User build() {
        return new User(id,name,email,password,token,created,modified,lastLogin,isActive);
    }
}
