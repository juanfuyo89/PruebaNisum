package cl.nisum.techtest.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Phones {
    private Integer number;
    private Integer cityCode;
    private Integer countryCode;
}
