package com.alvarolc.aad_playground.ut03_database.ex_03.app.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.alvarolc.aad_playground.ut03_database.ex_03.data.local.db.AlertDao
import com.alvarolc.aad_playground.ut03_database.ex_03.data.AlertEntity


@Database(entities = [AlertEntity::class], version = 1, exportSchema = false)
abstract class AlertDataBase : RoomDatabase() {

    abstract fun alertDao(): AlertDao


    /**
     * Necesitamos crear una única instancia de la base de datos. Esto es así porque es muy
     * constoso en recursos de memoria usar varias instancias.
     *
     * A través del patrón de diseño SINGLETON creamos una instancia de la base de datos
     * y nos aseguramos que no se creen más.
     */
    companion object {
        @Volatile
        private var instance: AlertDataBase? = null

        fun getInstance(applicationContext: Context): AlertDataBase {
            return instance ?: synchronized(this) {
                instance ?: buildDatabase(applicationContext).also { instance = it }
            }
        }

        private fun buildDatabase(applicationContext: Context): AlertDataBase {
            return Room.databaseBuilder(
                applicationContext,
                AlertDataBase::class.java,
                "db-ut03-ex02"
            ).build()
        }
    }
}