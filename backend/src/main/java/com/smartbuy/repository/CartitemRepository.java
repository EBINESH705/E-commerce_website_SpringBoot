package com.smartbuy.repository;

import com.smartbuy.model.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartitemRepository extends JpaRepository<CartItem, Long> {
  public List<CartItem> findByUserid(Long user_id);
}
