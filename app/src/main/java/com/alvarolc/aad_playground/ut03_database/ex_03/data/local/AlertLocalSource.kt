package com.alvarolc.aad_playground.ut03_database.ex_03.data.local

import com.alvarolc.aad_playground.ut03_database.ex_03.domain.AlertModel

interface AlertLocalSource {

    /**
     * Obtengo un listado de alertas. Devuelve modelos de dominio.
     */
    fun findAll(): List<AlertModel>

    fun save(alerts: List<AlertModel>)

    fun save(alert: AlertModel)

    fun findById(alertId: String): AlertModel?
}