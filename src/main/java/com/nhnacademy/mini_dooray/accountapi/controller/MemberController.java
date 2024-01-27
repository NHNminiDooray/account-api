package com.nhnacademy.mini_dooray.accountapi.controller;

import com.nhnacademy.mini_dooray.accountapi.entitiy.LoginRequestDto;
import com.nhnacademy.mini_dooray.accountapi.entitiy.Member;
import com.nhnacademy.mini_dooray.accountapi.service.MemberService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping("/members/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void createMember(@RequestBody Member member) {
        memberService.createMember(member);
    }

    @PostMapping("/members/login")
    @ResponseStatus(HttpStatus.CREATED)
    public void doLoginMember(@RequestBody LoginRequestDto loginRequestDto) {
        memberService.loginMember(loginRequestDto);
    }

}