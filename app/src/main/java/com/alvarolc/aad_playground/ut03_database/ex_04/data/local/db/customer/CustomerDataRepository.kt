package com.alvarolc.aad_playground.ut03_database.ex_04.data.local.db.customer

import com.alvarolc.aad_playground.ut03_database.ex_04.data.local.CustomerModel
import com.alvarolc.aad_playground.ut03_database.ex_04.domain.CustomerRepository

class CustomerDataRepository(private val customerLocalSource: CustomerLocalSource) :
    CustomerRepository {


    override fun saveCustomer(customerModel: CustomerModel) {
        customerLocalSource.save(customerModel)
    }

    override fun delete(customerModel: CustomerModel) {
        customerLocalSource.delete(customerModel)
    }

    override fun update(customerModel: CustomerModel) {
        customerLocalSource.update(customerModel)
    }

    override fun fetchAll(): List<CustomerModel> = customerLocalSource.findAll()
}