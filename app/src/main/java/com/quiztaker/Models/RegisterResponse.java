package com.quiztaker.Models;

public class RegisterResponse {
    boolean error;
    String role;
    String token;
    int expire_at;
    int user_id;
    String message;
    int code;

    public RegisterResponse() {
    }

    public RegisterResponse(boolean error, String role, String token, int expire_at, int user_id, String message, int code) {
        this.error = error;
        this.role = role;
        this.token = token;
        this.expire_at = expire_at;
        this.user_id = user_id;
        this.message = message;
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getExpire_at() {
        return expire_at;
    }

    public void setExpire_at(int expire_at) {
        this.expire_at = expire_at;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
}
