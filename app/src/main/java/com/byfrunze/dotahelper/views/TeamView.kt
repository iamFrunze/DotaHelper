package com.byfrunze.dotahelper.views

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import com.byfrunze.dotahelper.models.TeamModel

@StateStrategyType(value = AddToEndSingleStrategy::class)
interface TeamView : MvpView {
    fun startLoading()
    fun endLoading()
    fun showError(textError: String)
    fun setupTeamList(teamList: ArrayList<TeamModel>)
    fun setupEmptyList()
}