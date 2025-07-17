package com.smartbuy.controller;

import com.smartbuy.model.CartItem;
import com.smartbuy.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cart")
@CrossOrigin(origins = "http://localhost:3000")
public class CartController {
    @Autowired CartService cartService;

    @PostMapping(value = "/add")
    public ResponseEntity<CartItem> addToCart(@RequestParam Long userid,@RequestParam Long productId,@RequestParam int quantity){
        return ResponseEntity.ok(cartService.addToCart(userid,productId,quantity));
    }
    @GetMapping("/{userid}")
    public ResponseEntity<List<CartItem>> getCart(@PathVariable Long userid){
        return ResponseEntity.ok(cartService.getCartByUser(userid));
    }
    @DeleteMapping("/remove/{cartItemId}")
    public ResponseEntity<String> removeItem(@PathVariable Long cartItemId) {
        cartService.removeFromCart(cartItemId);
        return ResponseEntity.ok("Item removed");
    }
    @DeleteMapping("/clear/{userid}")
    public ResponseEntity<String> clearcart(@PathVariable Long userid){
        cartService.clearCart(userid);
        return ResponseEntity.ok("cart cleared");
    }
}
