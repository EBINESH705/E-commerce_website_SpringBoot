package com.smartbuy.repository;

import com.smartbuy.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order,Long> {
    List<Order>findByuser_id(Long userid);
}
