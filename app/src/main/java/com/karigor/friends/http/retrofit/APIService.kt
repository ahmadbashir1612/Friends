package com.karigor.friends.http.retrofit

import retrofit2.http.GET
import com.karigor.friends.model.ApiResponse
import retrofit2.Call
import retrofit2.http.Headers
import retrofit2.http.Query

interface APIService {
    @Headers("Content-Type:application/json")
    @GET("api")
    fun getRandomFriends(@Query("results") resultNumber: Int): Call<ApiResponse>?
}