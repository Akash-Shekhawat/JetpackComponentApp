package com.example.jetpackcomponentapp.viewmodels

import android.graphics.Color
import androidx.lifecycle.ViewModel
import kotlin.random.Random

class ColorViewModel : ViewModel() {
    private val colorArray = arrayOf(
        Color.WHITE,
        Color.CYAN,
        Color.BLACK,
        Color.BLUE,
        Color.DKGRAY,
        Color.GRAY,
        Color.GREEN,
        Color.MAGENTA
    )


    var selectedColor = colorArray[0]

    fun changeBackgroundColor() {
        selectedColor = colorArray[randomNumberGenerator()]
    }


    private fun randomNumberGenerator(): Int {
        val startRange = 0
        val endRange = colorArray.size
        return Random.nextInt(startRange, endRange)
    }
}