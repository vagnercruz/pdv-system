package com.pdv.dto;

import lombok.Data;

@Data
public class UserCreateDTO {

    private String name;
    private String email;
    private String password;
    private String role;

}