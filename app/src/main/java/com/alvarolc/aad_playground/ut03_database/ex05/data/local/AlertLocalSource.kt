package com.alvarolc.aad_playground.ut03_database.ex05.data.local

import com.alvarolc.aad_playground.ut03_database.ex05.domain.AlertModel

interface AlertLocalSource {

    /**
     * Obtengo un listado de alertas. Devuelve modelos de dominio.
     */
    suspend fun findAll(): List<AlertModel>

    suspend fun save(alerts: List<AlertModel>)

    suspend fun save(alert: AlertModel)

    suspend fun findById(alertId: String): AlertModel?
}