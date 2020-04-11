package com.byfrunze.dotahelper.fragments

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.arellomobile.mvp.MvpFragment
import com.arellomobile.mvp.presenter.InjectPresenter
import com.byfrunze.dotahelper.adapters.TeamAdapter
import com.byfrunze.dotahelper.models.TeamModel
import com.byfrunze.dotahelper.presenters.TeamPresenter
import com.byfrunze.dotahelper.views.TeamView
import kotlinx.android.synthetic.main.fragment_team.*

class TeamFragment : MvpFragment(), TeamView {

    @InjectPresenter
    lateinit var teamPresenter: TeamPresenter
    lateinit var mAdapter: TeamAdapter



    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        teamPresenter.loadTeam()
        mAdapter = TeamAdapter()
        recycler_teams.adapter = mAdapter
        recycler_teams.layoutManager =
            LinearLayoutManager(context,  LinearLayoutManager.VERTICAL, false)
        recycler_teams.setHasFixedSize(true)

        edt_team_search.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                mAdapter.filter(query = s.toString())
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                mAdapter.filter(query = s.toString())
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                mAdapter.filter(query = s.toString())
            }


        })
    }

    override fun startLoading() {
        recycler_teams.visibility = View.GONE
        txt_no_teams_team.visibility = View.GONE
        cpv_teams_loader.visibility = View.VISIBLE
    }

    override fun endLoading() {
        cpv_teams_loader.visibility = View.GONE
    }

    override fun showError(textError: String) {
        txt_no_teams_team.text = textError
    }

    override fun setupTeamList(teamList: ArrayList<TeamModel>) {
        cpv_teams_loader.visibility = View.GONE
        recycler_teams.visibility = View.VISIBLE
        mAdapter.setupTeam(teamList = teamList)
    }

    override fun setupEmptyList() {
        cpv_teams_loader.visibility = View.GONE
        txt_no_teams_team.visibility = View.VISIBLE
    }
}
