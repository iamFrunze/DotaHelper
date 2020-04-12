package com.byfrunze.dotahelper.presenters

import com.byfrunze.dotahelper.R
import com.byfrunze.dotahelper.models.HeroModel
import com.byfrunze.dotahelper.models.ProPlayersModel
import com.byfrunze.dotahelper.models.TeamModel
import com.byfrunze.dotahelper.providers.NavProvider
import com.byfrunze.dotahelper.views.NavView
import moxy.InjectViewState
import moxy.MvpPresenter

@InjectViewState
class NavPresenter : MvpPresenter<NavView>() {


    fun loadPage(itemId: Int) {
        viewState.startLoading()
        when (itemId) {
            R.id.navigation_team -> NavProvider(this).loadTeam()
            R.id.navigation_heroes -> NavProvider(this).loadHero()
            R.id.navigation_pro_players -> NavProvider(this).loadProPlayers()
        }

    }


    fun pageLoaded(
        listTeams: ArrayList<TeamModel>? = null,
        listHeroes: ArrayList<HeroModel>? = null,
        listProPlayers: ArrayList<ProPlayersModel>? = null
    ) {
        viewState.endLoading()
        viewState.setupList(
            teamList = listTeams,
            heroList = listHeroes,
            proPlayersList = listProPlayers
        )
    }


    fun errorLoading(textError: String?) {
        viewState.endLoading()
        viewState.setupEmptyList()
        viewState.showError(textError)
    }


}