package com.jpabook.jpashop.repository;

import com.jpabook.jpashop.domain.Member;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

// 내부에 Component 애노테이션이 있어서 스프링 빈으로 자동 등록된다.
@Repository
public class MemberRepository {
    // JPA를 사용하며, @PersistenceContext annotation을 사용하면 스프링 컨테이너에 의해 엔티티 매니저를 주입받을 수 있다.
    @PersistenceContext
    private EntityManager em;

    public void save(Member member) {
        em.persist(member);
    }

    public Member findOne(Long id) {
        return em.find(Member.class, id);
    }

    public List<Member> findAll() {
        /**
         * JPQL 과 SQL을 차이점
         * - JPQL은 엔티티 객체를 대상으로 쿼리한다. -> Entity Member를 조회해
         * - SQL은 데이터베이스 테이블을 대상으로 쿼리한다. -> Table Member를 조회해
         */
        return em.createQuery("select m from Member m", Member.class)
                .getResultList();
    }

    public List<Member> findByName(String name) {
        // JPQL을 사용한다: JPQL, Member 클래스
        return em.createQuery("select m from Member m where m.name = :name", Member.class)
                .setParameter("name", name)
                .getResultList();
    }

}
