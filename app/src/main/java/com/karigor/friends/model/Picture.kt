package com.karigor.friends.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Picture  implements Serializable {
    @SerializedName("large")
    @Expose
    private String large;
    @SerializedName("medium")
    @Expose
    private String medium;
    @SerializedName("thumbnail")
    @Expose
    private String thumbnail;

    public String getLarge() {
        return large;
    }

    public String getMedium() {
        return medium;
    }

    public String getThumbnail() {
        return thumbnail;
    }
}
