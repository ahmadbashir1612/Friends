package com.karigor.friends.viewmodel;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.karigor.friends.model.Result;
import com.karigor.friends.repository.FriendRepository;

import java.util.List;

public class FriendListViewModel extends ViewModel {
    private LiveData<List<Result>> results;

    public void init(Context context){
        if(results==null){

            results=FriendRepository.getInstance(context).getResultLiveData();
            FriendRepository.getInstance(context).CallApiForGetFriends(10);
        }
    }

//    public void CallApiForGetFriends(Context context) {
//
//    }

    public LiveData<List<Result>> getResults() {
        return results;
    }

}
