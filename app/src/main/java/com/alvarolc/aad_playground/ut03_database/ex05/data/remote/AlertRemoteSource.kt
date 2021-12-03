package com.alvarolc.aad_playground.ut03_database.ex05.data.remote

import com.alvarolc.aad_playground.ut03_database.ex05.app.api.ApiClient
import com.alvarolc.aad_playground.ut03_database.ex05.domain.AlertModel


class AlertRemoteSource(private val apiClient: ApiClient) {

    suspend fun getAlerts(): List<AlertModel> {
        val alertApiModel = apiClient.getAlerts()
        return alertApiModel.map { apiModel -> apiModel.toDomainModel() }
    }

    suspend fun getAlert(alertId: String): AlertModel? {
        val alert = apiClient.getAlert(alertId)
        return alert?.toDomainModel()
    }
}