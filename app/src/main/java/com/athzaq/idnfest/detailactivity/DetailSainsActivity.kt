package com.athzaq.idnfest.detailactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import coil.load
import com.athzaq.idnfest.R
import com.athzaq.idnfest.databinding.ActivityDetailSainsBinding

class DetailSainsActivity : AppCompatActivity() {

    private lateinit var binding : ActivityDetailSainsBinding

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
        binding = ActivityDetailSainsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.txtDetailContextsains.text = intent.getStringExtra(Content)
        binding.txtDetailAuthornewssains.text = intent.getStringExtra(Author)
        binding.txtDetailPublishednewssains.text = intent.getStringExtra(PublishedAt)
        binding.txtDetailDesksains.text = intent.getStringExtra(Description)
        binding.txtDetailTitlenewssains.text = intent.getStringExtra(Title)
        binding.imgDetailNewssains.load(intent.getStringExtra(UrlImage))
    }
}