package com.athzaq.idnfest.kategoriactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.athzaq.idnfest.R
import com.athzaq.idnfest.adapter.AdapterSains
import com.athzaq.idnfest.databinding.ActivitySainsBinding
import com.athzaq.idnfest.model.ResponseNews
import com.athzaq.idnfest.service.RetrofitBuild
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SainsActivity : AppCompatActivity() {

    private lateinit var binding : ActivitySainsBinding
    private val sainsAdapter = AdapterSains()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySainsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            recyclersains.adapter = sainsAdapter
            recyclersains.layoutManager = LinearLayoutManager(this@SainsActivity)
            recyclersains.setHasFixedSize(true)
        }
        val call = RetrofitBuild.getServiceScience().headlinesSains()
        call.enqueue(object : Callback<ResponseNews>{
            override fun onResponse(call: Call<ResponseNews>, response: Response<ResponseNews>) {
                val articlesItem = response.body()?.articles
                articlesItem.let {
                    it?.let { it1 -> sainsAdapter.addDataSains(it1) }
                }
            }

            override fun onFailure(call: Call<ResponseNews>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }
}