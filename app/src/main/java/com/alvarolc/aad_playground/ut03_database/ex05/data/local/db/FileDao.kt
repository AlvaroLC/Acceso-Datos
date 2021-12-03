package com.alvarolc.aad_playground.ut03_database.ex05.data.local.db

import androidx.room.Dao
import androidx.room.Insert

@Dao
interface FileDao {
    @Insert
    fun insert(fileEntities: List<FileEntity>)
}