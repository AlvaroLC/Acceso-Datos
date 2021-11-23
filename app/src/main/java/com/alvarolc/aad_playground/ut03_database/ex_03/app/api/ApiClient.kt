package com.alvarolc.aad_playground.ut03_database.ex_03.app.api

import com.alvarolc.aad_playground.ut03_database.ex_03.data.remote.AlertApiModel

interface ApiClient {
    fun getAlerts(): List<AlertApiModel>
    fun getAlert(alertId: String): AlertApiModel?
}