package com.nhnacademy.mini_dooray.accountapi.repository;
import com.nhnacademy.mini_dooray.accountapi.entitiy.Member;
import com.nhnacademy.mini_dooray.accountapi.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@ActiveProfiles("test")
class MemberRepositoryTests {

    @Autowired
    private MemberRepository memberRepository;

    @Test
    void findByMemberId_ShouldReturnOptionalMember() {
        Member newMember = new Member();
        newMember.setMemberId("testMember");
        newMember.setEmail("test@example.com");
        newMember.setPassword("testPassword");
        newMember.setMemberStatus("ACTIVE");
        memberRepository.save(newMember);

        Optional<Member> foundMember = memberRepository.findByMemberId("testMember");

        assertThat(foundMember).isPresent();
        assertThat(foundMember.get().getMemberId()).isEqualTo("testMember");
    }

    @Test
    void findByMemberId_ShouldReturnEmptyOptionalForNonexistentMember() {
        Optional<Member> foundMember = memberRepository.findByMemberId("nonexistentMember");

        assertThat(foundMember).isEmpty();
    }


}
