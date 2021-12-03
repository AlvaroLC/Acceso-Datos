package com.alvarolc.aad_playground.ut03_database.ex05.data.local.xml

import com.alvarolc.aad_playground.ut03_database.ex05.app.storage.LocalModel
import com.alvarolc.aad_playground.ut03_database.ex05.domain.AlertModel


class AlertsLocalModel(
    val index: String,
    val alerts: List<AlertModel>
) : LocalModel {
    override fun getId(): String = index

    companion object {
        val ID: String = AlertsLocalModel::class.java.simpleName
    }
}