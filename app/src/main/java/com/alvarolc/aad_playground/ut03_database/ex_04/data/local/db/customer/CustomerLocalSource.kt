package com.alvarolc.aad_playground.ut03_database.ex_04.data.local.db.customer

import android.content.Context
import com.alvarolc.aad_playground.ut03_database.ex_04.app.Ut03Ex04DataBase
import com.alvarolc.aad_playground.ut03_database.ex_04.data.local.CustomerModel
import com.alvarolc.aad_playground.ut03_database.ex_04.data.local.db.CustomerEntity

class CustomerLocalSource(applicationContext: Context) {

        private val db = Ut03Ex04DataBase.getInstance(applicationContext)

        init {
            Thread {
                db.clearAllTables()
            }.start()
            Thread.sleep(1000)
        }

        fun save(customerModel: CustomerModel) {
            db.customerDao().insert(CustomerEntity.toEntity(customerModel))
        }

    fun findAll(): List<CustomerModel> {
        val customers = db.customerDao().findAll()
        return customers.map { customersEntity -> customersEntity.toModel()}
    }

    fun delete(customerModel: CustomerModel){
        db.customerDao().delete(CustomerEntity.toEntity(customerModel))
    }

    fun update(customerModel: CustomerModel){
        db.customerDao().update(CustomerEntity.toEntity(customerModel))
    }

}