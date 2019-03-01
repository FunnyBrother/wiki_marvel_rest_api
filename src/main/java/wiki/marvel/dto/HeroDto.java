package wiki.marvel.dto;

import lombok.Data;

@Data
public class HeroDto {
    private Long id;
    private String name;
    private String fullName;
    private String description;
}
