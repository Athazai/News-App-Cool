package com.athzaq.idnfest.kategoriactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.athzaq.idnfest.R
import com.athzaq.idnfest.adapter.AdapterBisnis
import com.athzaq.idnfest.databinding.ActivityBisnisBinding
import com.athzaq.idnfest.model.ResponseNews
import com.athzaq.idnfest.service.RetrofitBuild
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BisnisActivity : AppCompatActivity() {

    private lateinit var binding : ActivityBisnisBinding
    private val bisnisadapter = AdapterBisnis()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBisnisBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            recyclerbisnis.adapter = bisnisadapter
            recyclerbisnis.layoutManager = LinearLayoutManager(this@BisnisActivity)
            recyclerbisnis.setHasFixedSize(true)
        }
        val call = RetrofitBuild.getServiceBisnis().headlinesBisnis()
        call.enqueue(object : Callback<ResponseNews>{
            override fun onResponse(call: Call<ResponseNews>, response: Response<ResponseNews>) {
                val listArticlesItem = response.body()?.articles
                listArticlesItem.let {
                    it?.let { it1 -> bisnisadapter.addDataBisnis(it1) }
                }
            }

            override fun onFailure(call: Call<ResponseNews>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })

    }
}