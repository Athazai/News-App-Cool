package com.athzaq.idnfest.kategoriactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.athzaq.idnfest.R
import com.athzaq.idnfest.adapter.AdapterEntertaiment
import com.athzaq.idnfest.databinding.ActivityEntertaimentBinding
import com.athzaq.idnfest.model.ResponseNews
import com.athzaq.idnfest.service.RetrofitBuild
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class EntertaimentActivity : AppCompatActivity() {

    private lateinit var binding : ActivityEntertaimentBinding
    private val entertaimentadapter = AdapterEntertaiment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEntertaimentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            recyclerentertaiment.adapter = entertaimentadapter
            recyclerentertaiment.layoutManager = LinearLayoutManager(this@EntertaimentActivity)
            recyclerentertaiment.setHasFixedSize(true)
        }
        val call = RetrofitBuild.getServiceEntertaiment().headlinesEntertaiment()
        call.enqueue(object : Callback<ResponseNews>{
            override fun onResponse(call: Call<ResponseNews>, response: Response<ResponseNews>) {
                val articlesItem = response.body()?.articles
                articlesItem.let {
                    it?.let { it1 -> entertaimentadapter.addDataEntertaiment(it1) }
                }
            }

            override fun onFailure(call: Call<ResponseNews>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }
}