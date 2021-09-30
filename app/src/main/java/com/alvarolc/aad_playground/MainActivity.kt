package com.alvarolc.aad_playground

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.alvarolc.aad_playground.UT_01.FilePlayGround

class MainActivity : AppCompatActivity() {

    val colors : MutableList<String> = mutableListOf()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initColors()
        val filePlayGround = FilePlayGround(this)
        filePlayGround.saveToFile(colors)

        val colorsReturn : MutableList<String> = filePlayGround.readLineByLineColors()
        colorsReturn.forEach {
            Log.d("@dev",it)
        }
    }

    private fun initColors(){
        colors.add("Blue")
        colors.add("Red")
        colors.add("Orange")
        colors.add("Green")
    }
}