package wiki.marvel.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import wiki.marvel.entity.HeroEntity;

@Repository
public interface HeroRepository extends CrudRepository<HeroEntity, Long> {
}
