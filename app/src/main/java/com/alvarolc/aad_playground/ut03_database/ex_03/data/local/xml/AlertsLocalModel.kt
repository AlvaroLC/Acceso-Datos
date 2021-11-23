package com.alvarolc.aad_playground.ut03_database.ex_03.data.local.xml

import com.alvarolc.aad_playground.ut03_database.ex_03.data.local.LocalModel
import com.alvarolc.aad_playground.ut03_database.ex_03.domain.AlertModel

class AlertsLocalModel(val alertId: String, val alerts: List<AlertModel>) :
    LocalModel {
    override fun getId(): String = ID

    companion object {
        val ID: String = AlertsLocalModel::class.java.simpleName
    }
}