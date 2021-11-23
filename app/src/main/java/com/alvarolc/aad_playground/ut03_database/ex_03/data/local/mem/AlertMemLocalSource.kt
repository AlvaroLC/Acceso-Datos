package com.alvarolc.aad_playground.ut03_database.ex_03.data.local.mem

import com.alvarolc.aad_playground.ut03_database.ex_03.data.local.AlertLocalSource
import com.alvarolc.aad_playground.ut03_database.ex_03.domain.AlertModel

class AlertMemLocalSource : AlertLocalSource {

    override fun findAll(): List<AlertModel> {
        TODO("Not yet implemented")
    }

    override fun save(alerts: List<AlertModel>) {
        TODO("Not yet implemented")
    }

    override fun save(alert: AlertModel) {
        TODO("Not yet implemented")
    }

    override fun findById(alertId: String): AlertModel? {
        TODO("Not yet implemented")
    }
}