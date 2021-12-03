package com.alvarolc.aad_playground.ut03_database.ex05.data.local.db

import android.content.Context
import com.alvarolc.aad_playground.ut03_database.ex05.app.db.Ut03ex05Database
import com.alvarolc.aad_playground.ut03_database.ex05.data.local.AlertLocalSource
import com.alvarolc.aad_playground.ut03_database.ex05.domain.AlertModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class AlertDbLocalSource(private val appContext: Context) : AlertLocalSource {

    private val db = Ut03ex05Database.getInstance(appContext)

    override suspend fun findAll(): List<AlertModel> = withContext(Dispatchers.IO) {
        val dbAlerts = db.alertDao().findAll()
        dbAlerts.map { alertEntity -> alertEntity.toModel() }
    }

    override suspend fun save(alerts: List<AlertModel>) = withContext(Dispatchers.IO) {
        alerts.forEach { alertModel ->
            //para acceder a withTransaction necesitamos añadir el import:
            //implementation "androidx.room:room-ktx:$room_version"
            db.alertDao().insert(AlertEntity.toEntity(alertModel))
        }
    }

    override suspend fun save(alert: AlertModel) = withContext(Dispatchers.IO) {
        //Añado primero los ficheros
        db.fileDao().insert(alert.files.map { fileModel ->
            FileEntity.toEntity(alert.id, fileModel)
        })

        //Actualizo la Alerta
        db.alertDao().update(AlertEntity.toEntity(alert))
    }

    override suspend fun findById(alertId: String): AlertModel? = withContext(Dispatchers.IO) {
        val alertEntity = db.alertDao().findById(alertId)
        alertEntity?.toModel()
    }
}