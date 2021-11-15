package com.alvarolc.aad_playground.ut03_database.ex_01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.room.Room
import com.alvarolc.aad_playground.R
import com.alvarolc.aad_playground.ut03_database.ex_01.data.AppDataBase
import com.alvarolc.aad_playground.ut03_database.ex_01.data.UserEntity

class DataBaseActivity : AppCompatActivity() {

    private val TAG: String = DataBaseActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data_base)
        initDb()
    }

    private fun initDb(){
        val db = Room.databaseBuilder(
            applicationContext,
            AppDataBase::class.java,
            "demo-db"
        ).build()

        Thread(Runnable {
            var user = db.userDao().findById(1)
            if (user == null){
                db.userDao().insert(UserEntity(1, "name1", "username1", "email1"))
                user = db.userDao().findById(1)
            }
            Log.d(TAG, "$user")
        }).start()
    }
}
