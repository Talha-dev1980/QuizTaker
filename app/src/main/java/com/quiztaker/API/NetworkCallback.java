package com.quiztaker.API;

public interface NetworkCallback<T> {
    void onResponse(T data);
}
