package com.alvarolc.aad_playground.ut03_database.ex_03.domain

class GetAlertsUseCase(private val repository:AlertRepository) {
    fun execute():List<AlertModel> = repository.fetchAll()
}