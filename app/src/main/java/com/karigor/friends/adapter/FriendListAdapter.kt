package com.karigor.friends.adapter

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import com.karigor.friends.adapter.FriendListAdapter.MyViewHolder
import android.widget.TextView
import com.karigor.friends.R
import android.content.Intent
import com.karigor.friends.FriendDetailActivity
import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.karigor.friends.model.Result
import java.util.ArrayList

class FriendListAdapter(private val context: Context) : RecyclerView.Adapter<MyViewHolder>() {
    private var results: List<Result> = ArrayList()

    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var tvFullName: TextView
        var tvCountry: TextView
        var ivPortrait: ImageView

        init {
            ivPortrait = view.findViewById(R.id.image_view)
            tvFullName = view.findViewById(R.id.full_name_text_view)
            tvCountry = view.findViewById(R.id.country_text_view)
            view.setOnClickListener {
                context.startActivity(
                    Intent(context, FriendDetailActivity::class.java)
                        .putExtra("Result", results[adapterPosition])
                )
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.result_list_item, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val result = results[position]
        holder.tvFullName.text =
            result.name!!.title + " " + result.name.first + " " + result.name.last
        val circularProgressDrawable = CircularProgressDrawable(context)
        circularProgressDrawable.strokeWidth = 5f
        circularProgressDrawable.centerRadius = 30f
        circularProgressDrawable.start()
        Glide.with(context)
            .load(result.picture!!.large) //                .diskCacheStrategy(DiskCacheStrategy.NONE)
            //                .skipMemoryCache(true)
            //                .priority(Priority.IMMEDIATE)
            .placeholder(circularProgressDrawable)
            .error(R.drawable.noprofile)
            .into(holder.ivPortrait)
        holder.tvCountry.text = result.location!!.country
    }

    fun setResults(list: List<Result>) {
        results = list
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return results.size
    }
}