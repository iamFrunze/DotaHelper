package com.byfrunze.data.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class HeroStatModel(
    @SerializedName("id")
    @Expose
    val id: Float,

    @SerializedName("name")
    @Expose
    val name: String,

    @SerializedName("localized_name")
    @Expose
    val localizedName: String,

    @SerializedName("primary_attr")
    @Expose
    val primaryAttr: String,

    @SerializedName("attack_type")
    @Expose
    val attackType: String,

    @SerializedName("roles")
    @Expose
    val roles: List<String>,

    @SerializedName("img")
    @Expose
    val img: String,

    @SerializedName("icon")
    @Expose
    val icon: String,

    @SerializedName("base_health")
    @Expose
    val baseHealth: Float,

    @SerializedName("base_health_regen")
    @Expose
    val baseHealthRegen: Double,

    @SerializedName("base_mana")
    @Expose
    val baseMana: Float,

    @SerializedName("base_mana_regen")
    @Expose
    val baseManaRegen: Float,

    @SerializedName("base_armor")
    @Expose
    val baseArmor: Float,

    @SerializedName("base_mr")
    @Expose
    val baseMr: Float,

    @SerializedName("base_attack_min")
    @Expose
    val baseAttackMin: Float,

    @SerializedName("base_attack_max")
    @Expose
    val baseAttackMax: Float,

    @SerializedName("base_str")
    @Expose
    val baseStr: Float,

    @SerializedName("base_agi")
    @Expose
    val baseAgi: Float,

    @SerializedName("base__root_ide_package_.kotlin.Float")
    @Expose
    val baseFloat: Float,

    @SerializedName("str_gain")
    @Expose
    val strGain: Double,

    @SerializedName("agi_gain")
    @Expose
    val agiGain: Double,

    @SerializedName("_root_ide_package_.kotlin.Float_gain")
    @Expose
    val FloatGain: Double,

    @SerializedName("attack_range")
    @Expose
    val attackRange: Float,

    @SerializedName("projectile_speed")
    @Expose
    val projectileSpeed: Float,

    @SerializedName("attack_rate")
    @Expose
    val attackRate: Double,

    @SerializedName("move_speed")
    @Expose
    val moveSpeed: Float,

    @SerializedName("turn_rate")
    @Expose
    val turnRate: Double,

    @SerializedName("cm_enabled")
    @Expose
    val cmEnabled: Boolean,

    @SerializedName("legs")
    @Expose
    val legs: Float,

    @SerializedName("pro_ban")
    @Expose
    val proBan: Float,

    @SerializedName("hero_id")
    @Expose
    val heroId: Float,

    @SerializedName("pro_win")
    @Expose
    val proWin: Float,

    @SerializedName("pro_pick")
    @Expose
    val proPick: Float,

    @SerializedName("1_pick")
    @Expose
    val _1Pick: Float,

    @SerializedName("1_win")
    @Expose
    val _1Win: Float,

    @SerializedName("2_pick")
    @Expose
    val _2Pick: Float,

    @SerializedName("2_win")
    @Expose
    val _2Win: Float,

    @SerializedName("3_pick")
    @Expose
    val _3Pick: Float,

    @SerializedName("3_win")
    @Expose
    val _3Win: Float,

    @SerializedName("4_pick")
    @Expose
    val _4Pick: Float,

    @SerializedName("4_win")
    @Expose
    val _4Win: Float,

    @SerializedName("5_pick")
    @Expose
    val _5Pick: Float,

    @SerializedName("5_win")
    @Expose
    val _5Win: Float,

    @SerializedName("6_pick")
    @Expose
    val _6Pick: Float,

    @SerializedName("6_win")
    @Expose
    val _6Win: Float,

    @SerializedName("7_pick")
    @Expose
    val _7Pick: Float,

    @SerializedName("7_win")
    @Expose
    val _7Win: Float,

    @SerializedName("8_pick")
    @Expose
    val _8Pick: Float,

    @SerializedName("8_win")
    @Expose
    val _8Win: Float,

    @SerializedName("null_pick")
    @Expose
    val nullPick: Float,

    @SerializedName("null_win")
    @Expose
    val nullWin: Float
)