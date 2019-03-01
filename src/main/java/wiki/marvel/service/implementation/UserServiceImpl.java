package wiki.marvel.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import wiki.marvel.entity.UserEntity;
import wiki.marvel.repository.UserRepository;
import wiki.marvel.service.UserService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserEntity save(UserEntity entity) {
        return userRepository.save(entity);
    }

    @Override
    public Optional<UserEntity> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public boolean existsById(long id) {
        return userRepository.existsById(id);
    }

    @Override
    public List<UserEntity> findAll() {
        Iterable<UserEntity> userEntityIterable = userRepository.findAll();
        return StreamSupport.stream(userEntityIterable.spliterator(), false).collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public void delete(UserEntity entity) {
        userRepository.delete(entity);
    }
}
