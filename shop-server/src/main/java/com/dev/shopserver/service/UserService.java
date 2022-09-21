package com.dev.shopserver.service;

import com.dev.shopserver.dto.UserDTO;

public interface UserService {

    void register(UserDTO userDTO);

    UserDTO login(String userId, String password);

    boolean isDuplicatedId(String id);

    UserDTO getUserInfo(String userId);

    void updatePassword(String userId, String beforePassword, String afterPassword);

    void deleteId(String id, String passWord);
}
