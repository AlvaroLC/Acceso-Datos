package com.alvarolc.aad_playground.UT_01

import androidx.appcompat.app.AppCompatActivity
import java.io.File

class DataStorageType(private val activity: AppCompatActivity){

    fun privateFile(){
        val privateFile = File(activity.filesDir, "private.txt")
        privateFile.writeText("Fichero privado en el directorio de la app")
    }

    fun privateFileCache(){
        val privateFileCache = File(activity.cacheDir, "private_cache.txt")
        privateFileCache.writeText("Fichero cache creado")
    }

    //La ruta de los archivos externos es
    //data/sdcard/Android/data/com.alvarolc.aad/files/path
    fun privateExternalFile(){
        val externalFile = File(activity.getExternalFilesDir("path_directory"), "external.txt")
        externalFile.writeText("Privado en un almacenamiento externo")
    }

    fun privateExternalCacheFile(){
        val cacheExternalFile = File(activity.externalCacheDir,"cache_external_dir.txt")
        cacheExternalFile.writeText("External cache privado")
    }
}