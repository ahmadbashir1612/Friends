package com.karigor.friends;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.karigor.friends.adapter.FriendListAdapter;
import com.karigor.friends.model.Result;
import com.karigor.friends.viewmodel.FriendListViewModel;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FriendListActivity extends AppCompatActivity {

    @BindView(R.id.friend_list_view)
    RecyclerView friendListView;

    private FriendListAdapter friendListAdapter;
    private FriendListViewModel viewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        setupPackageRV();

        getSupportActionBar().setTitle("Friend List");
        viewModel = new ViewModelProvider(this).get(FriendListViewModel.class);
        viewModel.init(this);
        viewModel.getResults().observe(this, new Observer<List<Result>>() {
            @Override
            public void onChanged(List<Result> results) {
                if (results != null) {
                    friendListAdapter.setResults(results);
                }
            }
        });

//        viewModel.CallApiForGetFriends(this);

    }

    private void setupPackageRV() {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(), 2);
        friendListView.setLayoutManager(gridLayoutManager);
        friendListView.setItemAnimator(new DefaultItemAnimator());
        friendListAdapter = new FriendListAdapter(this);
        friendListView.setAdapter(friendListAdapter);

    }
}