package com.karigor.friends.model

import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose
import java.io.Serializable

class Location : Serializable {
    @SerializedName("city")
    @Expose
    val city: String? = null

    @SerializedName("state")
    @Expose
    val state: String? = null

    @SerializedName("street")
    @Expose
    val street: Street? = null

    @SerializedName("country")
    @Expose
    val country: String? = null
}