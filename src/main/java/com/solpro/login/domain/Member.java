package com.solpro.login.domain;

import lombok.Data;

@Data
public class Member {

    private int memIdx;
    private String memId;
    private String memPassword;
    private String memName;
    private String memEmail;

}
