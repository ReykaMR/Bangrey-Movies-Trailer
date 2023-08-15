package com.example.uas_if9_10120766_reykamochammadraihan_bangreymoviestrailer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.example.uas_if9_10120766_reykamochammadraihan_bangreymoviestrailer.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val activityMainActivity = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainActivity.root)

        supportActionBar?.hide()

        val navController = findNavController(R.id.nav_host_fragment)

        AppBarConfiguration(setOf(R.id.navigation_home, R.id.navigation_explore, R.id.navigation_favorite, R.id.navigation_profile))

        activityMainActivity.navView.setupWithNavController(navController)
    }
}
