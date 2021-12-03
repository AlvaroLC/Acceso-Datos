package com.alvarolc.aad_playground.ut03_database.ex_04.domain

import com.alvarolc.aad_playground.ut03_database.ex_04.data.local.CustomerModel

class GetUseCase(private val customerRepository: CustomerRepository) {
    fun execute(): List<CustomerModel> = customerRepository.fetchAll()
}