package com.byfrunze.dotahelper.fragments

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.byfrunze.dotahelper.R
import com.byfrunze.dotahelper.adapters.HeroAdapter
import com.byfrunze.dotahelper.models.HeroModel
import com.byfrunze.dotahelper.models.TeamModel
import com.byfrunze.dotahelper.presenters.NavPresenter
import com.byfrunze.dotahelper.views.NavView
import kotlinx.android.synthetic.main.fragment_heroes.*
import moxy.MvpAppCompatFragment
import moxy.presenter.InjectPresenter

class HeroesFragment : MvpAppCompatFragment(), NavView {

    @InjectPresenter
    lateinit var heroesPresenter: NavPresenter
    lateinit var mAdapter: HeroAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        heroesPresenter.loadPage(R.id.navigation_heroes)
        mAdapter = HeroAdapter()
        recycler_hero.adapter = mAdapter

        recycler_hero.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

        recycler_hero.setHasFixedSize(true)

        edt_hero_search.addTextChangedListener(object : TextWatcher {
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
        swipe_refresh_hero.setOnRefreshListener {
            heroesPresenter.loadPage(R.id.navigation_heroes)
            swipe_refresh_hero.isRefreshing = false

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_heroes, container, false)
    }

    override fun startLoading() {
        recycler_hero.visibility = View.GONE
        txt_no_heroes_heroes.visibility = View.GONE
        cpv_heroes_loader.visibility = View.VISIBLE    }

    override fun endLoading() {
        cpv_heroes_loader.visibility = View.GONE
    }

    override fun showError(textError: String?) {
        txt_no_heroes_heroes.text = textError
    }

       override fun setupList(teamList: ArrayList<TeamModel>?, heroList: ArrayList<HeroModel>?) {
        cpv_heroes_loader.visibility = View.GONE
        recycler_hero.visibility = View.VISIBLE
        heroList?.let {
            mAdapter.setupHero(heroList)
        }
    }

    override fun setupEmptyList() {
        cpv_heroes_loader.visibility = View.GONE
        txt_no_heroes_heroes.visibility = View.VISIBLE
    }
}
