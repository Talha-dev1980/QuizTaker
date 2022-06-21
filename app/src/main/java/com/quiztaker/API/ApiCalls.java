package com.quiztaker.API;

import com.quiztaker.Models.RegisterModel;
import com.quiztaker.Models.RegisterResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface ApiCalls {
    @Headers({"x-project: dGVtcGxlb2ZmaXQ6ZGVm", "accept: application/json", "Content-Type: application/json"})
    //@Headers({"x-project: dGVtcGxlb2ZmaXQ6ZGVm"})
    @POST("lambda/register")
    Call<RegisterResponse> registerUser(@Body RegisterModel registerModel);

    /* @POST("user/create")
     Call<ApiResponse<Profile>> createUser(@Body Profile profile);

     @POST("user/update")
     Call<ApiResponse<Profile>> updateUser(@Body Profile profile);

     @POST("user/creditPeek/buy")
     Call<ApiResponse<Profile>> buyPeek(@Body Profile profile);

     @GET("category/all")
     Call<ApiResponse<List<Category>>> getAllCategories();

    @GET
    Call<ApiResponse<UserDetails>> getUserProfile(@Url String url);

    @GET
    Call<ApiResponse<UserDetails>> peekCredit(@Url String url);

    @GET
    Call<ApiResponse<NFT>> getNftDetails(@Url String url);

    @POST("category/update")
    Call<ApiResponse<Integer[]>> setPreferredCategories(@Body PreferredCategory categories);

    @POST("location/near")
    Call<SearchNFTResult> getNearNFTs(@Body UserLocation location);

    @POST("location")
    Call<SearchNFTResult> get10KmNFTs(@Body UserLocation location);

    @GET("notification/get")
    Call<ApiResponse<List<NOtificationModel>>> getNotifications();

    //@Headers({"x-project: dGVtcGxlb2ZmaXQ6ZGVm","accept: application/json"})
    @GET("/lambda/fitbit/login")
    Call<temp_Response> tempFitbitLogin();
//    Call<temp_Response> tempFitbitLogin(String x_project);

    @GET
    Call<ApiResponse<NFT[]>> callMyNFTs(@Url String url);

    @POST("nfts/transfer")
    Call<ApiResponse<NFT>> transferNFTtoUserWallet(@Body TransferNFTparamModel model);

    @POST("user/deviceId")
    Call<ApiResponse<UserDetails>> saveDeviceId(@Body TransferNFTparamModel model);
*/
}
