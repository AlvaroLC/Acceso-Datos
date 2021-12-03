package com.alvarolc.aad_playground.ut03_database.ex_04.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.alvarolc.aad_playground.R
import com.alvarolc.aad_playground.ut03_database.ex_04.data.local.CustomerModel

import com.alvarolc.aad_playground.ut03_database.ex_04.data.local.db.customer.CustomerDataRepository
import com.alvarolc.aad_playground.ut03_database.ex_04.data.local.db.customer.CustomerLocalSource
import com.alvarolc.aad_playground.ut03_database.ex_04.domain.CustomerRepository

class Ut03Ex04Activity : AppCompatActivity() {


    private val repository: CustomerRepository by lazy {
        CustomerDataRepository(CustomerLocalSource(applicationContext))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_example02)
        executeQuery()
    }


    private fun executeQuery() {

        Thread {
            repository.saveCustomer(CustomerModel(1, "namenjdnvjndjn", "username1"))
            repository.saveCustomer(CustomerModel(2, "name2", "username2"))
            val customers1 = repository.fetchAll()
            Log.d("@dev", "$customers1")
            repository.update(CustomerModel(1, "nameNuevo", "usernameActualizado"))
            repository.delete(CustomerModel(2, "", ""))
            val customers = repository.fetchAll()
            Log.d("@dev", "$customers")
        }.start()

    }
}