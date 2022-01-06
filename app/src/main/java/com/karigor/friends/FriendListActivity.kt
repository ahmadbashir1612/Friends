package com.karigor.friends

import androidx.appcompat.app.AppCompatActivity
import butterknife.BindView
import com.karigor.friends.R
import androidx.recyclerview.widget.RecyclerView
import com.karigor.friends.adapter.FriendListAdapter
import com.karigor.friends.viewmodel.FriendListViewModel
import android.os.Bundle
import androidx.lifecycle.Observer
import butterknife.ButterKnife
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.DefaultItemAnimator
import com.karigor.friends.model.Result

class FriendListActivity : AppCompatActivity() {

    @BindView(R.id.friend_list_view) lateinit var friendListView: RecyclerView
    private var friendListAdapter: FriendListAdapter? = null
    private var viewModel: FriendListViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar!!.title = "Friend List"

        ButterKnife.bind(this)
        setupPackageRV()

        viewModel = ViewModelProvider(this).get(FriendListViewModel::class.java)
        viewModel!!.init(this)
        viewModel!!.results?.observe(this,
            { results ->
                if (results != null) {
                    friendListAdapter!!.setResults(results)
                }
            })

//        viewModel.CallApiForGetFriends(this);
    }

    private fun setupPackageRV() {
        val gridLayoutManager = GridLayoutManager(applicationContext, 2)
        friendListView!!.layoutManager = gridLayoutManager
        friendListView!!.itemAnimator = DefaultItemAnimator()
        friendListAdapter = FriendListAdapter(this)
        friendListView!!.adapter = friendListAdapter
    }
}