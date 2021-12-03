package com.alvarolc.aad_playground.ut03_database.ex05.data.local.xml

import com.alvarolc.aad_playground.ut03_database.ex05.app.storage.LocalStorage
import com.alvarolc.aad_playground.ut03_database.ex05.data.local.AlertLocalSource
import com.alvarolc.aad_playground.ut03_database.ex05.domain.AlertModel

/**
 * Implementación para trabajar con un local storage que debería ser un SharedPreferences
 * Esta alternativa mejora AlertXml2LocalSource
 * @see com.alvarolc.aad_playground.ut03.ex05.data.local.xml.AlertXmlLocalSource
 */
class AlertXmlExtraLocalSource(private val localStorage: LocalStorage<com.alvarolc.aad_playground.ut03_database.ex05.data.local.xml.AlertsLocalModel>) :
    AlertLocalSource {

    override suspend fun findAll(): List<AlertModel> {
        val alerts = localStorage.fetch(AlertsLocalModel.ID, com.alvarolc.aad_playground.ut03_database.ex05.data.local.xml.AlertsLocalModel::class.java)
        return alerts?.alerts ?: mutableListOf()
    }

    override suspend fun save(alerts: List<AlertModel>) {
        val localAlertModel =
            com.alvarolc.aad_playground.ut03_database.ex05.data.local.xml.AlertsLocalModel(AlertsLocalModel.ID,
                    alerts)
        localStorage.save(localAlertModel, com.alvarolc.aad_playground.ut03_database.ex05.data.local.xml.AlertsLocalModel::class.java)
    }

    override suspend fun save(alert: AlertModel) {
        localStorage.save(com.alvarolc.aad_playground.ut03_database.ex05.data.local.xml.AlertsLocalModel(
                alert.id,
                mutableListOf(alert)),
                com.alvarolc.aad_playground.ut03_database.ex05.data.local.xml.AlertsLocalModel::class.java)
    }

    override suspend fun findById(alertId: String): AlertModel? {
        val localModel = localStorage.fetch(alertId, com.alvarolc.aad_playground.ut03_database.ex05.data.local.xml.AlertsLocalModel::class.java)
        return localModel?.alerts?.firstOrNull()
    }
}