package com.alvarolc.aad_playground.ut03_database.ex_03.domain

interface AlertRepository {
    fun fetchAll(): List<AlertModel>
    fun fetchById(alertId: String): AlertModel?
}