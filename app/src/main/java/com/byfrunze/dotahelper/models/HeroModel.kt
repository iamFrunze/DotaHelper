package com.byfrunze.dotahelper.models

data class HeroModel(
    val id: Long,
    val localized_name: String = "",
    val primary_attr: String = "",
    val attack_type: String = "",
    val roles: List<String>? = null,
    val img: String? = null,
    val icon: String? = null

)
