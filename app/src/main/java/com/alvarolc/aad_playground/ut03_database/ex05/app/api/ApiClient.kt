package com.alvarolc.aad_playground.ut03_database.ex05.app.api

import com.alvarolc.aad_playground.ut03_database.ex05.data.remote.AlertApiModel


interface ApiClient {
    suspend fun getAlerts(): List<AlertApiModel>
    suspend fun getAlert(alertId: String): AlertApiModel?
}
