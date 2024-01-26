package com.nhnacademy.mini_dooray.accountapi.controller;

import com.nhnacademy.mini_dooray.accountapi.entitiy.Member;
import com.nhnacademy.mini_dooray.accountapi.service.MemberService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
        System.out.println(member.getMemberId());
        System.out.println(member.getMemberId());
        System.out.println(member.getMemberId());
        System.out.println(member.getMemberId());
        System.out.println(member);
        memberService.createMember(member);
    }

}