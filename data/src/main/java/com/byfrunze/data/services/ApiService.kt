package com.byfrunze.data.services

import com.byfrunze.data.models.HeroStatModel
import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiService {
    @GET("heroStats")
    fun getHeroStats(): Observable<List<HeroStatModel>>


    companion object {
        private const val BASE_URL = "https://api.opendota.com/api/"

        fun getInstance(): ApiService {
            val retrofit = Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
            return retrofit.create(ApiService::class.java)
        }
    }
}