package wiki.marvel.dto;

import lombok.Data;
import wiki.marvel.entity.UserEntity;

@Data
public class HeroDto {
    private Long id;
    private String name;
    private String nickname;
    private String description;
    private UserEntity user;
}
