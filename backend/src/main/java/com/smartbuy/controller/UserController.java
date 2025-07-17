package com.smartbuy.controller;

import com.smartbuy.config.JwtUtil;
import com.smartbuy.model.LoginResponse;
import com.smartbuy.model.User;
import com.smartbuy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("api/users")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody User user){
        return ResponseEntity.ok(userService.register(user));
    }

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestParam String email, @RequestParam String password) {
        return userService.login(email, password)
                .map(user -> {
                    String token = jwtUtil.generateToken(user.getEmail());
                    return ResponseEntity.ok(new LoginResponse(user, token));
                })
                .orElseGet(() -> ResponseEntity.status(401).body(new LoginResponse("Invalid credentials")));
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getuser(@PathVariable Long id){
        return userService.getUserById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
}