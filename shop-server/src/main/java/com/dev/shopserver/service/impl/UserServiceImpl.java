package com.dev.shopserver.service.impl;

import com.dev.shopserver.common.Constants;
import com.dev.shopserver.common.Constants.ExceptionClass;
import com.dev.shopserver.common.exception.ShopServerException;
import com.dev.shopserver.dto.UserDTO;
import com.dev.shopserver.mapper.UserMapper;
import com.dev.shopserver.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;
    final int IS_USERID = 1;

    public void register(UserDTO userDTO) throws ShopServerException {
        boolean isUserIdDup = isDuplicatedUserId(userDTO.getUserId());
        if(isUserIdDup){
            throw new ShopServerException(ExceptionClass.USER,
                    HttpStatus.BAD_REQUEST, "유저 ID가 중복되었습니다.");
        }
        userDTO.setCreateDate(new Date());
        userDTO.setStatus(UserDTO.Status.DEFAULT);
        userDTO.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        System.out.println(userDTO.getPassword());
        userMapper.register(userDTO);
    }

    public UserDTO login(String userId, String password){
        String encodedPassword = userMapper.getUserInfo(userId).getPassword();
        if(passwordEncoder.matches(password, encodedPassword)){
            return userMapper.findUser(userId);
        } else{
            return null;
        }
    }

    public boolean isDuplicatedUserId(String userId){
        return userMapper.userIdCheck(userId) == IS_USERID;
    }

    public UserDTO getUserInfo(String userId){
        return userMapper.getUserInfo(userId);
    }

    public UserDTO updatePassword(String userId, String beforePassword, String afterPassword)
            throws ShopServerException {
        UserDTO userUpdateDTO = userMapper.findUser(userId);
        if(userId == null || beforePassword == null || afterPassword == null){
            throw new NullPointerException("모든 값을 입력해주세요.");
        } else if(!passwordEncoder.matches(beforePassword, userUpdateDTO.getPassword())){
            throw new ShopServerException(ExceptionClass.USER, HttpStatus.BAD_REQUEST, "비밀번호가 잘못되었습니다.");
        } else {
            userUpdateDTO.setUpdateDate(new Date());
            userUpdateDTO.setPassword(passwordEncoder.encode(afterPassword));
            userMapper.updatePassword(userUpdateDTO);
            return userUpdateDTO;
        }
    }
    public void deleteUser(String userId) throws ShopServerException {
        boolean isUserId = isDuplicatedUserId(userId);
        if (!isUserId) {
            throw new ShopServerException(ExceptionClass.USER,
                    HttpStatus.CONFLICT, "유저 ID가 존재하지 않습니다.");
        }
        userMapper.deleteUser(userId);
    }
}
