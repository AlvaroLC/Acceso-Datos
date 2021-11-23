package com.alvarolc.aad_playground.ut03_database.ex_03.data

import com.alvarolc.aad_playground.ut03_database.ex_02.domain.PersonModel
import com.alvarolc.aad_playground.ut03_database.ex_03.data.local.AlertLocalSource
import com.alvarolc.aad_playground.ut03_database.ex_03.data.remote.AlertRemoteSource
import com.alvarolc.aad_playground.ut03_database.ex_03.domain.AlertModel
import com.alvarolc.aad_playground.ut03_database.ex_03.domain.AlertRepository

class AlertDataRepository(private val localSource: AlertLocalSource,
                          private val remoteSource: AlertRemoteSource) : AlertRepository {

    /**
     * Si tengo el listado de alertas en local, las devuelvo, sino, las descargo de remoto,
     * las guardo en local y las devuelvo.
     */
    override fun fetchAll(): List<AlertModel> {
        var alerts = localSource.findAll()
        if (alerts.isEmpty()) {
            alerts = remoteSource.getAlerts()
            localSource.save(alerts)
        }
        return alerts
    }

    /**
     * Si tengo la alerta en local, la devuelvo, sino, la descargo de remoto,
     * la guardo en local y la devuelvo.
     *
     * Nota: No las guardo en el listado porque esta alerta tiene más información
     */
    override fun fetchById(alertId: String): AlertModel? {
        var alert = localSource.findById(alertId)
        if (alert == null) {
            alert = remoteSource.getAlert(alertId)
            alert?.let {
                localSource.save(alert)
            }
        }
        return alert
    }
}