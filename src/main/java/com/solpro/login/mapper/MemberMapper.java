package com.solpro.login.mapper;

import com.solpro.login.domain.Member;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {
    public Member registerCheck(String memId);
}