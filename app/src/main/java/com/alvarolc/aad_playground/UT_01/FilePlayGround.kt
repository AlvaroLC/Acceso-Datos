package com.alvarolc.aad_playground.UT_01

import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import java.io.File

class FilePlayGround (private val activity: AppCompatActivity){

    /**
    *Función que se ejecuta al instanciar la clase (crear un objeto)
    */
    init {
        //createFile()
        //writeFile()
        //readFile()
        //appendText()
        //appendTextWithNewLine()
        //readLineByLine()
        //deleteFiles()
    }

    fun createFile(){
        val file = File(activity.filesDir, "add.txt")
        //Log.d("@dev",activity.filesDir.absolutePath)
    }

    fun writeFile(){
        val file = File(activity.filesDir, "add.txt")
        file.writeText("Hola Acceso a Datos")
    }

    fun readFile(){
        val file = File(activity.filesDir, "add.txt")
        val line = file.readText()
        Log.d("@dev",line)
    }

    fun appendText(){
        val file = File(activity.filesDir, "add.txt")
        file.appendText("Hola1")
        file.appendText("Hola2")
        file.appendText("Hola3")
        file.appendText("Hola4")
        val line = file.readText()
        Log.d("@dev",line)
    }

    fun appendTextWithNewLine(){
        val file = File(activity.filesDir, "add.txt")
        file.appendText("\n")
        file.appendText("Adios1")
        file.appendText("\n")
        file.appendText("Adios2")
        val line = file.readText()
        Log.d("@dev",line)
    }

    fun readLineByLine(){
        val file = File(activity.filesDir, "add.txt")
        file.writeText("linea1")
        file.appendText("\n")
        file.appendText("Linea2")
        file.appendText("\n")
        file.appendText("Linea3")

        val lines = file.readLines()
        lines.forEach {
            Log.d("@dev",it)
        }
    }

    fun deleteFiles(){
        val file = File(activity.filesDir, "add.txt")
        if(file.exists())
            file.delete()
    }

    /*escribir una linea vacia al principio*/

    fun saveToFile(colors: MutableList<String>){
        /*Se podria hacer también añadiendo una linea en blanco al principio en el foreach
        y asi quitamos el if.
        colors.forEach {
                file.writeText("")
                file.appendText(it)
                file.appendText("\n")
            }
         */
        val file = File(activity.filesDir, "colors.txt")
        if(file.exists()){
            file.delete()
        }
            colors.forEach {
                file.appendText(it)
                file.appendText("\n")
            }


    }

    fun readLineByLineColors(): MutableList<String> {
        val file = File(activity.filesDir, "colors.txt")
        val lines = file.readLines()
        val colorsReturn : MutableList<String> = mutableListOf()
        lines.forEach {
            //Log.d("@dev",it)
            colorsReturn.add(it)
        }
        return colorsReturn
    }

}