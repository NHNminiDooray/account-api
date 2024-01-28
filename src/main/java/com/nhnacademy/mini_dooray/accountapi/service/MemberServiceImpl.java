package com.nhnacademy.mini_dooray.accountapi.service;

import com.nhnacademy.mini_dooray.accountapi.dto.LoginRequestDto;
import com.nhnacademy.mini_dooray.accountapi.exception.IncorrectPasswordException;
import com.nhnacademy.mini_dooray.accountapi.exception.MemberNotFoundException;
import com.nhnacademy.mini_dooray.accountapi.repository.MemberRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import com.nhnacademy.mini_dooray.accountapi.entitiy.Member;

@Service
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public Member createMember(Member member) {
        try {
            Member newMember = new Member();
            newMember.setMemberId(member.getMemberId());
            newMember.setEmail(member.getEmail());
            newMember.setPassword(member.getPassword());
            newMember.setMemberStatus(member.getMemberStatus());
            Member saveMember = memberRepository.save(newMember);
            return saveMember;
        } catch (DataIntegrityViolationException e) {
            throw new RuntimeException("회원 가입에 실패했습니다.");
        }
    }
    @Override
    public Member loginMember(LoginRequestDto loginRequestDto) {
        String memberId = loginRequestDto.getMemberId();
        Optional<Member> optionalMember = memberRepository.findByMemberId(memberId);

        if (optionalMember.isPresent()) {
            Member member = optionalMember.get();
            if (passwordMatches(loginRequestDto.getPassword(), member.getPassword())) {
                return member;
            } else {
                throw new IncorrectPasswordException("비밀번호가 일치하지 않습니다.");
            }
        } else {
            throw new MemberNotFoundException("해당하는 멤버를 찾을 수 없습니다.");
        }
    }

    @Override
    public List<String> findAllMemberIds() {
        return memberRepository.findAllMemberIds();
    }

    private boolean passwordMatches(String inputPassword, String storedPassword) {
        return inputPassword.equals(storedPassword);
    }


}
