package com.athzaq.idnfest.detailactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import coil.load
import com.athzaq.idnfest.R
import com.athzaq.idnfest.databinding.ActivityDetailHealthBinding
import com.athzaq.idnfest.databinding.ActivityHealthBinding

class DetailHealthActivity : AppCompatActivity() {

    private lateinit var binding : ActivityDetailHealthBinding

    companion object {
        const val PublishedAt = "P"
        const val Author = "A"
        const val UrlImage = "UrlImage"
        const val Description = "D"
        const val Source = "S"
        const val Title = "T"
        const val Url = "url"
        const val Content = "C"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailHealthBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.txtDetailContexthealth.text = intent.getStringExtra(Content)
        binding.txtDetailAuthornewshealth.text = intent.getStringExtra(Author)
        binding.txtDetailPublishednewshealth.text = intent.getStringExtra(PublishedAt)
        binding.txtDetailDeskhealth.text = intent.getStringExtra(Description)
        binding.txtDetailTitlenewshealth.text = intent.getStringExtra(Title)
        binding.imgDetailNewshealth.load(intent.getStringExtra(UrlImage))

    }
}