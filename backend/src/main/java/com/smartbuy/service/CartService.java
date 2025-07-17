package com.smartbuy.service;

import com.smartbuy.model.CartItem;
import com.smartbuy.model.Product;
import com.smartbuy.repository.CartitemRepository;
import com.smartbuy.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {
    @Autowired
    private CartitemRepository cartRepo;

    @Autowired
    private ProductRepository productRepo;

    public CartItem addToCart(Long userid, Long productId,int quality){
        Product product = productRepo.findById(productId).orElseThrow(()->new RuntimeException("Product not found"));
        CartItem item= new CartItem();
        item.setUserid(userid);
        item.setProduct(product);
        item.setQuantity(quality);

        return  cartRepo.save(item);
    }
    public List<CartItem> getCartByUser(Long id){
        return cartRepo.findByUserid(id);
    }
    public  void  removeFromCart(Long cartItemId){
        cartRepo.deleteById(cartItemId);
    }
    public  void  clearCart(Long userId){
        cartRepo.findByUserid(userId).forEach(item->cartRepo.deleteById(item.getId()));
    }
}
