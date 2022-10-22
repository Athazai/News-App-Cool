package com.athzaq.idnfest.detailactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import coil.load
import com.athzaq.idnfest.R
import com.athzaq.idnfest.databinding.ActivityDetailTeknologiBinding

class DetailTeknologiActivity : AppCompatActivity() {

    private lateinit var binding : ActivityDetailTeknologiBinding

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
        binding = ActivityDetailTeknologiBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.txtDetailContextteknologi.text = intent.getStringExtra(Content)
        binding.txtDetailAuthornewsteknologi.text = intent.getStringExtra(Author)
        binding.txtDetailPublishednewsteknologi.text = intent.getStringExtra(PublishedAt)
        binding.txtDetailDeskteknologi.text = intent.getStringExtra(Description)
        binding.txtDetailTitlenewsteknologi.text = intent.getStringExtra(Title)
        binding.imgDetailNewsteknologi.load(intent.getStringExtra(UrlImage))

    }
}