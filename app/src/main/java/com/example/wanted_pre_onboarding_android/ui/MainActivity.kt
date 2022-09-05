package com.example.wanted_pre_onboarding_android.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.wanted_pre_onboarding_android.R
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.navigationMain)

        val navController = supportFragmentManager.findFragmentById(R.id.containerMain)?.findNavController()
        navController?.let {
            bottomNavigationView.setupWithNavController(it)
        }
    }
}