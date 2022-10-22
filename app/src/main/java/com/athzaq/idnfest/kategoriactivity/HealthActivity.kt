package com.athzaq.idnfest.kategoriactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.athzaq.idnfest.R
import com.athzaq.idnfest.adapter.AdapterHeath
import com.athzaq.idnfest.databinding.ActivityHealthBinding
import com.athzaq.idnfest.model.ResponseNews
import com.athzaq.idnfest.service.RetrofitBuild
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HealthActivity : AppCompatActivity() {

    private lateinit var binding : ActivityHealthBinding
    private val adapterhealth = AdapterHeath()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHealthBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            recyclerhealth.adapter = adapterhealth
            recyclerhealth.layoutManager = LinearLayoutManager(this@HealthActivity)
            recyclerhealth.setHasFixedSize(true)
        }
        val call = RetrofitBuild.getServiceHealth().headlinesHealth()
        call.enqueue(object : Callback<ResponseNews>{
            override fun onResponse(call: Call<ResponseNews>, response: Response<ResponseNews>) {
                val articlesItem = response.body()?.articles
                articlesItem.let {
                    it?.let { it1 -> adapterhealth.addDataHealth(it1) }
                }
            }

            override fun onFailure(call: Call<ResponseNews>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }
}