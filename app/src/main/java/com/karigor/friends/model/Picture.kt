package com.karigor.friends.model

import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose
import java.io.Serializable

class Picture : Serializable {
    @SerializedName("large")
    @Expose
    val large: String? = null

    @SerializedName("medium")
    @Expose
    val medium: String? = null

    @SerializedName("thumbnail")
    @Expose
    val thumbnail: String? = null
}