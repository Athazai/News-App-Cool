package com.athzaq.idnfest.detailactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import coil.load
import com.athzaq.idnfest.R
import com.athzaq.idnfest.databinding.ActivityDetailBisnisBinding

class DetailBisnisActivity : AppCompatActivity() {

    private lateinit var binding : ActivityDetailBisnisBinding

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
        binding = ActivityDetailBisnisBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.txtDetailContextbisnis.text = intent.getStringExtra(Content)
        binding.txtDetailAuthornewsbisnis.text = intent.getStringExtra(Author)
        binding.txtDetailPublishednewsbisnis.text = intent.getStringExtra(PublishedAt)
        binding.txtDetailDeskbisnis.text = intent.getStringExtra(Description)
        binding.txtDetailTitlenewsbisnis.text = intent.getStringExtra(Title)
        binding.imgDetailNewsbisnis.load(intent.getStringExtra(UrlImage))

    }
}