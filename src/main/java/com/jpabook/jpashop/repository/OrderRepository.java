package com.jpabook.jpashop.repository;

import com.jpabook.jpashop.domain.Order;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class OrderRepository {

    private final EntityManager em;

    public void save(Order order) {
        em.persist(order);
    }

    public Order findOne(Long orderId) {
        return em.find(Order.class, orderId);
    }

    // TODO: 주문 리포지토리에는 주문 엔티티를 저장하고 검색하는 기능이 있다.
//    public List<Order> findAll(OrderSerach orderSerach) {}

}
