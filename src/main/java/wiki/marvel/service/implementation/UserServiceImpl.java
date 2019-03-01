package wiki.marvel.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import wiki.marvel.entity.HeroEntity;
import wiki.marvel.repository.UserRepository;
import wiki.marvel.service.UserService;

import java.util.List;
import java.util.Optional;

public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public HeroEntity save(HeroEntity entity) {
        return null;
    }

    @Override
    public Optional<HeroEntity> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(long id) {
        return false;
    }

    @Override
    public List<HeroEntity> findAll() {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public void delete(HeroEntity entity) {

    }
}
