package org.ismetg.movieapp.service;

import jdk.dynalink.linker.LinkerServices;
import org.ismetg.movieapp.dto.request.UserSaveRequestDto;
import org.ismetg.movieapp.dto.response.UserFindAllResponseDto;
import org.ismetg.movieapp.entity.User;
import org.ismetg.movieapp.mapper.UserMapper;
import org.ismetg.movieapp.repository.UserRepository;
import org.ismetg.movieapp.utility.ServiceManager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService extends ServiceManager<User , Long> {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        super(userRepository);
        this.userRepository = userRepository;
    }
    public void saveDto(UserSaveRequestDto dto){
        userRepository.save(UserMapper.INSTANCE.userSaveRequestDtoToUser(dto));
    }

    public List<UserFindAllResponseDto> findAllResponseDto(){
        List<UserFindAllResponseDto> responseDtoList = new ArrayList<>();
        findAll().forEach(user -> {
            responseDtoList.add(UserMapper.INSTANCE.userToUserFindAllResponseDto(user));
        });
        return responseDtoList;
    }
    public User doRegister(String name ,String surname, String email , String phone , String password){
        User user = User.builder()
                .name(name)
                .surname(surname)
                .email(email)
                .phone(phone)
                .password(password)
                .build();
        userRepository.save(user);
        return user;
    }

    public Optional<User> findByEmailAndPassword(String email, String password){
        return userRepository.findByEmailAndPassword(email,password);
    }
}
