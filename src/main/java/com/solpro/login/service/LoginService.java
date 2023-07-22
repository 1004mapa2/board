package com.solpro.login.service;

import com.solpro.login.domain.LoginVO;
import com.solpro.login.repository.mybatis.LoginMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    private LoginMapper mapper;

    public LoginService(LoginMapper mapper) {
        this.mapper = mapper;
    }

    public void register(LoginVO loginVO) {
        mapper.insert(loginVO);
    }
}
