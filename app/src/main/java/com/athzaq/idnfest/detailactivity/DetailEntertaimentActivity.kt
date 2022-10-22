package com.athzaq.idnfest.detailactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import coil.load
import com.athzaq.idnfest.R
import com.athzaq.idnfest.databinding.ActivityDetailEntertaimentBinding

class DetailEntertaimentActivity : AppCompatActivity() {

    private lateinit var binding : ActivityDetailEntertaimentBinding

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
        binding = ActivityDetailEntertaimentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.txtDetailContextentertaiment.text = intent.getStringExtra(Content)
        binding.txtDetailAuthornewsentertaiment.text = intent.getStringExtra(Author)
        binding.txtDetailPublishednewsentertaiment.text = intent.getStringExtra(PublishedAt)
        binding.txtDetailDeskentertaiment.text = intent.getStringExtra(Description)
        binding.txtDetailTitlenewsentertaiment.text = intent.getStringExtra(Title)
        binding.imgDetailNewsentertaiment.load(intent.getStringExtra(UrlImage))
    }
}