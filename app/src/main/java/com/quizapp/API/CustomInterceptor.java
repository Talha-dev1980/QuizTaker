package com.quizapp.API;

import java.io.IOException;

import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.Response;

public class CustomInterceptor implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {
        return chain.proceed(chain.request().newBuilder().headers(Headers.of(NetworkHelper.getHeaders()))
                .addHeader("x-project", "dGVtcGxlb2ZmaXQ6ZGVm").build());
    }

}