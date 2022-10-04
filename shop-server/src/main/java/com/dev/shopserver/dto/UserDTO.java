package com.dev.shopserver.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class UserDTO {
    public enum Status {
        DEFAULT, ADMIN, DELETED
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
    private boolean isSeller;
    private boolean isAdmin;

    public UserDTO(){
    }

    public UserDTO(String userId, String password, String name, String phone, String address,
                   Status status, Date createDate, Date updateDate, boolean isSeller, boolean isAdmin) {
        this.userId = userId;
        this.password = password;
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.status = status;
        this.createDate = createDate;
        this.updateDate = updateDate;
        this.isSeller = isSeller;
        this.isAdmin = isAdmin;
    }
}
