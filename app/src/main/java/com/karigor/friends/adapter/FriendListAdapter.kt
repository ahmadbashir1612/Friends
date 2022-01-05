package com.karigor.friends.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.CircularProgressDrawable;

import com.bumptech.glide.Glide;
import com.karigor.friends.FriendDetailActivity;
import com.karigor.friends.R;
import com.karigor.friends.model.Result;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class FriendListAdapter extends RecyclerView.Adapter<FriendListAdapter.MyViewHolder> {


private Context context;
private List<Result> results=new ArrayList<>();


    public class MyViewHolder extends RecyclerView.ViewHolder {

    public TextView tvFullName, tvCountry;
    public ImageView ivPortrait;
    public MyViewHolder(View view) {
        super(view);

        ivPortrait = view.findViewById(R.id.image_view);
        tvFullName = view.findViewById(R.id.full_name_text_view);
        tvCountry = view.findViewById(R.id.country_text_view);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                context.startActivity(new Intent(context, FriendDetailActivity.class)
                        .putExtra("Result",results.get(getAdapterPosition())));

            }
        });

    }

}

    public FriendListAdapter(Context context) {
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.result_list_item, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        Result result = results.get(position);

        holder.tvFullName.setText(result.getName().getTitle()+" "+result.getName().getFirst()+" "+result.getName().getLast());
        CircularProgressDrawable circularProgressDrawable = new CircularProgressDrawable(context);
        circularProgressDrawable.setStrokeWidth(5f);
        circularProgressDrawable.setCenterRadius (30f);
        circularProgressDrawable.start();
        Glide.with(context).load(result.getPicture().getLarge())
//                .diskCacheStrategy(DiskCacheStrategy.NONE)
//                .skipMemoryCache(true)
//                .priority(Priority.IMMEDIATE)
                    .placeholder(circularProgressDrawable)
                    .error(R.drawable.noprofile)
                    .into(holder.ivPortrait);

        holder.tvCountry.setText( result.getLocation().getCountry());

    }

    public void setResults(List<Result> list){
        this.results = list;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return results.size();
    }
}

