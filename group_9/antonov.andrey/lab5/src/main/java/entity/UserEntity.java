package entity;

import java.time.LocalDateTime;
import annotaion.Column;
import annotaion.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(name = "users")
public class UserEntity {
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @Column(name = "birthday")
    private LocalDateTime birthday;

    @Column(name = "gender")
    private Gender gender;

    @Column(name = "adult")
    private Boolean adult;
}
