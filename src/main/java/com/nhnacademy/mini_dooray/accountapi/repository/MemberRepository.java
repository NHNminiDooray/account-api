package com.nhnacademy.mini_dooray.accountapi.repository;

import com.nhnacademy.mini_dooray.accountapi.entitiy.Member;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MemberRepository extends JpaRepository<Member, String> {

    Optional<Member> findByMemberId(String memberId);

    @Query("SELECT m.memberId FROM Member m")
    List<String> findAllMemberIds();
}
