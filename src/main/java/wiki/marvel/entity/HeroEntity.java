package wiki.marvel.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "heroes")
public class HeroEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(name = "fullname", nullable = false)
    private String fullName;

    @Column(nullable = false)
    private String description;
}
