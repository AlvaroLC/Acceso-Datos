package com.alvarolc.aad_playground.ut03_database.ex_04.data.local.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction

@Dao
interface InvoiceDao {
    @Query("SELECT * FROM invoice")
    fun findAll(): List<InvoiceEntity>

    @Insert
    fun insert(invoiceEntity: InvoiceEntity): Long

    @Insert
    fun insertInvoiceAndInvoiceLines(invoiceEntity: InvoiceEntity, invoiceLinesEntity: InvoiceLinesEntity)


    @Transaction
    @Query("SELECT * FROM invoice")
    fun getInvoiceAndInvoiceLines(): List<InvoiceAndInvoiceLines>?

}