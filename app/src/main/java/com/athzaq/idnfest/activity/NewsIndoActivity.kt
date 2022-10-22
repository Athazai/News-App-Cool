package com.athzaq.idnfest.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.athzaq.idnfest.R
import com.athzaq.idnfest.adapter.AdapterNewsIndo
import com.athzaq.idnfest.databinding.ActivityNewsIndoBinding
import com.athzaq.idnfest.model.ResponseNews
import com.athzaq.idnfest.service.RetrofitBuild
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewsIndoActivity : AppCompatActivity() {

    private lateinit var binding : ActivityNewsIndoBinding
    private val newsAdapter = AdapterNewsIndo()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewsIndoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            recyclernewsindo.adapter = newsAdapter
            recyclernewsindo.layoutManager = LinearLayoutManager(this@NewsIndoActivity)
            recyclernewsindo.setHasFixedSize(true)
        }
        val call = RetrofitBuild.getServiceKNewsIndo().headlinesindo()
        call.enqueue(object : Callback<ResponseNews>{
            override fun onResponse(call: Call<ResponseNews>, response: Response<ResponseNews>) {
                val listArticlesItem = response.body()?.articles
                listArticlesItem.let {
                    it?.let { it1 -> newsAdapter.addDataindo(it1) }
                }
            }

            override fun onFailure(call: Call<ResponseNews>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }
}