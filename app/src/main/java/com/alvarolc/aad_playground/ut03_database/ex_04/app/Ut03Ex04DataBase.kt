package com.alvarolc.aad_playground.ut03_database.ex_04.app

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.alvarolc.aad_playground.ut03_database.ex_04.data.local.db.customer.CustomerDao
import com.alvarolc.aad_playground.ut03_database.ex_04.data.local.db.CustomerEntity
import com.alvarolc.aad_playground.ut03_database.ex_04.data.local.db.product.ProductDao
import com.alvarolc.aad_playground.ut03_database.ex_04.data.local.db.ProductEntity

/** Para importar el room en el proyecto
 * //Room library
def room_version = "2.3.0"
implementation "androidx.room:room-runtime:$room_version"
implementation "androidx.room:room-ktx:$room_version"
kapt "androidx.room:room-compiler:$room_version"
 */

@Database(entities = [CustomerEntity::class, ProductEntity::class], version = 1, exportSchema = false)
abstract class Ut03Ex04DataBase : RoomDatabase() {

    abstract fun customerDao(): CustomerDao
    abstract fun productDao(): ProductDao


    /**
     * Necesitamos crear una única instancia de la base de datos. Esto es así porque es muy
     * constoso en recursos de memoria usar varias instancias.
     *
     * A través del patrón de diseño SINGLETON creamos una instancia de la base de datos
     * y nos aseguramos que no se creen más.
     */
    companion object {
        @Volatile
        private var instance: Ut03Ex04DataBase? = null

        fun getInstance(applicationContext: Context): Ut03Ex04DataBase {
            return instance ?: synchronized(this) {
                instance ?: buildDatabase(applicationContext).also { instance = it }
            }
        }

        private fun buildDatabase(applicationContext: Context): Ut03Ex04DataBase {
            return Room.databaseBuilder(
                applicationContext,
                Ut03Ex04DataBase::class.java,
                "db-ut03-ex02"
            ).build()
        }
    }
}