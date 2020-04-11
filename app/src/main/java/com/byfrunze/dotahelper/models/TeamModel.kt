package com.byfrunze.dotahelper.models

data class TeamModel(
    val imgTeam: String = "",
    val nameTeam: String = "",
    val rating: Double = 0.0,
    val wins: Int = 0,
    val losses: Int = 0
)