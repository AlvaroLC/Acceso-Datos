package com.alvarolc.aad_playground.ut03_database.ex_03.data.local.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import com.alvarolc.aad_playground.ut03_database.ex_03.data.AlertAndFiles
import com.alvarolc.aad_playground.ut03_database.ex_03.data.AlertEntity
import com.alvarolc.aad_playground.ut03_database.ex_03.data.FileEntity

@Dao
interface AlertDao {
    @Transaction
    @Query("SELECT * FROM alert")
    fun findAll(): List<AlertAndFiles>

    @Transaction
    @Query("SELECT * FROM alert WHERE id = :alertId")
    fun findById(alertId: String): AlertAndFiles?

    @Insert
    fun insert(alertEntity: AlertEntity, fileEntities: List<FileEntity>)

}