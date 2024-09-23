package com.example.springdata.entity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest
class MemberTest {

    @PersistenceContext //EntityManager를 빈으로 주입할 때 사용하는 어노테이션입니다.
    EntityManager em;

    @DisplayName("띄우라고")
    @Test
    @Transactional
    @Rollback(false)
    public void testEntity(){
        Team teamA = new Team("teamA");
        Team teamB = new Team("teamB");

        em.persist(teamA);
        em.persist(teamB);


        Member member1 = new Member("member1",10,teamA);
        Member member2 = new Member("member2",20,teamA);
        Member member3 = new Member("member3",30,teamA);
        Member member4 = new Member("member4",40,teamA);
        Member member5 = new Member("member5",50,teamA);

        em.persist(member1);
        em.persist(member2);
        em.persist(member3);
        em.persist(member4);
        em.persist(member5);

        em.flush(); //insert query를 날리게됨
        em.clear(); // jpa em.context에있는 캐시를 날림

        //확인
        List<Member> members = em.createQuery("select m from Member m",Member.class)
                .getResultList();

        for (Member member : members) {
            log.info("member=" + member);
            log.info("-> member.team=" + member.getTeam());
        }
    }
}