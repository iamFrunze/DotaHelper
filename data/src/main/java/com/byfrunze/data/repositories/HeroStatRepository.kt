package com.byfrunze.data.repositories

import com.byfrunze.data.models.HeroStatModel
import com.byfrunze.data.services.ApiService
import io.reactivex.Observable

class HeroStatRepository {
    fun getHeroStat(): Observable<List<HeroStatModel>> {
        return ApiService.getInstance().getHeroStats()
    }
}

