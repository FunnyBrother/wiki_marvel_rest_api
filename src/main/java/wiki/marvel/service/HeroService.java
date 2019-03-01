package wiki.marvel.service;

import org.springframework.stereotype.Service;
import wiki.marvel.entity.HeroEntity;

import java.util.List;
import java.util.Optional;

@Service
public interface HeroService {
    HeroEntity save(HeroEntity entity);

    Optional<HeroEntity> findById(Long id);

    boolean existsById(long id);

    List<HeroEntity> findAll();

    void deleteById(Long id);

    void delete(HeroEntity entity);
}
