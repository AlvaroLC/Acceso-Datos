package com.alvarolc.aad_playground.ut03_database.ex05.app.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.alvarolc.aad_playground.ut03_database.ex05.data.local.db.AlertDao
import com.alvarolc.aad_playground.ut03_database.ex05.data.local.db.AlertEntity
import com.alvarolc.aad_playground.ut03_database.ex05.data.local.db.FileDao
import com.alvarolc.aad_playground.ut03_database.ex05.data.local.db.FileEntity


@Database(
        entities = [AlertEntity::class, FileEntity::class],
        version = 1,
        exportSchema = false
)
abstract class Ut03ex05Database : RoomDatabase() {

    abstract fun alertDao(): AlertDao
    abstract fun fileDao(): FileDao

    /**
     * Necesitamos crear una única instancia de la base de datos. Esto es así porque es muy
     * constoso en recursos de memoria usar varias instancias.
     *
     * A través del patrón de diseño SINGLETON creamos una instancia de la base de datos
     * y nos aseguramos que no se creen más.
     */
    companion object {
        @Volatile
        private var instance: Ut03ex05Database? = null

        fun getInstance(applicationContext: Context): Ut03ex05Database {
            return instance ?: synchronized(this) {
                instance ?: buildDatabase(applicationContext).also { instance = it }
            }
        }

        private fun buildDatabase(applicationContext: Context): Ut03ex05Database {
            return Room.databaseBuilder(
                    applicationContext,
                    Ut03ex05Database::class.java,
                    "db-ut03-ex05-alerts"
            ).build()
        }
    }
}