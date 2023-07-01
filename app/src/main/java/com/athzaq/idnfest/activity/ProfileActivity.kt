package com.athzaq.idnfest.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.athzaq.idnfest.R

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val imageView = findViewById<ImageView>(R.id.img_github)
        imageView.setImageResource(R.drawable.github)
    }
}