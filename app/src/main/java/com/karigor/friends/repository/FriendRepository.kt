package com.karigor.friends.repository;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;


import com.karigor.friends.http.Url;
import com.karigor.friends.http.retrofit.APIService;
import com.karigor.friends.http.retrofit.Client;
import com.karigor.friends.model.ApiResponse;
import com.karigor.friends.model.Result;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class FriendRepository {
    Context context;
    private MutableLiveData<List<Result>> resultLiveData;
    private static FriendRepository instance;

    public synchronized static FriendRepository getInstance(Context context) {
        if (instance == null) {
            instance = new FriendRepository(context);
        }

        return instance;
    }

    private FriendRepository(Context context) {
        this.context = context;
        resultLiveData = new MutableLiveData<>();

    }


    public void CallApiForGetFriends( int number) {

        Client.resetApiClient();
        Call<ApiResponse> call = Client.getClient(Url.base_url, "").create(APIService.class)
                .getRandomFriends(number);
        call.enqueue(new Callback<ApiResponse>() {
            @Override
            public void onResponse(@NonNull Call<ApiResponse> call, @NonNull Response<ApiResponse> response) {
                if (response.isSuccessful()) {

                    if (response.body().getResults() != null) {
                        resultLiveData.postValue(response.body().getResults());
                    } else {
                        resultLiveData.postValue(null);
                    }

                } else {

                    resultLiveData.postValue(null);

                }
            }

            @Override
            public void onFailure(@NonNull Call<ApiResponse> call, @NonNull Throwable t) {
                //     Toasty.error(context, t.getMessage(), Toast.LENGTH_SHORT, true).show();
                resultLiveData.postValue(null);
            }
        });

    }

    public LiveData<List<Result>> getResultLiveData() {
        return resultLiveData;
    }

}

