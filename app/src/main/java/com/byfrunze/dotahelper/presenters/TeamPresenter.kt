package com.byfrunze.dotahelper.presenters

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.byfrunze.dotahelper.models.TeamModel
import com.byfrunze.dotahelper.providers.TeamProvider
import com.byfrunze.dotahelper.views.TeamView

@InjectViewState
class TeamPresenter : MvpPresenter<TeamView>() {
    fun loadTeam(){
        viewState.startLoading()
        TeamProvider(this).testLoadTeam()
    }

    fun teamLoaded(teamList: ArrayList<TeamModel>, textEror: String = ""){
        viewState.endLoading()
        if(teamList.size == 0){
            viewState.setupEmptyList()
            viewState.showError(textError = textEror)
        }else{
            viewState.setupTeamList(teamList = teamList)
        }
    }
}