package com.alvarolc.aad_playground.ut03_database.ex05.domain

class GetAlertsUseCase(private val repository: AlertRepository) {
    suspend fun execute(): List<AlertModel> = repository.fetchAll()
}