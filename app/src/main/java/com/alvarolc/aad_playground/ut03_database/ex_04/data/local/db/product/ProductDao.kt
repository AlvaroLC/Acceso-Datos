package com.alvarolc.aad_playground.ut03_database.ex_04.data.local.db.product

import androidx.room.*
import com.alvarolc.aad_playground.ut03_database.ex_04.data.local.db.ProductEntity

@Dao
interface ProductDao {
    @Query("SELECT * FROM product")
    fun findAll(): List<ProductEntity>

    @Insert
    fun insert(productEntity: ProductEntity): Long

    @Delete
    fun delete(productEntity: ProductEntity)

    @Update
    fun update(productEntity: ProductEntity)
}