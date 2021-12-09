package com.alvarolc.aad_playground.UT_01

import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatEditText
import com.alvarolc.aad_playground.MainActivity
import java.io.File


class Ejercicio01 (private val activity: MainActivity){

    fun saveFile(inputNameFile: AppCompatEditText, inputContentFile: AppCompatEditText) {
        var nameIntroduce = inputNameFile.text.toString()
        var contentIntroduce = inputContentFile.text.toString()
        val privateFile = File(activity.filesDir, nameIntroduce)
        privateFile.writeText(contentIntroduce)
    }

}