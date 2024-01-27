package com.nhnacademy.mini_dooray.accountapi.repository;

import com.nhnacademy.mini_dooray.accountapi.entitiy.Member;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, String> {

    Optional<Member> findByMemberId(String memberId);

}
