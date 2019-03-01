package wiki.marvel.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import wiki.marvel.entity.UserEntity;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long> {
}
