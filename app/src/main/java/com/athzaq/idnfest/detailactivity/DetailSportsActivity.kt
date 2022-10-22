package com.athzaq.idnfest.detailactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import coil.load
import com.athzaq.idnfest.R
import com.athzaq.idnfest.databinding.ActivityDetailSportsBinding

class DetailSportsActivity : AppCompatActivity() {

    private lateinit var binding : ActivityDetailSportsBinding

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
        binding = ActivityDetailSportsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.txtDetailContextsports.text = intent.getStringExtra(Content)
        binding.txtDetailAuthornewssports.text = intent.getStringExtra(Author)
        binding.txtDetailPublishednewssports.text = intent.getStringExtra(PublishedAt)
        binding.txtDetailDeskssports.text = intent.getStringExtra(Description)
        binding.txtDetailTitlenewssports.text = intent.getStringExtra(Title)
        binding.imgDetailNewssports.load(intent.getStringExtra(UrlImage))
    }
}