package com.smartbuy.service;

import com.smartbuy.model.CartItem;
import com.smartbuy.model.Order;
import com.smartbuy.model.OrderItem;
import com.smartbuy.model.User;
import com.smartbuy.repository.CartitemRepository;
import com.smartbuy.repository.OrderRepository;
import com.smartbuy.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepo;

    @Autowired
    private CartitemRepository cartRepo;

    @Autowired
    private UserRepository userRepo;

    public Order placeOrder(Long userid){
        User user = userRepo.findById(userid).orElseThrow();
        List<CartItem> cartItems=cartRepo.findByUserid(userid);
        double total =cartItems.stream().mapToDouble(item->item.getProduct().getPrice()*item.getQuantity()).sum();
        Order order=new Order();
        order.setUser(user);
        order.setOrderDate(LocalDateTime.now());
        order.setStatus("PLACED");
        order.setTotalPrice(total);

        Order finalOrder = order;
        List<OrderItem>orderItems =cartItems.stream().map(item->{
            OrderItem oi= new OrderItem();
            oi.setOrder(finalOrder);
            oi.setProduct(item.getProduct());
            oi.setQuantity(item.getQuantity());
            return oi;
        }).collect(Collectors.toList());
        order.setItems(orderItems);
        order=orderRepo.save(order);
        cartRepo.deleteAll(cartItems);
        return order;
    }

    public List<Order> getUserOrders(Long userid){
        return orderRepo.findByuser_id(userid);
    }
    public List<Order> getAllOrder(){
        return orderRepo.findAll();
    }
}
