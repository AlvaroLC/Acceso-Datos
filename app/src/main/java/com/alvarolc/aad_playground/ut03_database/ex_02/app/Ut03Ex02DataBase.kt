package com.alvarolc.aad_playground.ut03_database.ex_02.app

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.alvarolc.aad_playground.ut03_database.ex_02.data.*

@Database(entities = [PersonEntity::class, PetEntity::class, CarEntity::class, JobEntity::class, PersonJobEntity::class], version = 1, exportSchema = false)
abstract class Ut03Ex02Database : RoomDatabase() {

    abstract fun personDao(): PersonDao
    abstract fun petDao() : PetDao


    /**
     * Necesitamos crear una única instancia de la base de datos. Esto es así porque es muy
     * constoso en recursos de memoria usar varias instancias.
     *
     * A través del patrón de diseño SINGLETON creamos una instancia de la base de datos
     * y nos aseguramos que no se creen más.
     */
    companion object {
        @Volatile
        private var instance: Ut03Ex02Database? = null

        fun getInstance(applicationContext: Context): Ut03Ex02Database {
            return instance ?: synchronized(this) {
                instance ?: buildDatabase(applicationContext).also { instance = it }
            }
        }

        private fun buildDatabase(applicationContext: Context): Ut03Ex02Database {
            return Room.databaseBuilder(
                applicationContext,
                Ut03Ex02Database::class.java,
                "db-ut03-ex02"
            ).build()
        }
    }
}