package com.alvarolc.aad_playground.ut03_database.ex_03.data.remote

import com.alvarolc.aad_playground.ut03_database.ex_03.domain.AlertModel

data class AlertApiModel(
    val alert_id: String,
    val title: String,
    val summary: String,
    val type: String,
    val date: String,
    val body: String? = "",
    val source: String? = ""
) {
    fun toDomainModel(): AlertModel = AlertModel(
        alert_id,
        title,
        type.toInt(),
        summary,
        date,
        body ?: "",
        source ?: ""
    )
}