package com.athzaq.idnfest.kategoriactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.athzaq.idnfest.R
import com.athzaq.idnfest.adapter.AdapterTeknologi
import com.athzaq.idnfest.databinding.ActivityTeknologiBinding
import com.athzaq.idnfest.model.ResponseNews
import com.athzaq.idnfest.service.RetrofitBuild
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TeknologiActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTeknologiBinding
    private val teknologiadapter = AdapterTeknologi()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTeknologiBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            recyclerteknologi.adapter = teknologiadapter
            recyclerteknologi.layoutManager = LinearLayoutManager(this@TeknologiActivity)
            recyclerteknologi.setHasFixedSize(true)
        }
        val call = RetrofitBuild.getServiceTeknologi().headlinesTeknologi()
        call.enqueue(object : Callback<ResponseNews>{
            override fun onResponse(call: Call<ResponseNews>, response: Response<ResponseNews>) {
                val articlesItem = response.body()?.articles
                articlesItem.let {
                    it?.let { it1 -> teknologiadapter.addDataTeknologi(it1) }
                }
            }

            override fun onFailure(call: Call<ResponseNews>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }
}