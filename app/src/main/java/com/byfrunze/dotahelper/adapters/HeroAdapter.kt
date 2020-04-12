package com.byfrunze.dotahelper.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.byfrunze.dotahelper.R
import com.byfrunze.dotahelper.models.HeroModel
import com.squareup.picasso.Picasso

class HeroAdapter : RecyclerView.Adapter<HeroAdapter.ViewHolder>() {

    private val listHero: ArrayList<HeroModel> = ArrayList()
    private val sourceListHero: ArrayList<HeroModel> = ArrayList()

    fun setupHero(heroList: ArrayList<HeroModel>) {
        sourceListHero.clear()
        sourceListHero.addAll(heroList)
        filter(query = "")
    }

    fun filter(query: String) {
        listHero.clear()
        sourceListHero.forEach {
            if (it.localized_name.contains(query, ignoreCase = true) ||
                it.attack_type.contains(query, ignoreCase = true) ||
                it.primary_attr.contains(query, ignoreCase = true)
            ) listHero.add(it)

            notifyDataSetChanged()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.cell_hero, parent, false))

    override fun getItemCount() = listHero.count()

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(model = listHero[position])
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val imgAvatarHero: ImageView = itemView.findViewById(R.id.img_avatar_hero)
        private val txtNameHero: TextView = itemView.findViewById(R.id.txt_name_hero)
        private val txtAttackType: TextView = itemView.findViewById(R.id.txt_attack_type_hero)
        private val txtRolesHero: TextView = itemView.findViewById(R.id.txt_roles_hero)
        private val txtPrimaryAttr: TextView = itemView.findViewById(R.id.txt_primary_attr_hero)
        private val imgIconHero: ImageView = itemView.findViewById(R.id.img_icon_hero)

        fun bind(model: HeroModel) {
            with(model) {
                txtNameHero.text = localized_name
                txtAttackType.text = "Тип атаки: $attack_type"
                roles?.let {
                    txtRolesHero.text = "Роль: ${roles.toString()}"
                }
                txtPrimaryAttr.text = when (primary_attr) {
                    "agi" -> "Основной атрибут: Agility"
                    "int" -> "Основной атрибут: Intellect"
                    "str" -> "Основной атрибут: Strength"
                    else -> "Unknown primary attribute"
                }
                img?.let {
                    Log.i("TAG", it)
                    Picasso.get()
                        .load("https://api.opendota.com$img")
                        .placeholder(R.drawable.placeholder_team)
                        .into(imgAvatarHero)
                }
                icon?.let {
                    Picasso.get()
                        .load("https://api.opendota.com$icon")
                        .into(imgIconHero)
                }

            }
        }
    }
}