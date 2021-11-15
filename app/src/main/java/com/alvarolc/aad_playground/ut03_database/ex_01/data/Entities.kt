package com.alvarolc.aad_playground.ut03_database.ex_01.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
data class UserEntity(
    @PrimaryKey val id: Int,
    @ColumnInfo(name="name") val name: String,
    @ColumnInfo(name="username") val username: String,
    @ColumnInfo(name="email") val email: String?
)