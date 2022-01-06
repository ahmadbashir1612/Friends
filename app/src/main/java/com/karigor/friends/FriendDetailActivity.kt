package com.karigor.friends

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.OnClick
import com.bumptech.glide.Glide
import com.karigor.friends.R
import com.karigor.friends.model.Result
import android.content.Intent




class FriendDetailActivity : AppCompatActivity() {

    @BindView(R.id.full_name_text_view)
    lateinit var fullNameTextView: TextView
    @BindView(R.id.friend_image_view)
    lateinit var friendImageView: ImageView
    @BindView(R.id.address_text_view)
    lateinit var addressTextView: TextView
    @BindView(R.id.city_text_view)
    lateinit var cityTextView: TextView
    @BindView(R.id.state_text_view)
    lateinit var stateTextView: TextView
    @BindView(R.id.country_text_view)
    lateinit var countryTextView: TextView
    @BindView(R.id.email_text_view)
    lateinit var emailTextView: TextView
    @BindView(R.id.phone_text_view)
    lateinit var phoneTextView: TextView
    lateinit var friend: Result

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_friend_detail)

        supportActionBar?.setDisplayHomeAsUpEnabled(true);
        supportActionBar?.setDisplayShowHomeEnabled(true);
        ButterKnife.bind(this)

        friend= intent.extras?.getSerializable("FRIEND") as Result

        val circularProgressDrawable = CircularProgressDrawable(this)
        circularProgressDrawable.strokeWidth = 5f
        circularProgressDrawable.centerRadius = 30f
        circularProgressDrawable.start()
        Glide.with(this).load(friend.picture!!.large)
            //  .diskCacheStrategy(DiskCacheStrategy.NONE)
            //  .skipMemoryCache(true)
            //  .priority(Priority.IMMEDIATE)
            .placeholder(circularProgressDrawable)
            .error(R.drawable.noprofile)
            .into(friendImageView)

        fullNameTextView.text = "Full Name : "+friend.name!!.title + " " + friend.name!!.first + " " + friend.name!!.last
        addressTextView.text = "Address : "+friend.location!!.street!!.number.toString()+ " "+friend.location!!.street!!.name
        cityTextView.text = "City : "+friend.location!!.city
        stateTextView.text = "State : "+friend.location!!.state
        countryTextView.text = "Country : "+friend.location!!.country
        emailTextView.text = "Email : "+friend.email+" "
        phoneTextView.text = "Phone : "+friend.phone


    }

    @OnClick(R.id.email_text_view)
    fun emailPressed() {
        val intent = Intent(Intent.ACTION_SEND)
        intent.putExtra(Intent.EXTRA_EMAIL, arrayOf(friend.email))
//        intent.putExtra(Intent.EXTRA_SUBJECT, subject)
//        intent.putExtra(Intent.EXTRA_TEXT, message)
            .setPackage("com.google.android.gm");
        intent.type = "message/rfc822"
        startActivity(Intent.createChooser(intent, "Choose an email client"))
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle item selection
        return when (item.getItemId()) {
            android.R.id.home -> {
                finish()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}