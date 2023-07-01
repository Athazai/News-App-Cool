package com.athzaq.idnfest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.athzaq.idnfest.activity.NewsIndoActivity
import com.athzaq.idnfest.activity.ProfileActivity
import com.athzaq.idnfest.databinding.ActivityMainBinding
import com.athzaq.idnfest.kategoriactivity.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
//    private val hargaadapter = AdapterDoa()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.cvIndonesiaNews.setOnClickListener {
            startActivity(Intent(this, NewsIndoActivity::class.java))
        }
        binding.cvBisnis.setOnClickListener {
            startActivity(Intent(this, BisnisActivity::class.java))
        }
        binding.cvEntertaiment.setOnClickListener {
            startActivity(Intent(this, EntertaimentActivity::class.java))
        }
        binding.cvSains.setOnClickListener {
            startActivity(Intent(this, SainsActivity::class.java))
        }
        binding.cvSports.setOnClickListener {
            startActivity(Intent(this, SportsActivity::class.java))
        }
        binding.cvTeknologi.setOnClickListener {
            startActivity(Intent(this, TeknologiActivity::class.java))
        }
        binding.cvHealth.setOnClickListener {
            startActivity(Intent(this, HealthActivity::class.java))
        }
        binding.cvProfile.setOnClickListener {
            startActivity(Intent(this, ProfileActivity::class.java))
        }
    }
}