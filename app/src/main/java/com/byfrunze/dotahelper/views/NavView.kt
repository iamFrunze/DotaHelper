package com.byfrunze.dotahelper.views

import com.byfrunze.dotahelper.models.HeroModel
import com.byfrunze.dotahelper.models.ProPlayersModel
import com.byfrunze.dotahelper.models.TeamModel
import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(value = AddToEndSingleStrategy::class)
interface NavView : MvpView {
    fun startLoading()
    fun endLoading()
    fun showError(textError: String?)
    fun setupList(
        teamList: ArrayList<TeamModel>? = null,
        heroList: ArrayList<HeroModel>? = null,
        proPlayersList: ArrayList<ProPlayersModel>? = null
    )
    fun setupEmptyList()
}