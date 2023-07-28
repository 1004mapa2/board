package com.solpro.login.domain;

import lombok.Data;

@Data
public class LoginVO {
    private int idx;
    private String userId;
    private String userPassword;
    private String userName;
    private String userEmail;
    private String userPhone;
}
