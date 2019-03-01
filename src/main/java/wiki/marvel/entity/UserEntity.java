package wiki.marvel.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Data
@Entity
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @Min(value = 8)
    @Max(value = 16)
    private String nickname;

    @Column(nullable = false)
    @Min(value = 8)
    @Max(value = 32)
    private String fullname;
}
