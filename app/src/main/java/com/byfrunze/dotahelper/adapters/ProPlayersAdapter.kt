package com.byfrunze.dotahelper.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.byfrunze.dotahelper.R
import com.byfrunze.dotahelper.models.ProPlayersModel
import com.squareup.picasso.Picasso

class ProPlayersAdapter : RecyclerView.Adapter<ProPlayersAdapter.ViewHolder>() {

    private val mProPlayersList: ArrayList<ProPlayersModel> = ArrayList()
    private val mSourceProPlayersList: ArrayList<ProPlayersModel> = ArrayList()

    fun setupList(listProPlayers: ArrayList<ProPlayersModel>) {
        mSourceProPlayersList.clear()
        mSourceProPlayersList.addAll(listProPlayers)
        filter(query = "")
    }

    fun filter(query: String) {
        mProPlayersList.clear()
        mSourceProPlayersList.filter {
            it.personaname.contains(query, ignoreCase = true) ||
                    it.team_name.contains(query, ignoreCase = true)
            mProPlayersList.add(it)
        }

        notifyDataSetChanged()

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.cell_pro_players, parent, false)
        )

    override fun getItemCount() = mProPlayersList.count()

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(model = mProPlayersList[position])
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val imgAvatarPlayer: ImageView = itemView.findViewById(R.id.img_avatar_player)
        private val txtSteamIdPlayer: TextView = itemView.findViewById(R.id.txt_steamid_player)
        private val txtNamePlayer: TextView = itemView.findViewById(R.id.txt_name_player)
        private val txtTeamPlayer: TextView = itemView.findViewById(R.id.txt_team_name_player)
        private val txtProfilePlayer: TextView = itemView.findViewById(R.id.txt_profile_player)

        fun bind(model: ProPlayersModel) {
            with(model) {
                txtSteamIdPlayer.text = steamid.toString()
                avatarfull?.let {
                    Picasso.get()
                        .load(avatarfull)
                        .placeholder(R.drawable.placeholder_team)
                        .into(imgAvatarPlayer)
                }
                profileurl?.let {
                    txtProfilePlayer.text = it
                }
                personaname?.let {
                    txtNamePlayer.text = it
                }
                team_name?.let {
                    txtTeamPlayer.text = "Команда: $it"
                }
            }

        }
    }
}