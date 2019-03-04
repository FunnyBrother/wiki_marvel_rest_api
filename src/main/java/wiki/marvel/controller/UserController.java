package wiki.marvel.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import wiki.marvel.dto.UserDto;
import wiki.marvel.entity.UserEntity;
import wiki.marvel.service.UserService;

import java.util.Map;

import static wiki.marvel.enums.UserControllerMessagesEnum.NOT_FOUND_USER_BY_ID;

@RestController(value = "/user")
public class UserController {
    private final UserService userService;
    private final ModelMapper modelMapper;

    @Autowired
    public UserController(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @DeleteMapping(value = "/")
    public ResponseEntity<?> delete(@RequestBody UserEntity userEntity) {
        Long id = userEntity.getId();

        boolean isExists = userService.existsById(id);

        if(!isExists) {
            return new ResponseEntity<>(Map.entry("message", NOT_FOUND_USER_BY_ID), HttpStatus.NOT_FOUND);
        }

        userService.delete(userEntity);

        UserDto userDto = modelMapper.map(userEntity, UserDto.class);

        return new ResponseEntity<>(userDto, HttpStatus.OK);
    }
}
