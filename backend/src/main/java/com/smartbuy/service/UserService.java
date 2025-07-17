package com.smartbuy.service;

import com.smartbuy.model.User;
import com.smartbuy.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;


    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public User register(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }
    public Optional<User> login(String email, String password) {
        Optional<User> user = userRepository.findByEmail(email);
        // Fix: Use passwordEncoder.matches() instead of equals()
        if (user.isPresent() && passwordEncoder.matches(password, user.get().getPassword())) {
            return user;
        }
        return Optional.empty();
    }
    public Optional<User> getUserById(Long id){
        return userRepository.findById(id);
    }
}
