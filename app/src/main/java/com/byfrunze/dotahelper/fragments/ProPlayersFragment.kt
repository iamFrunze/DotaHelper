package com.byfrunze.dotahelper.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.arellomobile.mvp.MvpFragment
import com.byfrunze.dotahelper.R

class ProPlayersFragment : MvpFragment() {


    override fun onCreateView(
        inflater: LayoutInflater?,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater?.inflate(R.layout.fragment_team, container, false)
        return root
    }
}
