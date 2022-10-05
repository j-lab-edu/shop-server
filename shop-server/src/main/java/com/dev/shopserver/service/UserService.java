package com.dev.shopserver.service;

import com.dev.shopserver.dto.UserDTO;

import java.util.List;

public interface UserService {

    void register(UserDTO userDTO);

    UserDTO login(String userId, String password);

    boolean isDuplicatedUserId(String userId);

    UserDTO getUserInfo(String userId);

    void updatePassword(String userId, String beforePassword, String afterPassword);

    void deleteUser(String userId);
}
