package com.dev.shopserver.controller;


import com.dev.shopserver.dto.UserDTO;
import com.dev.shopserver.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserServiceImpl userService;

    @Autowired
    public UserController(UserServiceImpl userService){
        this.userService = userService;
    }

    @PostMapping("")
    public void registerUser(UserDTO userDTO){
        userService.register(userDTO);
    }

    public void login(){

    }

    public void logout(){

    }

    public void userInfo(){

    }

    public void updatePassword(){

    }

    public void deleteUser(){

    }
}
