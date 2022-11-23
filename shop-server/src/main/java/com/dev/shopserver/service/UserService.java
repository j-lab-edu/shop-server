package com.dev.shopserver.service;

import com.dev.shopserver.common.exception.ShopServerException;
import com.dev.shopserver.dto.UserDTO;


public interface UserService {

    void register(UserDTO userDTO) throws ShopServerException;

    UserDTO login(String userId, String password);

    boolean isDuplicatedUserId(String userId);

    UserDTO getUserInfo(String userId);

    UserDTO updatePassword(String userId, String beforePassword, String afterPassword) throws ShopServerException;

    void deleteUser(String userId) throws ShopServerException;
}
