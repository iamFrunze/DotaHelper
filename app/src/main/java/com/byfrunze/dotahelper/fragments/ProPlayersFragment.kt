package com.byfrunze.dotahelper.fragments

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.byfrunze.dotahelper.R
import com.byfrunze.dotahelper.adapters.ProPlayersAdapter
import com.byfrunze.dotahelper.models.HeroModel
import com.byfrunze.dotahelper.models.ProPlayersModel
import com.byfrunze.dotahelper.models.TeamModel
import com.byfrunze.dotahelper.presenters.NavPresenter
import com.byfrunze.dotahelper.views.NavView
import kotlinx.android.synthetic.main.fragment_pro_players.*
import kotlinx.android.synthetic.main.fragment_team.*
import moxy.MvpAppCompatFragment
import moxy.presenter.InjectPresenter

class ProPlayersFragment : MvpAppCompatFragment(), NavView {

    @InjectPresenter
    lateinit var playersPresenter: NavPresenter
    lateinit var mAdapter: ProPlayersAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        playersPresenter.loadPage(R.id.navigation_pro_players)
        mAdapter = ProPlayersAdapter()
        recycler_players.adapter = mAdapter

        recycler_players.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

        recycler_players.setHasFixedSize(true)

        edt_players_search.addTextChangedListener(object : TextWatcher {
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
        swipe_refresh_players.setOnRefreshListener {
            playersPresenter.loadPage(R.id.navigation_team)
            swipe_refresh_players.isRefreshing = false

        }


    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_pro_players, container, false)
    }

    override fun startLoading() {
        recycler_players.visibility = View.GONE
        txt_no_players.visibility = View.GONE
        cpv_players_loader.visibility = View.VISIBLE
    }

    override fun endLoading() {
        cpv_players_loader.visibility = View.GONE
    }

    override fun showError(textError: String?) {
        txt_no_players.text = textError
    }

    override fun setupList(
        teamList: ArrayList<TeamModel>?,
        heroList: ArrayList<HeroModel>?,
        proPlayersList: ArrayList<ProPlayersModel>?
    ) {
        cpv_players_loader.visibility = View.GONE
        recycler_players.visibility = View.VISIBLE

        proPlayersList?.let {
            mAdapter.setupList(listProPlayers = proPlayersList)
        }
    }

    override fun setupEmptyList() {
        cpv_players_loader.visibility = View.GONE
        txt_no_players.visibility = View.VISIBLE
    }
}
