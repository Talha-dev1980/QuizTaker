package com.quiztaker.ViewModels;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.quiztaker.API.ApiCalls;
import com.quiztaker.API.RetrofitClient;
import com.quiztaker.Models.RegisterModel;
import com.quiztaker.Models.RegisterResponse;
import com.quiztaker.Utils.AppLogger;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class JoinCompleteViewModel extends ViewModel {
    private MutableLiveData<RegisterResponse> liveRegResponse;

    public JoinCompleteViewModel() {
        this.liveRegResponse = new MutableLiveData<RegisterResponse>();
    }

    public void startRegisterUser(RegisterModel model) {
        ApiCalls apiCalls = RetrofitClient.getApiCalls();
        // apiCalls.registerUser("dGVtcGxlb2ZmaXQ6ZGVm", model).enqueue(new Callback<RegisterResponse>() {
        apiCalls.registerUser(model).enqueue(new Callback<RegisterResponse>() {
            @Override
            public void onResponse(Call<RegisterResponse> call, Response<RegisterResponse> response) {
                if (response.isSuccessful()) {
                    AppLogger.log("API Call-startRegisterUser", response.code() + "");
                    liveRegResponse.postValue(response.body());
                } else {
                    AppLogger.log("API Call-startRegisterUser", response.code() + "-" + response.body());
                    liveRegResponse.postValue(null);
                }
            }

            @Override
            public void onFailure(Call<RegisterResponse> call, Throwable t) {
                AppLogger.log("API Call-startRegisterUser", t.getMessage() + "");
                liveRegResponse.postValue(null);
            }
        });
    /*    apiCalls.getUserProfile("user/get/0x5490b5F828A39B8D0C489FF5D93cb59ccCFd7303").enqueue(new Callback<ApiResponse<UserDetails>>() {
            @Override
            public void onResponse(Call<ApiResponse<UserDetails>> call, Response<ApiResponse<UserDetails>> response) {
                if (response.isSuccessful()) {
                    AppLogger.log("API Call-startRegisterUser", response.code() + "");
                    // liveRegResponse.postValue(response.body());
                } else {
                    AppLogger.log("API Call-startRegisterUser", response.code() + "");
                    liveRegResponse.postValue(null);
                }
            }

            @Override
            public void onFailure(Call<ApiResponse<UserDetails>> call, Throwable t) {
                AppLogger.log("API Call - callUserDetail", t.getMessage() + "");
            }
        });
   */
    }

    public MutableLiveData<RegisterResponse> getLiveRegResponse() {
        return liveRegResponse;
    }
}
