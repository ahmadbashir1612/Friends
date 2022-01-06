package com.karigor.friends.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

class Street : Serializable {

    @SerializedName("number")
    @Expose
    val number: Int? = null

    @SerializedName("name")
    @Expose
    val name: String? = null

}