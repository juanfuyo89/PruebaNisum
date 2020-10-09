package cl.nisum.techtest.data.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="phones")
@NamedQuery(name="Phone.findAll", query="SELECT p FROM Phone p")
public class Phone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer number;

    @Column(name="city_code")
    private Integer cityCode;

    @Column(name="country_code")
    private Integer countryCode;

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name="user_id")
    private User user;

}
