package com.alvarolc.aad_playground.ut03_database.ex_03.data.local.xml

import android.content.Context
import com.alvarolc.aad_playground.ut03_database.ex_03.app.db.AlertDataBase
import com.alvarolc.aad_playground.ut03_database.ex_03.data.AlertEntity
import com.alvarolc.aad_playground.ut03_database.ex_03.data.FileEntity
import com.alvarolc.aad_playground.ut03_database.ex_03.data.local.AlertLocalSource
import com.alvarolc.aad_playground.ut03_database.ex_03.domain.AlertModel

class AlertDbLocalSource2(private val context: Context) : AlertLocalSource {

    private val db : AlertDataBase by lazy {
        AlertDataBase.getInstance(context)
    }

    override fun findAll(): List<AlertModel> {
        val alerts = db.alertDao().findAll()
        return alerts.map { element -> element.toModel() }
    }

    override fun save(alert: AlertModel) {
        db.alertDao().insert(AlertEntity.toEntity(alert), alert.files.map { files -> FileEntity.toEntity(files, alert.id) })
    }

    override fun save(alerts: List<AlertModel>) {
        db.runInTransaction {
            alerts.forEach{save(it)}
        }
    }

    override fun findById(alertId: String): AlertModel? {
        val alert = db.alertDao().findById(alertId)
        return alert?.toModel()
    }


}