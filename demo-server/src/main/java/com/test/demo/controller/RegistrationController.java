package com.test.demo.controller;

import com.test.demo.dto.user.UserDTO;
import com.test.demo.model.User;
import com.test.demo.service.UserService;
import com.test.demo.util.UserDTOMapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class RegistrationController {

    private final UserService userDetailsService;

    public RegistrationController(UserService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @PostMapping(value = "/register")
    public UserDTO saveUser(@Valid @RequestBody UserDTO userDto) {
        User user = UserDTOMapper.map(userDto);
        return UserDTOMapper.map(userDetailsService.save(user));
    }
}
