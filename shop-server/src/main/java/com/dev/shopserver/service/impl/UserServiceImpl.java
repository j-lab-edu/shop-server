package com.dev.shopserver.service.impl;

import com.dev.shopserver.dto.UserDTO;
import com.dev.shopserver.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Date;


@Service
public class UserServiceImpl implements UserService {

    public UserServiceImpl(){

    }

    public void register(UserDTO userDTO){
    }

    public UserDTO login(String userId, String password){
        return null;
    }

    public boolean isDuplicatedId(String id){
        return true;
    }

    public UserDTO getUserInfo(String userId){
        return null;
    }

    public void updatePassword(String userId, String beforePassword, String afterPassword){

    }

    public void deleteId(String id, String passWord){

    }
}
