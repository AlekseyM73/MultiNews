package com.alekseymakarov.multinews.api

import com.alekseymakarov.multinews.model.ChannelsResponse
import io.reactivex.Single
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

const val BASE_URL : String = "https://newsapi.org/v2/"

interface ApiService {

    @GET ("/sources")
    fun getAllSources (@Query ("apiKey") apiKey: String): Single<ChannelsResponse>

    companion object RetrofitFactory {
        fun create(): ApiService {
            val retrofit = retrofit2.Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
            return retrofit.create(ApiService::class.java)
        }
    }

}