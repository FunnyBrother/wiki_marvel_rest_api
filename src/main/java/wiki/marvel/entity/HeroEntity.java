package wiki.marvel.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Data
@Entity
@Table(name = "heroes")
public class HeroEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @Min(value = 8)
    @Max(value = 32)
    private String name;

    @Column(nullable = false)
    @Min(value = 8)
    @Max(value = 32)
    private String fullname;

    @Column(nullable = false)
    @Max(value = 255)
    private String description;
}
