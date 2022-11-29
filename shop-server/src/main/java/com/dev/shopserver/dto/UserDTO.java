package com.dev.shopserver.dto;

import lombok.Getter;
import lombok.Setter;
import org.apache.catalina.User;

import java.util.Date;

@Getter
@Setter
public class UserDTO {
    public enum Status {
        DEFAULT,
        ADMIN,
        SELLER,
        DELETED;
    }
    private int accountId;
    private String userId;
    private String password;
    private String name;
    private String phone;
    private String address;
    private Status status;
    private Date createDate;
    private Date updateDate;

    public UserDTO(int accountId, String userId, String password, String name, String phone, String address,
                   Status status, Date createDate, Date updateDate) {
        this.accountId = accountId;
        this.userId = userId;
        this.password = password;
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.status = status;
        this.createDate = createDate;
        this.updateDate = updateDate;

    }
    public static boolean hasNullDataForSignUp(UserDTO userDTO){
        return userDTO.getUserId() == null || userDTO.getPassword() == null
                || userDTO.getAddress() == null || userDTO.getName() == null
                || userDTO.getPhone()==null;
    }
}
