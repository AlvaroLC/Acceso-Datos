package com.alvarolc.aad_playground.ut03_database.ex_02.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface PetDao {
    @Query("SELECT * FROM pet")
    fun findAll(): List<PetEntity>

    @Insert
    fun insert(petEntity: PetEntity)
}