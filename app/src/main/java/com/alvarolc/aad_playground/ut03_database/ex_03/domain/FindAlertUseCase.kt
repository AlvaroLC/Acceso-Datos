package com.alvarolc.aad_playground.ut03_database.ex_03.domain

class FindAlertUseCase(private val repository: AlertRepository) {
    fun execute(alertId:String):AlertModel?= repository.fetchById(alertId)
}