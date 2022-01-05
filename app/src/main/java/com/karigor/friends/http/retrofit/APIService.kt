package com.karigor.friends.http.retrofit;


import com.karigor.friends.model.ApiResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface APIService {


    @Headers("Content-Type:application/json")
    @GET("api")
    Call<ApiResponse> getRandomFriends(@Query("results") int resultNumber);


}
