package wiki.marvel.service;

import org.springframework.stereotype.Service;
import wiki.marvel.entity.UserEntity;

import java.util.List;
import java.util.Optional;

@Service
public interface UserService {
    UserEntity save(UserEntity entity);

    Optional<UserEntity> findById(Long id);

    boolean existsById(long id);

    List<UserEntity> findAll();

    void deleteById(Long id);

    void delete(UserEntity entity);
}
