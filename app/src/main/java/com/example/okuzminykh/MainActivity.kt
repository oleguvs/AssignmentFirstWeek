package com.example.okuzminykh

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.okuzminykh.assignmentfirstweek.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
//        val navHostFragment =
//            supportFragmentManager.findFragmentById(R.id.homeHostNavFragment) as NavHostFragment
//        val navController = navHostFragment.navController

        setContentView(binding.root)
    }
}