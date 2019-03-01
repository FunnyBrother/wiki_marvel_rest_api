package wiki.marvel.repository;

import org.springframework.data.repository.CrudRepository;
import wiki.marvel.entity.UserEntity;

public interface UserRepository extends CrudRepository<UserEntity, Long> {
}
