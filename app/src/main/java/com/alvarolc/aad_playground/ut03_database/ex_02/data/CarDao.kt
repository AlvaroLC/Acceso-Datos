package com.alvarolc.aad_playground.ut03_database.ex_02.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy

@Dao
interface CarDao {
    @Insert
    fun insert(carEntity: List<CarEntity>): List<Long>
}