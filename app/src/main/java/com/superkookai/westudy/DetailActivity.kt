package com.superkookai.westudy

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.squareup.picasso.Picasso

class DetailActivity : AppCompatActivity() {

    var title: TextView? = null
    var desc: TextView? = null
//    var photo: ImageView? = null
    var videoView: VideoView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        title = findViewById(R.id.tv_title)
        desc = findViewById(R.id.tv_desc)
//        photo = findViewById(R.id.iv_photo)
        videoView = findViewById(R.id.videoPlayer)

        val intent = intent
        title!!.text = intent.getStringExtra("TITLE")
        desc!!.text = intent.getStringExtra("DESC")
//        Picasso.get().load(intent.getStringExtra("PHOTO"))
//            .error(R.mipmap.ic_launcher)
//            .placeholder(R.drawable.placeholder)
//            .into(photo)

        val linkUrl = intent.getStringExtra("VIDEO")
        videoView!!.setVideoURI(Uri.parse(linkUrl))
        videoView!!.setMediaController(MediaController(this))
        videoView!!.requestFocus()
        videoView!!.start()
    }
}