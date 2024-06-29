package com.ps.demo2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ps.demo2.dtos.UserDto;
import com.ps.demo2.model.User;
import com.ps.demo2.repository.UserRepository;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Service
@NoArgsConstructor
@AllArgsConstructor
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void saveUserInfo(UserDto userDto) {

        try {
            User user = new User();
            user.setEmail(userDto.getEmail());
            user.setFirstName(userDto.getFirstName());
            user.setLastName(userDto.getLastName());
            user.setPhoneNumber(userDto.getPhoneNumber());
            // TODO: you need to encrypt the pass
            user.setPassword(userDto.getPassword());
            user.setUserName("ahksdljakldadasd");

            userRepository.save(user);
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("note");
            System.out.println(e.getMessage());

            throw new RuntimeException();
        }

    }

}
