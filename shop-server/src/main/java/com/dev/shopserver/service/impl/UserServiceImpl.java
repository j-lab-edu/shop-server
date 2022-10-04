package com.dev.shopserver.service.impl;

import com.dev.shopserver.dto.UserDTO;
import com.dev.shopserver.mapper.UserMapper;
import com.dev.shopserver.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;


    public List<UserDTO> getUserList(){
        return userMapper.getUserList();
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
