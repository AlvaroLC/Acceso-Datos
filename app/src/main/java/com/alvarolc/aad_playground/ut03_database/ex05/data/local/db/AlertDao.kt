package com.alvarolc.aad_playground.ut03_database.ex05.data.local.db

import androidx.room.*

@Dao
interface AlertDao {

    @Transaction
    @Query("SELECT * FROM alerts")
    fun findAll(): List<AlertAndFiles>

    @Transaction
    @Query("SELECT * FROM alerts WHERE id = :alertId")
    fun findById(alertId: String): AlertAndFiles?

    @Insert
    fun insert(alertEntity: AlertEntity)

    @Update
    fun update(alertEntity: AlertEntity)
}