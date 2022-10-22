package com.athzaq.idnfest.kategoriactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.athzaq.idnfest.R
import com.athzaq.idnfest.adapter.AdapterSports
import com.athzaq.idnfest.databinding.ActivitySportsBinding
import com.athzaq.idnfest.model.ResponseNews
import com.athzaq.idnfest.service.RetrofitBuild
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SportsActivity : AppCompatActivity() {

    private lateinit var binding : ActivitySportsBinding
    private val sportsadapter = AdapterSports()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySportsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            recyclersports.adapter = sportsadapter
            recyclersports.layoutManager = LinearLayoutManager(this@SportsActivity)
            recyclersports.setHasFixedSize(true)
        }
        val call = RetrofitBuild.getServiceSports().headlinesSports()
        call.enqueue(object : Callback<ResponseNews>{
            override fun onResponse(call: Call<ResponseNews>, response: Response<ResponseNews>) {
                val articlesItem = response.body()?.articles
                articlesItem.let {
                    it?.let { it1 -> sportsadapter.addDataSports(it1) }
                }
            }

            override fun onFailure(call: Call<ResponseNews>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }
}