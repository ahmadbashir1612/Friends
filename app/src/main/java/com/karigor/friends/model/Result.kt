package com.karigor.friends.model

import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose
import java.io.Serializable

class Result : Serializable {
    @SerializedName("gender")
    @Expose
    val gender: String? = null

    @SerializedName("name")
    @Expose
    val name: Name? = null

    @SerializedName("picture")
    @Expose
    val picture: Picture? = null

    @SerializedName("phone")
    @Expose
    val phone: String? = null

    @SerializedName("email")
    @Expose
    val email: String? = null

    @SerializedName("location")
    @Expose
    val location: Location? = null
}