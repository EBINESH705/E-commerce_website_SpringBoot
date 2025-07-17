package com.smartbuy.model;

public class LoginResponse {
    private User user;
    private String message;
    private boolean success;
    private String token;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LoginResponse(User user, String token) {
        this.user = user;
        this.token = token;
        this.success = true;
    }

    public LoginResponse(String message) {
        this.message = message;
        this.success = false;
    }

    // Add getters
    public String getToken() {
        return token;
    }
}