package com.nhnacademy.mini_dooray.accountapi.controller;

import com.nhnacademy.mini_dooray.accountapi.dto.LoginRequestDto;
import com.nhnacademy.mini_dooray.accountapi.entitiy.Member;
import com.nhnacademy.mini_dooray.accountapi.dto.MemberIdsDto;
import com.nhnacademy.mini_dooray.accountapi.service.MemberService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/members")
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping
    public ResponseEntity<MemberIdsDto> allMember() {
        MemberIdsDto memberIdsDto = new MemberIdsDto();
        memberIdsDto.setMemberIds(memberService.findAllMemberIds());
        return new ResponseEntity<>(memberIdsDto, HttpStatus.OK);
    }


    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void createMember(@RequestBody Member member) {
        memberService.createMember(member);
    }

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.CREATED)
    public Member doLoginMember(@RequestBody LoginRequestDto loginRequestDto) {
        return memberService.loginMember(loginRequestDto);
    }

}