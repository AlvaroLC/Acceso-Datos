package com.alvarolc.aad_playground.ut03_database.ex05.domain

data class AlertModel(
        val id: String,
        val title: String,
        val type: Int,
        val summary: String,
        val datePublished: String,
        val body: String,
        val source: String,
        val files: List<FileModel>
)

data class FileModel(val id: Int, val name: String, val url: String)