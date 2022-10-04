package com.dev.shopserver.controller;


import com.dev.shopserver.dto.UserDTO;
import com.dev.shopserver.service.impl.UserServiceImpl;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// TODO: RestController
/**
 * Controller와 ResponseBody가 결합된 어노테이션. 컨트롤러 클래스에 쓰임
 * 컨트롤러 클래스 하위 메서드에 @ResponseBody 어노테이션을 붙이지 않아도 문자열과 JSON 등을 전송할 수 있다.
 *
 */
@RestController
@RequestMapping("/users")
public class UserController {
    private final UserServiceImpl userService;

    //@Autowired
    public UserController(UserServiceImpl userService){
        this.userService = userService;
    }

    @GetMapping("/user")
    public List<UserDTO> getUser(){
        return userService.getUserList();
    }

    //@PostMapping("")
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
