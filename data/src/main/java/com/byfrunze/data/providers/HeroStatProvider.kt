package com.byfrunze.data.providers

import com.byfrunze.data.repositories.HeroStatRepository

object HeroStatProvider {
    fun providerHeroStatRepository() : HeroStatRepository{
        return HeroStatRepository()
    }
}