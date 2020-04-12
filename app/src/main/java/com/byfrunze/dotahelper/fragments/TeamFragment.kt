package com.byfrunze.dotahelper.fragments

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.byfrunze.dotahelper.R
import com.byfrunze.dotahelper.adapters.TeamAdapter
import com.byfrunze.dotahelper.models.HeroModel
import com.byfrunze.dotahelper.models.TeamModel
import com.byfrunze.dotahelper.presenters.NavPresenter
import com.byfrunze.dotahelper.views.NavView
import kotlinx.android.synthetic.main.fragment_team.*
import moxy.MvpAppCompatFragment
import moxy.presenter.InjectPresenter

class TeamFragment : MvpAppCompatFragment(), NavView {

    @InjectPresenter
    lateinit var teamPresenter: NavPresenter
    lateinit var mAdapter: TeamAdapter
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        teamPresenter.loadPage(R.id.navigation_team)
        mAdapter = TeamAdapter()
        recycler_teams.adapter = mAdapter

        recycler_teams.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

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
        swipe_refresh_team.setOnRefreshListener {
            teamPresenter.loadPage(R.id.navigation_team)
            swipe_refresh_team.isRefreshing = false

        }


    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_team, container, false)
    }

    override fun startLoading() {
        recycler_teams.visibility = View.GONE
        txt_no_teams_team.visibility = View.GONE
        cpv_teams_loader.visibility = View.VISIBLE
    }

    override fun endLoading() {
        cpv_teams_loader.visibility = View.GONE
    }

    override fun showError(textError: String?) {
        txt_no_teams_team.text = textError
    }

    override fun setupList(teamList: ArrayList<TeamModel>?, heroList: ArrayList<HeroModel>?) {
        cpv_teams_loader.visibility = View.GONE
        recycler_teams.visibility = View.VISIBLE

        teamList?.let{
            mAdapter.setupTeam(teamList = teamList)
        }
    }

    override fun setupEmptyList() {
        cpv_teams_loader.visibility = View.GONE
        txt_no_teams_team.visibility = View.VISIBLE
    }


}
