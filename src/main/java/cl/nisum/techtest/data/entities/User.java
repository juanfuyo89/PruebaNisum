package cl.nisum.techtest.data.entities;

import cl.nisum.techtest.model.response.Response;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="users")
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User {

    @Id
    private String id;

    private String name;

    @Pattern(regexp = "^([_a-zA-Z0-9-]+(\\.[_a-zA-Z0-9-]+)*@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*(\\.[a-zA-Z]{1,6}))?$"
            ,message= Response.EMAIL_ERROR_MSG)
    private String email;

    @Pattern(regexp = "^(?=.*\\d{2,})(?=.*[a-z])(?=.*[A-Z])(?=.*\\w).{8,}$",
            message = Response.PASSWORD_ERROR_MSG)
    private String password;

    private String token;

    private LocalDate created;

    private LocalDate modified;

    @Column(name="last_login")
    private LocalDate lastLogin;

    @Column(name="is_active")
    private String isActive;

}
