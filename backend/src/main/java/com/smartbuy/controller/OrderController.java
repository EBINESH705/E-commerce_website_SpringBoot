package com.smartbuy.controller;

import com.smartbuy.model.Order;
import com.smartbuy.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
@CrossOrigin(origins = "http://localhost:3000")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping("/checkout/{userid}")
    public ResponseEntity<Order> checkout(@PathVariable Long userid){
        return ResponseEntity.ok(orderService.placeOrder(userid));
    }
    @GetMapping("/user/{userid}")
    public ResponseEntity<List<Order>> getUserOrders(@PathVariable Long userid){
        return  ResponseEntity.ok(orderService.getUserOrders(userid));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Order>> getAllOrders(){
        return ResponseEntity.ok(orderService.getAllOrder());
    }
}
