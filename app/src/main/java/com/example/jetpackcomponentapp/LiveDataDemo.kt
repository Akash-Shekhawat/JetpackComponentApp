package com.example.jetpackcomponentapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.jetpackcomponentapp.fragments.ShowData

class LiveDataDemo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_live_data_demo)

        addFragmentToView()
    }
    private fun addFragmentToView() {

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.fragmentContainer_FL, ShowData())
        fragmentTransaction.commit()
    }
}