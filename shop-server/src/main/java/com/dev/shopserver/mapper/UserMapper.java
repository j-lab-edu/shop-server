package com.dev.shopserver.mapper;

import com.dev.shopserver.dto.UserDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {
    UserDTO getUserInfo(@Param("userId") String userId);
    int register(UserDTO userDTO);
    int deleteUser(@Param("userId") String userId);
    int userIdCheck(String userId);
    int updatePassword(UserDTO userDTO);
    UserDTO findUser(@Param("userId")String userId, @Param("password")String password);

}
