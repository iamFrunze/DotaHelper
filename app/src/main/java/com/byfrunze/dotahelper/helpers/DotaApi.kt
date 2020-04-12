package com.byfrunze.dotahelper.helpers

import com.byfrunze.dotahelper.models.HeroModel
import com.byfrunze.dotahelper.models.ProPlayersModel
import com.byfrunze.dotahelper.models.TeamModel
import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import kotlin.collections.ArrayList

interface DotaApi {

    @GET("teams")
    fun getTeams() : Observable<ArrayList<TeamModel>>

    @GET("heroStats")
    fun getHeroes(): Observable<ArrayList<HeroModel>>

    @GET("proPlayers")
    fun getProPlayers(): Observable<ArrayList<ProPlayersModel>>

    companion object{
        private const val URL = "https://api.opendota.com/api/"

        fun create(): DotaApi{
            val retrofit = Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(URL)
                .build()
            return retrofit.create(DotaApi::class.java)
        }
    }
}