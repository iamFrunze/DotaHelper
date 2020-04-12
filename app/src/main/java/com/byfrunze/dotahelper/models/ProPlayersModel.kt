package com.byfrunze.dotahelper.models

data class ProPlayersModel(
    val account_id: Long = 0,
    val steamid: Long = 0,
    val avatarfull: String? = null,
    val profileurl: String? = null,
    val personaname: String = "",
    val team_name: String = ""
)