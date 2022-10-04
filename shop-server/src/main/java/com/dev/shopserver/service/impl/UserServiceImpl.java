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


    public void register(UserDTO userDTO){
        boolean isUserIdDup = isDuplicatedUserId(userDTO.getUserId());
        if(isUserIdDup){
            throw new RuntimeException("Duplicated userId");
        }
        userDTO.setCreateDate(new Date());
        userMapper.register(userDTO);
    }

    public UserDTO login(String userId, String password){
        return null;
    }

    public boolean isDuplicatedUserId(String userId){
        return userMapper.userIdCheck(userId) == 1;
    }

    public UserDTO getUserInfo(String userId){
        return userMapper.getUserInfo(userId);
    }

    public void updatePassword(String userId, String beforePassword, String afterPassword){

    }

    public void deleteUser(String userId, String passWord){

    }
}
