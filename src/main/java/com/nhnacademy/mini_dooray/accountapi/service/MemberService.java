package com.nhnacademy.mini_dooray.accountapi.service;
import com.nhnacademy.mini_dooray.accountapi.entitiy.Member;
import java.util.List;

public interface MemberService {
    List<Member> getMembers();

    Member getMember(String id);

    Member createMember(Member member);

}
