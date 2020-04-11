package com.byfrunze.dotahelper.providers

import com.byfrunze.dotahelper.models.TeamModel
import com.byfrunze.dotahelper.presenters.TeamPresenter

class TeamProvider(var presenter: TeamPresenter) {

    fun testLoadTeam() {
        val teamList: ArrayList<TeamModel> = ArrayList()
        val team1 = TeamModel(
            imgTeam = "https://steamcdn-a.akamaihd.net/apps/dota2/images/team_logos/2586976.png",
            nameTeam = "Liquid", rating = 1.1111, wins = 10, losses = 10
        )
        val team2 = TeamModel(
            imgTeam = "https://steamcdn-a.akamaihd.net/apps/dota2/images/team_logos/1838315.png",
            nameTeam = "Team Secret", rating =  1518.41, wins = 755, losses = 369
        )
        val team3 = TeamModel(
            imgTeam = "https://steamcdn-a.akamaihd.net/apps/dota2/images/team_logos/5026801.png",
            rating = 1.1111, wins = 10, losses = 10
        )
        teamList.add(team1)
        teamList.add(team2)
        teamList.add(team3)
        presenter.teamLoaded(teamList)
    }
}