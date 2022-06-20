package com.quizapp.API;

public interface NetworkCallback<T> {
    void onResponse(T data);
}
