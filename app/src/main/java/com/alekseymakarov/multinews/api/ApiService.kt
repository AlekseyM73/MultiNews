package com.alekseymakarov.multinews.api

import com.alekseymakarov.multinews.model.ChannelsResponse
import com.alekseymakarov.multinews.model.NewsResponse
import io.reactivex.Single
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

const val BASE_URL : String = "https://newsapi.org/v2/"

interface ApiService {


    @GET ("/sources")
    fun getAllSources (@Query ("apiKey") apiKey: String): Single<ChannelsResponse>

    @GET("/everything")
    fun getEverythingNews (@Query("q") q: String,
                           @Query ("qInTitle") qInTitle:String,
                           @Query ("sources")vararg sources: String,
                           @Query ("from") from: String,
                           @Query ("to") to: String,
                           @Query ("language") language: String,
                           @Query ("sortBy") sortBy: String,
                           @Query ("pageSize") pageSize: Int,
                           @Query ("page") page: Int,
                           @Query ("apiKey") apiKey: String): Single<NewsResponse>



    companion object RetrofitFactory {
        val apiService =  retrofit2.Retrofit.Builder()
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build().create(ApiService::class.java)
    }


}