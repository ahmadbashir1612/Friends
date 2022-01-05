package com.karigor.friends.viewmodel

import android.content.Context
import com.karigor.friends.repository.FriendRepository.Companion.getInstance
import androidx.lifecycle.ViewModel
import androidx.lifecycle.LiveData
import com.karigor.friends.model.Result
import com.karigor.friends.repository.FriendRepository

class FriendListViewModel : ViewModel() {
    //    public void CallApiForGetFriends(Context context) {
    //
    //    }
    var results: LiveData<List<Result>?>? = null
        private set

    fun init(context: Context?) {
        if (results == null) {
            results = getInstance(context!!)!!.getResultLiveData()
            getInstance(context)!!.CallApiForGetFriends(10)
        }
    }
}