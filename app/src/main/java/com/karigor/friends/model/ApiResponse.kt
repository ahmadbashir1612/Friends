package com.karigor.friends.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ApiResponse {

    @SerializedName("results")
    @Expose
    private List<Result> results;

    public List<Result> getResults() {
        return results;
    }
}
