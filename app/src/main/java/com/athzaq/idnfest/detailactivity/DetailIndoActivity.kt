package com.athzaq.idnfest.detailactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import coil.load
import com.athzaq.idnfest.databinding.ActivityDetailIndoBinding

class DetailIndoActivity : AppCompatActivity() {

    private lateinit var binding : ActivityDetailIndoBinding

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
        binding = ActivityDetailIndoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.txtDetailContextindo.text = intent.getStringExtra(DetailBisnisActivity.Content)
        binding.txtDetailAuthornewsindo.text = intent.getStringExtra(DetailBisnisActivity.Author)
        binding.txtDetailPublishednewsindo.text = intent.getStringExtra(DetailBisnisActivity.PublishedAt)
        binding.txtDetailDeskindo.text = intent.getStringExtra(DetailBisnisActivity.Description)
        binding.txtDetailTitlenewsindo.text = intent.getStringExtra(DetailBisnisActivity.Title)
        binding.imgDetailNewsbisnis.load(intent.getStringExtra(DetailBisnisActivity.UrlImage))
    }
}