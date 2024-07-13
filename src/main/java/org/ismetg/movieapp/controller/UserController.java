package org.ismetg.movieapp.controller;

import lombok.RequiredArgsConstructor;
import org.ismetg.movieapp.dto.LoginDto;
import org.ismetg.movieapp.dto.UserLoginDto;
import org.ismetg.movieapp.dto.request.UserSaveRequestDto;
import org.ismetg.movieapp.dto.response.UserFindAllResponseDto;
import org.ismetg.movieapp.entity.User;
import org.ismetg.movieapp.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.ismetg.movieapp.constant.EndPoints.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

/*
    @PostMapping(SAVE)
    public ResponseEntity<User> save(@RequestBody User user) {
        return ResponseEntity.ok(userService.save(user));
    }


    @GetMapping(FIND_ALL)
    public ResponseEntity<List<User>> findAll() {
        return ResponseEntity.ok(userService.findAll());
    }
 */
    @PostMapping(SAVE)
    public ResponseEntity<String> save(@RequestBody UserSaveRequestDto dto){
        userService.saveDto(dto);
        return ResponseEntity.ok("Başarılı");
    }

    @GetMapping(FIND_ALL)
    public ResponseEntity<List<UserFindAllResponseDto>> findAllDto(){
        return ResponseEntity.ok(userService.findAllResponseDto());
    }

    @PostMapping("/register")
    public ResponseEntity<User> doRegister(@RequestBody UserSaveRequestDto dto ){
        if (dto.password().equals(dto.rePassword())){
            return ResponseEntity.ok(userService.doRegister(dto.name() , dto.surname(), dto.email(), dto.phone(), dto.password()));
        }
        ResponseEntity.ok("şifre ile şifre uyuşmuyor");
       return null;
    }
    @PostMapping("/login")
    public ResponseEntity<Optional<User>> doLogin(@RequestBody UserLoginDto dto){
        Optional<User> byEmailAndPassword = userService.findByEmailAndPassword(dto.email(), dto.password());
        if (byEmailAndPassword.isPresent()) {
            ResponseEntity.ok("başarılı");
            return ResponseEntity.ok(byEmailAndPassword);
        }
        return null;
    }


}
