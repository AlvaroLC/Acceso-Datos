package com.alvarolc.aad_playground.ut03_database.ex05.domain

class FindAlertUseCase(private val repository: AlertRepository) {
    suspend fun execute(alertId: String): AlertModel = repository.fetchById(alertId)
}