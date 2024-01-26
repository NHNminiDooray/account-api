package com.nhnacademy.mini_dooray.accountapi.service;

import com.nhnacademy.mini_dooray.accountapi.repository.MemberRepository;
import java.util.List;
import org.springframework.stereotype.Service;
import com.nhnacademy.mini_dooray.accountapi.entitiy.Member;

@Service
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public List<Member> getMembers() {
        return memberRepository.findAll();
    }


    @Override
    public Member getMember(String id) {
        return memberRepository.findById(id).orElse(null);
    }

    @Override
    public Member createMember(Member member) {
        Member newMember = new Member();
        newMember.setMemberId(member.getMemberId());
        newMember.setEmail(member.getEmail());
        newMember.setPassword(member.getPassword());
        newMember.setMemberStatus(member.getMemberStatus());

        Member saveMember = memberRepository.save(newMember);
        return saveMember;
    }
}
