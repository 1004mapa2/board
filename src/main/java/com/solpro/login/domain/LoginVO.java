package com.solpro.login.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginVO {
    private String userId;
    private String userPassword;
    private String userName;
    private String userEmail;
    private String userPhone;
}
