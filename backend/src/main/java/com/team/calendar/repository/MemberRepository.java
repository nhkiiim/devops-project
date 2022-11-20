package com.team.calendar.repository;

import com.team.calendar.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Integer> {
    Member findByMemberName(String memberName);
}
