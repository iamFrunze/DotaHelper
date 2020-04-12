package com.byfrunze.dotahelper.models

data class TeamModel(
    val team_id : Int = 0,
    var logo_url: String? = null,
    val name: String? = null,
    val rating: Double = 0.0,
    val wins: Int = 0,
    val losses: Int = 0
)