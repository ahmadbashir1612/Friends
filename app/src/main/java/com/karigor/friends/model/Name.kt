package com.karigor.friends.model

import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose
import java.io.Serializable

class Name : Serializable {
    @SerializedName("title")
    @Expose
    val title: String? = null

    @SerializedName("first")
    @Expose
    val first: String? = null

    @SerializedName("last")
    @Expose
    val last: String? = null
}