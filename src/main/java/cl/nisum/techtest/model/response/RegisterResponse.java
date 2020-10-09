package cl.nisum.techtest.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterResponse extends Response {

    private String id;
    private LocalDate created;
    private LocalDate modified;
    private LocalDate lastLogin;
    private String token;
    private String isActive;

    public RegisterResponse(String message, String id, LocalDate created,
                            LocalDate modified, LocalDate lastLogin, String token, String isActive) {
        super.setResponseMessage(message);
        this.id = id;
        this.created = created;
        this.modified = modified;
        this.lastLogin = lastLogin;
        this.token = token;
        this.isActive = isActive;
    }
}
