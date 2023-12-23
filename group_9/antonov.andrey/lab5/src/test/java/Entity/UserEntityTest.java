package Entity;

import java.time.LocalDate;
import annotaion.Column;
import annotaion.Table;
import entity.Gender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(name = "users")
public class UserEntityTest {
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @Column(name = "birthday")
    private LocalDate birthday;

    @Column(name = "gender")
    private Gender gender;

    @Column(name = "adult")
    private Boolean adult;

    @Column(name = "age")
    private int age;

    @Column(name = "carId")
    private int carId;

    private CarEntityTest carEntityTest;
}
