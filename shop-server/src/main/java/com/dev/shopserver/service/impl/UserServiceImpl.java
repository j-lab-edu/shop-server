package com.dev.shopserver.service.impl;

import com.dev.shopserver.common.Constants.ExceptionClass;
import com.dev.shopserver.common.exception.ShopServerException;
import com.dev.shopserver.dto.UserDTO;
import com.dev.shopserver.mapper.UserMapper;
import com.dev.shopserver.service.UserService;
import com.dev.shopserver.util.BcryptEncoder;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Date;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;
    private final BcryptEncoder bcryptEncoder;

    final int IS_USERID = 1;

    @Override
    public void register(UserDTO userDTO) throws ShopServerException {
        boolean isUserIdDup = isDuplicatedUserId(userDTO.getUserId());
        if(isUserIdDup){
            throw new ShopServerException(ExceptionClass.USER,
                    HttpStatus.BAD_REQUEST, "유저 ID가 중복되었습니다.");
        }
        userDTO.setCreateDate(new Date());
        userDTO.setPassword(bcryptEncoder.encodePassword(userDTO.getPassword()));
        userMapper.register(userDTO);
    }
    @Override
    public UserDTO login(String userId, String password){
        UserDTO userDTO = userMapper.findUser(userId);
        String encodedPassword = userDTO.getPassword();
        if(bcryptEncoder.isMatch(password, encodedPassword)){
            return userDTO;
        } else{
            return null;
        }
    }

    @Override
    public boolean isDuplicatedUserId(String userId){
        return userMapper.userIdCheck(userId) == IS_USERID;
    }

    @Override
    public UserDTO getUserInfo(String userId){
        return userMapper.findUser(userId);
    }

    @Override
    public UserDTO updatePassword(String userId, String beforePassword, String afterPassword)
            throws ShopServerException {
        UserDTO userUpdateDTO = userMapper.findUser(userId);
        if(userId == null || beforePassword == null || afterPassword == null){
            throw new NullPointerException("모든 값을 입력해주세요.");
        } else if(!bcryptEncoder.isMatch(beforePassword, userUpdateDTO.getPassword())){
            throw new ShopServerException(ExceptionClass.USER, HttpStatus.BAD_REQUEST, "비밀번호가 잘못되었습니다.");
        } else {
            userUpdateDTO.setUpdateDate(new Date());
            userUpdateDTO.setPassword(bcryptEncoder.encodePassword(afterPassword));
            userMapper.updatePassword(userUpdateDTO);
            return userUpdateDTO;
        }
    }
    @Override
    public void deleteUser(String userId) throws ShopServerException {
        boolean isUserId = isDuplicatedUserId(userId);
        if (!isUserId) {
            throw new ShopServerException(ExceptionClass.USER,
                    HttpStatus.CONFLICT, "유저 ID가 존재하지 않습니다.");
        }
        userMapper.deleteUser(userId);
    }
}
