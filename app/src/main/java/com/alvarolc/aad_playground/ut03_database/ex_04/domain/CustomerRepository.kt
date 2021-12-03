package com.alvarolc.aad_playground.ut03_database.ex_04.domain

import com.alvarolc.aad_playground.ut03_database.ex_04.data.local.CustomerModel

interface CustomerRepository {
    fun saveCustomer(customerModel: CustomerModel)
    fun delete(customerModel: CustomerModel)
    fun update(customerModel: CustomerModel)
    fun fetchAll(): List<CustomerModel>

}