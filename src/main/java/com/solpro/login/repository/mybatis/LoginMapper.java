package com.solpro.login.repository.mybatis;

import com.solpro.login.domain.LoginVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LoginMapper {

    public void insert(LoginVO loginVO);
}
