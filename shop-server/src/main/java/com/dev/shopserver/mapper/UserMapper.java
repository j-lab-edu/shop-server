package com.dev.shopserver.mapper;

import com.dev.shopserver.dto.UserDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    List<UserDTO> getUserList();
}
