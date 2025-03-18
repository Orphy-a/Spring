package kr.co.ch07.repository.shop;

import kr.co.ch07.entity.shop.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public class OrderRepository extends JpaRepository<Order, long> {
}
