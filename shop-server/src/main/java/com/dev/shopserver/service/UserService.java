package com.dev.shopserver.service;

import com.dev.shopserver.dto.UserDTO;

import java.util.List;

public interface UserService {

    List<UserDTO> getUserList();

    void register(UserDTO userDTO);

    UserDTO login(String userId, String password);

    boolean isDuplicatedId(String id);

    UserDTO getUserInfo(String userId);

    void updatePassword(String userId, String beforePassword, String afterPassword);

    void deleteId(String id, String passWord);
}
