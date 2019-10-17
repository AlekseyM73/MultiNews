package com.alekseymakarov.multinews.api

import com.alekseymakarov.multinews.model.ChannelsResponse
import com.alekseymakarov.multinews.model.NewsResponse
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query
import com.google.gson.GsonBuilder
import com.google.gson.Gson
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.http.Header
import retrofit2.http.Headers
import java.util.concurrent.TimeUnit


const val BASE_URL : String = "https://newsapi.org/v2/"

interface ApiService {

    @Headers("Content-Type: application/json")
    @GET ("/v2/sources")
    fun getAllSources (@Header("Content-Type") content_type:String,@Query ("apiKey") apiKey: String): Observable<ChannelsResponse>

    @GET("/v2/everything")
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
       val logging = HttpLoggingInterceptor()
           .setLevel(HttpLoggingInterceptor.Level.BODY)
        val okHttpClient =  OkHttpClient.Builder()
        //.readTimeout(15, TimeUnit.SECONDS)
       // .connectTimeout(15, TimeUnit.SECONDS)
        .addInterceptor(logging)
        .build()
        val apiService =  retrofit2.Retrofit.Builder()
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .baseUrl(BASE_URL)
            .build().create(ApiService::class.java)
    }


}