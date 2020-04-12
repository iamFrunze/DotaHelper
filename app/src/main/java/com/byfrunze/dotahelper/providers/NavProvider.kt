package com.byfrunze.dotahelper.providers

import com.byfrunze.dotahelper.helpers.DotaApi
import com.byfrunze.dotahelper.presenters.NavPresenter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class NavProvider(var presenter: NavPresenter) {

    private val apiService by lazy {
        DotaApi.create()
    }
    var disposable: Disposable? = null

    fun loadTeam() {
        disposable = apiService.getTeams()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                presenter.pageLoaded(listTeams = it)
            }, {
                presenter.errorLoading(it.message)
            })
    }

    fun loadHero() {

        disposable = apiService.getHeroes()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                presenter.pageLoaded(listHeroes = it)
            }, {
                presenter.errorLoading(it.message)
            })
    }

    fun loadProPlayers() {

        disposable = apiService.getProPlayers()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                presenter.pageLoaded(listProPlayers = it)
            }, {
                presenter.errorLoading(it.message)
            })
    }
}


