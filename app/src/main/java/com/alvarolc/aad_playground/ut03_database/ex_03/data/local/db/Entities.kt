package com.alvarolc.aad_playground.ut03_database.ex_03.data

import androidx.room.*
import com.alvarolc.aad_playground.ut03_database.ex_03.data.local.AlertLocalModel
import com.alvarolc.aad_playground.ut03_database.ex_03.domain.AlertModel
import com.alvarolc.aad_playground.ut03_database.ex_03.domain.FileModel

@Entity(tableName = "alert")
data class AlertEntity(
    @PrimaryKey @ColumnInfo(name = "id") val id: String,
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "type") val type: Int,
    @ColumnInfo(name = "date") val date: String,
    @ColumnInfo(name = "summary") val summary: String

) {
    fun toModel(files: List<FileEntity>): AlertModel {
        return AlertModel(
            id,
            title,
            type,
            summary,
            date,
            "",
            "",
            files.map { fileEntity -> fileEntity.toModel() }
        )
    }

    companion object {
        fun toEntity(alertModel: AlertModel) =
            AlertEntity(alertModel.id, alertModel.title, alertModel.type, alertModel.datePublished, alertModel.summary)
    }
}


@Entity(tableName = "file")
data class FileEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "url") val url: String,
    @ColumnInfo(name = "alert_id") val alertId: String
) {
    fun toModel() = FileModel(name, url)

    companion object {
        fun toEntity(fileModel: FileModel, alertId: String) =
            FileEntity(fileModel.name, fileModel.url, alertId)
    }
}

/**
 * Una alerta puede tener de 1:N files.
 *
 * Relación 1:N donde Alert cede su clave primaria a Files.
 */
data class AlertAndFiles(
    @Embedded val alertEntity: AlertEntity, //Entidad Principal
    @Relation(
        parentColumn = "id", //clave primaria de la entidad Alert
        entityColumn = "alert_id" //clave foránea de la entidad File.
    ) val fileEntity: List<FileEntity> //Entidad que recibe la clave de otra entidad
){
    fun toModel() = alertEntity.toModel(fileEntity)
}