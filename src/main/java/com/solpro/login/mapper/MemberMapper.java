package com.solpro.login.mapper;

import com.solpro.login.domain.Member;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {
    public Member memberRegisterCheck(String memId);

    public int memberRegister(Member member);

    public Member memberLogin(Member member);

    public int memberUpdate(Member member);
}
