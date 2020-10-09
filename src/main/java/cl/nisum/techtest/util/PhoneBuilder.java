package cl.nisum.techtest.util;

import cl.nisum.techtest.data.entities.Phone;
import cl.nisum.techtest.data.entities.User;

public class PhoneBuilder {

    private Integer number;
    private Integer cityCode;
    private Integer countryCode;
    private User user;

    public PhoneBuilder() {
    }

    public PhoneBuilder setNumber(Integer number) {
        this.number = number;
        return this;
    }

    public PhoneBuilder setCityCode(Integer cityCode) {
        this.cityCode = cityCode;
        return this;
    }

    public PhoneBuilder setCountryCode(Integer countryCode) {
        this.countryCode = countryCode;
        return this;
    }

    public PhoneBuilder setUser(User user) {
        this.user = user;
        return this;
    }

    public Phone build() {
        return new Phone(null,number,cityCode,countryCode,user);
    }
}
