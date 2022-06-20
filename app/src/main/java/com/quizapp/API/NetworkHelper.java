package com.quizapp.API;

import java.util.HashMap;
import java.util.Map;

class NetworkHelper {

    private static final String TAG = "NetworkHelper";
    private static String HEADER_AUTHORIZATION = "authorization";
    private static boolean isRefreshAPICalled;

    static Map<String, String> getHeaders() {
        Map<String, String> headers = new HashMap<>();
        headers.put(HEADER_AUTHORIZATION, "");
        return headers;
    }
/*

    static <T> void callAPI(Call<T> apiCall, NetworkCallback onSuccess, NetworkErrorCallback onError) {
        if (!Utils.isNetworkAvailable()) {
            if (onError != null) {
                onError.onError(new NetworkError("No internet connection"));
            }
        }
        try {
            apiCall.clone().enqueue(new Callback<T>() {
                @Override
                public void onResponse(@NotNull Call<T> call, @NotNull Response<T> response) {
                    if (response.isSuccessful() && response.code() == 200 && response.body() != null) {
                        int responseCode = ((ApiResponse) response.body()).getStatus();
                        if (responseCode == 200) {
                            if (onSuccess != null) {
                                onSuccess.onResponse(response.body());
                            }
                        } else {
                            if (onError != null) {
                                onError.onError(new NetworkError(responseCode, ((ApiResponse) response.body()).getMsg()));
                            }
                        }
                    } else {
                        if (onError != null) {
                            onError.onError(new NetworkError(response.code(), "Network Unreachable!"));
                        }
                    }
                }

                @Override
                public void onFailure(@NotNull Call<T> call, @NotNull Throwable t) {
                    if (onError != null) {
                        onError.onError(new NetworkError(500, "Network Unreachable!"));
                    }
                }
            });
        } catch (Exception ex) {
            if (onError != null) {
                onError.onError(new NetworkError("API Fail"));
            }
        }
    }
*/

}
