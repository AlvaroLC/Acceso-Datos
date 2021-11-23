package com.alvarolc.aad_playground.ut03_database.ex_03.data.local.xml

import com.alvarolc.aad_playground.ut03_database.ex_03.app.storage.LocalStorage
import com.alvarolc.aad_playground.ut03_database.ex_03.data.local.AlertLocalSource
import com.alvarolc.aad_playground.ut03_database.ex_03.domain.AlertModel

class AlertXmlLocalSource(private val localStorage: LocalStorage<AlertsLocalModel>) :
    AlertLocalSource {

    override fun findAll(): List<AlertModel> {
        val alerts = localStorage.fetch(AlertsLocalModel.ID, AlertsLocalModel::class.java)
        return alerts?.alerts ?: mutableListOf()
    }

    override fun save(alerts: List<AlertModel>) {
        alerts.map { alertModel -> save(alertModel) }
    }

    override fun save(alert: AlertModel) {
        TODO("Not yet implemented")
    }

    override fun findById(alertId: String): AlertModel? {
        TODO("Not yet implemented")
    }

}