package com.athzaq.idnfest.service

import com.athzaq.idnfest.model.ResponseNews
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers

object RetrofitBuild {

    private val client : OkHttpClient = OkHttpClient.Builder().build()

    private val News : Retrofit = Retrofit.Builder()
        .baseUrl("https://newsapi.org/")
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()

    private val kbbi : Retrofit = Retrofit.Builder()
        .baseUrl("https://indonesia-covid-19.mathdro.id/")
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()

    fun getServiceKNewsIndo() = News.create(NewsIndo::class.java)


    fun getServiceBisnis() = News.create(Bisnis::class.java)
    fun getServiceScience() = News.create(Sains::class.java)
    fun getServiceEntertaiment() = News.create(Entertaiment::class.java)
    fun getServiceSports() = News.create(Sports::class.java)
    fun getServiceTeknologi() = News.create(Teknologi::class.java)
    fun getServiceHealth() = News.create(Health::class.java)

}

    interface NewsIndo {
        @Headers("Authorization: ba77e0e5b1f347d39087968673eb5fb7")
        @GET("v2/top-headlines?country=id")

        fun headlinesindo() : Call<ResponseNews>
    }
interface Bisnis {

    @Headers("Authorization: ba77e0e5b1f347d39087968673eb5fb7")
    @GET("v2/top-headlines?country=id&category=business")

    fun headlinesBisnis() : Call<ResponseNews>
}
interface Sains {

    @Headers("Authorization: ba77e0e5b1f347d39087968673eb5fb7")
    @GET("v2/top-headlines?country=id&category=science")

    fun headlinesSains() : Call<ResponseNews>
}
interface Entertaiment {

    @Headers("Authorization: ba77e0e5b1f347d39087968673eb5fb7")
    @GET("v2/top-headlines?country=id&category=entertainment")

    fun headlinesEntertaiment() : Call<ResponseNews>
}
interface Sports {

    @Headers("Authorization: ba77e0e5b1f347d39087968673eb5fb7")
    @GET("v2/top-headlines?country=id&category=sports")

    fun headlinesSports() : Call<ResponseNews>
}interface Teknologi {

    @Headers("Authorization: ba77e0e5b1f347d39087968673eb5fb7")
    @GET("v2/top-headlines?country=id&category=technology")

    fun headlinesTeknologi() : Call<ResponseNews>
}interface Health {

    @Headers("Authorization: ba77e0e5b1f347d39087968673eb5fb7")
    @GET("v2/top-headlines?country=id&category=health")

    fun headlinesHealth() : Call<ResponseNews>
}