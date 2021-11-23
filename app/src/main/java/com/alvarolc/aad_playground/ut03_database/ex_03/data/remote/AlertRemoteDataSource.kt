package com.alvarolc.aad_playground.ut03_database.ex_03.data.remote

import com.alvarolc.aad_playground.ut03_database.ex_03.app.api.ApiClient
import com.alvarolc.aad_playground.ut03_database.ex_03.domain.AlertModel

class AlertRemoteSource(private val apiClient: ApiClient) {

    fun getAlerts(): List<AlertModel> {
        val alertApiModel = apiClient.getAlerts()
        return alertApiModel.map { apiModel -> apiModel.toDomainModel() }
    }

    fun getAlert(alertId: String): AlertModel? =
        apiClient.getAlert(alertId)?.toDomainModel()

}