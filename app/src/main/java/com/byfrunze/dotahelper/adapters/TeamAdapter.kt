package com.byfrunze.dotahelper.adapters

import android.content.res.Resources
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.byfrunze.dotahelper.R
import com.byfrunze.dotahelper.models.TeamModel
import com.squareup.picasso.Picasso

class TeamAdapter : RecyclerView.Adapter<TeamAdapter.ViewHolder>() {

    private val mTeamList: ArrayList<TeamModel> = ArrayList()
    private val mSourceTeamList: ArrayList<TeamModel> = ArrayList()

    fun setupTeam(teamList: ArrayList<TeamModel>){
        mSourceTeamList.clear()
        mSourceTeamList.addAll(teamList)
        filter(query = "")
    }

    fun filter(query:String){
        mTeamList.clear()
        mTeamList.addAll(mSourceTeamList.filter { it.nameTeam.contains(query, ignoreCase = true) })
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.cell_team, parent, false))

    override fun getItemCount(): Int = mTeamList.count()

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(model = mTeamList[position])
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val imgAvatarTeam: ImageView = itemView.findViewById(R.id.img_avatar_team)
        private val txtNameTeam: TextView = itemView.findViewById(R.id.txt_name_team_team)
        private val txtRatingTeam: TextView = itemView.findViewById(R.id.txt_rating_team)
        private val txtWinsTeam: TextView = itemView.findViewById(R.id.txt_wins_team)
        private val txtLossesTeam: TextView = itemView.findViewById(R.id.txt_losses_team)

        fun bind(model: TeamModel) {
            with(model) {
                if (imgTeam.isNotEmpty()) Picasso.get()
                    .load(imgTeam)
                    .placeholder(R.drawable.ic_placeholder_40dp)
                    .into(imgAvatarTeam)
                if (nameTeam.isEmpty()) txtNameTeam.text =
                    Resources.getSystem().getString(R.string.noname_team)
                txtRatingTeam.text = rating.toString()
                txtWinsTeam.text = wins.toString()
                txtLossesTeam.text = losses.toString()
            }
        }
    }

}