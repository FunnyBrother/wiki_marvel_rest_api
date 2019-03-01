package wiki.marvel.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import wiki.marvel.dto.HeroDto;
import wiki.marvel.entity.HeroEntity;
import wiki.marvel.service.HeroService;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

// TODO: JSON response in error
// TODO: change entity to dto

@RestController(value = "/hero")
public class HeroController {
    private final HeroService heroService;
    private final ModelMapper modelMapper;

    @Autowired
    public HeroController(HeroService heroService, ModelMapper modelMapper) {
        this.heroService = heroService;
        this.modelMapper = modelMapper;
    }

    @DeleteMapping(value = "/")
    public ResponseEntity<?> delete(@RequestBody HeroEntity heroEntity) {
        Long id = heroEntity.getId();

        boolean isExists = heroService.existsById(id);

        if(!isExists) {
            return new ResponseEntity<>("Not found hero!", HttpStatus.BAD_REQUEST);
        }

        heroService.delete(heroEntity);

        HeroDto heroDto = modelMapper.map(heroEntity, HeroDto.class);

        return new ResponseEntity<>(heroDto, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteById(@PathVariable("id") Long id) {
        boolean isExists = heroService.existsById(id);

        if(!isExists) {
            return new ResponseEntity<>("Not found hero by id:" + id, HttpStatus.BAD_REQUEST);
        }

        heroService.deleteById(id);

        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @PostMapping(value = "/")
    public ResponseEntity<HeroDto> save(@RequestBody HeroEntity heroEntity) {
        heroEntity = heroService.save(heroEntity);

        HeroDto heroDto = modelMapper.map(heroEntity, HeroDto.class);

        return new ResponseEntity<>(heroDto, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") Long id) {
        Optional<HeroEntity> optionalHeroEntity = heroService.findById(id);

        if(optionalHeroEntity.isEmpty()) {
            return new ResponseEntity<>("Not found hero by id:" + id, HttpStatus.NOT_FOUND);
        }

        HeroEntity heroEntity = optionalHeroEntity.get();

        HeroDto heroDto = modelMapper.map(heroEntity, HeroDto.class);

        return new ResponseEntity<>(heroDto, HttpStatus.OK);
    }

    @GetMapping(value = "/")
    public ResponseEntity<List<HeroDto>> findAll() {
        List<HeroEntity> heroEntityList = heroService.findAll();

        if(heroEntityList.isEmpty()) {
            return new ResponseEntity<>(Collections.emptyList(), HttpStatus.NO_CONTENT);
        }

        List<HeroDto> heroDtoList = heroEntityList.stream().map(heroEntity -> modelMapper.map(heroEntity, HeroDto.class)).collect(Collectors.toList());

        return new ResponseEntity<>(heroDtoList, HttpStatus.OK);
    }
}
