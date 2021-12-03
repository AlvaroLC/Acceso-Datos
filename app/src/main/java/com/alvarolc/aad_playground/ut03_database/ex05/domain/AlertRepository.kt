package com.alvarolc.aad_playground.ut03_database.ex05.domain

interface AlertRepository {
    suspend fun fetchAll(): List<AlertModel>
    suspend fun fetchById(alertId: String): AlertModel
}