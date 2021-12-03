package com.alvarolc.aad_playground.ut03_database.ex_04.data.local.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction

@Dao
interface InvoiceLinesDao {
    @Query("SELECT * FROM invoice")
    fun findAll(): List<InvoiceLinesEntity>

    @Insert
    fun insert(invoiceLinesEntity: InvoiceLinesEntity): Long

    @Insert
    fun insertInvoiceLinesAndProduct(invoiceLinesEntity: InvoiceLinesEntity, productEntity: ProductEntity)

    @Transaction
    @Query("SELECT * FROM invoice")
    fun getInvoiceLinesAndProduct(): List<InvoiceLinesAndProduct>?

}