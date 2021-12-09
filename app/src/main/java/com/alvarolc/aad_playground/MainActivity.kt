package com.alvarolc.aad_playground

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import com.alvarolc.aad_playground.UT_01.Ejercicio01
import java.io.File

class MainActivity : AppCompatActivity() {

    //Ejercicios
    private lateinit var inputNameFile: AppCompatEditText
    private lateinit var inputContentFile: AppCompatEditText
    private lateinit var buttonSave: AppCompatButton
    private lateinit var buttonList: AppCompatButton
    private lateinit var buttonShowContent: AppCompatButton
    private lateinit var viewerFiles: TextView
    private lateinit var textFileName: TextView
    private lateinit var textFileContent: TextView

    val exercise01 = Ejercicio01(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupView()
    }

    private fun setupView() {
        inputNameFile = findViewById(R.id.input_name_file)
        inputContentFile = findViewById(R.id.input_content_file)
        viewerFiles = findViewById(R.id.viewer_files)
        //textFileName = findViewById(R.id.text_file_name)
        textFileContent = findViewById(R.id.text_file_content)
        buttonSave = findViewById(R.id.action_save)
        buttonSave.setOnClickListener {
            exercise01.saveFile(inputNameFile,inputContentFile)
        }

        buttonList = findViewById(R.id.action_explorer)
        buttonList.setOnClickListener {
            exercise01.saveFile(inputNameFile,inputContentFile)
        }

        buttonShowContent = findViewById(R.id.action_show_content)
        buttonShowContent.setOnClickListener {
            //exercise01.showFileContent()
        }

        //Coger texto de un AppCompatEditText
        inputNameFile.text.toString()
        //textFileContent.text = textFileContent.text.toString() + "Hola"
    }



/*
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val exercise01 = Ejercicio01(this)
        exercise01.setupView()
    }



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
        }*/
        //val filePlayGround = FilePlayGround(this)
        //filePlayGround.createFolder()
        //val dataStorageType = DataStorageType(this)
        //dataStorageType.privateFileCache()
        //dataStorageType.privateExternalCacheFile()


    }

    /*private fun initColors(){
        colors.add("Blue")
        colors.add("Red")
        colors.add("Orange")
        colors.add("Green")
    }
}*/