package com.byfrunze.dotahelper.activities

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.Log
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation.findNavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.byfrunze.dotahelper.R
import com.byfrunze.dotahelper.fragments.HeroesFragment
import com.byfrunze.dotahelper.fragments.ProPlayersFragment
import com.byfrunze.dotahelper.fragments.TeamFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_navigation.*

class NavigationActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigation)

        val navView: BottomNavigationView = findViewById(R.id.nav_view)
        navView.itemIconTintList = null
        supportActionBar?.setBackgroundDrawable(ColorDrawable(Color.WHITE))
         val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        setupActionBarWithNavController(navController = navController)
        navView.setupWithNavController(navController)
    }

}



