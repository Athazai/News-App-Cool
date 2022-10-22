package com.athzaq.idnfest.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.athzaq.idnfest.R
import com.athzaq.idnfest.adapter.AdapterCovid
import com.athzaq.idnfest.databinding.ActivityCovidBinding
import com.athzaq.idnfest.model.ResponseCovid
import com.athzaq.idnfest.service.RetrofitBuild
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CovidActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCovidBinding
    private val adaptercovid = AdapterCovid()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCovidBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            recyclercovidprov.adapter = adaptercovid
            recyclercovidprov.layoutManager = LinearLayoutManager(this@CovidActivity)
            recyclercovidprov.setHasFixedSize(true)
        }
        val call = RetrofitBuild.getServiceCovidProvinsi().headlineCovidProv()
        call.enqueue(object : Callback<ResponseCovid>{
            override fun onResponse(call: Call<ResponseCovid>, response: Response<ResponseCovid>) {
                val artikelitem = response.body()?.data
                artikelitem.let {
                    it?.let { it1 -> adaptercovid.addDataCovid(it1) }
                }
            }

            override fun onFailure(call: Call<ResponseCovid>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }
}