package wiki.marvel.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wiki.marvel.entity.HeroEntity;
import wiki.marvel.repository.HeroRepository;
import wiki.marvel.service.HeroService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class HeroServiceImpl implements HeroService {
    @Autowired
    private HeroRepository heroRepository;

    @Override
    public HeroEntity save(HeroEntity entity) {
        return heroRepository.save(entity);
    }

    @Override
    public Optional<HeroEntity> findById(Long id) {
        return heroRepository.findById(id);
    }

    @Override
    public boolean existsById(long id) {
        return heroRepository.existsById(id);
    }

    @Override
    public List<HeroEntity> findAll() {
        Iterable<HeroEntity> heroEntityIterable = heroRepository.findAll();
        return StreamSupport.stream(heroEntityIterable.spliterator(), false).collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {
        heroRepository.deleteById(id);
    }

    @Override
    public void delete(HeroEntity entity) {
        heroRepository.delete(entity);
    }
}
