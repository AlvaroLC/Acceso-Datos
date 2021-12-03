package com.alvarolc.aad_playground.ut03_database.ex_04.data.local.db.customer

import androidx.room.*
import com.alvarolc.aad_playground.ut03_database.ex_04.data.local.db.CustomerEntity

@Dao
interface CustomerDao {
    @Query("SELECT * FROM customer")
    fun findAll(): List<CustomerEntity>

    @Insert
    fun insert(customerEntity: CustomerEntity): Long

    @Delete
    fun delete(customerEntity: CustomerEntity)

    @Update
    fun update(customerEntity: CustomerEntity)
}