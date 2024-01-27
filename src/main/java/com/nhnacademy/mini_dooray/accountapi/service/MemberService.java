package com.nhnacademy.mini_dooray.accountapi.service;
import com.nhnacademy.mini_dooray.accountapi.entitiy.LoginRequestDto;
import com.nhnacademy.mini_dooray.accountapi.entitiy.Member;
import java.util.List;

public interface MemberService {
    Member createMember(Member member);

    Member loginMember(LoginRequestDto loginRequestDto);

    List<String> findAllMemberIds();
}
