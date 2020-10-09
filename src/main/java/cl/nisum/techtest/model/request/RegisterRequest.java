package cl.nisum.techtest.model.request;

import cl.nisum.techtest.model.dto.Phones;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest implements Serializable {
    private String name;
    private String email;
    private String password;
    private List<Phones> phones;
}
