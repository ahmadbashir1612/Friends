package com.karigor.friends.model

import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose

class ApiResponse {
    @SerializedName("results")
    @Expose
    val results: List<Result>? = null
}