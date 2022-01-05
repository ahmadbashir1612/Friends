package com.karigor.friends.repository

import android.content.Context
import androidx.lifecycle.MutableLiveData
import com.karigor.friends.model.ApiResponse
import com.karigor.friends.http.retrofit.APIService
import androidx.lifecycle.LiveData
import com.karigor.friends.http.Url
import com.karigor.friends.http.retrofit.Client
import com.karigor.friends.model.Result
import com.karigor.friends.repository.FriendRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.jvm.Synchronized

class FriendRepository private constructor(var context: Context) {
    private val resultLiveData: MutableLiveData<List<Result>?>
    fun CallApiForGetFriends(number: Int) {
        Client.resetApiClient()
        val call = Client.getClient(Url.base_url, "").create(
            APIService::class.java
        )
            .getRandomFriends(number)
        call.enqueue(object : Callback<ApiResponse> {
            override fun onResponse(call: Call<ApiResponse>, response: Response<ApiResponse>) {
                if (response.isSuccessful) {
                    if (response.body()!!.results != null) {
                        resultLiveData.postValue(response.body()!!.results)
                    } else {
                        resultLiveData.postValue(null)
                    }
                } else {
                    resultLiveData.postValue(null)
                }
            }

            override fun onFailure(call: Call<ApiResponse>, t: Throwable) {
                //     Toasty.error(context, t.getMessage(), Toast.LENGTH_SHORT, true).show();
                resultLiveData.postValue(null)
            }
        })
    }

    fun getResultLiveData(): LiveData<List<Result>?> {
        return resultLiveData
    }

    companion object {
        private var instance: FriendRepository? = null
        @JvmStatic
        @Synchronized
        fun getInstance(context: Context): FriendRepository? {
            if (instance == null) {
                instance = FriendRepository(context)
            }
            return instance
        }
    }

    init {
        resultLiveData = MutableLiveData()
    }
}