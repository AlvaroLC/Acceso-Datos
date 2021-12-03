package com.alvarolc.aad_playground.ut03_database.ex05.app.storage

interface LocalStorage<T : LocalModel> {
    fun fetch(modelId: String, typeClass: Class<T>): T?
    fun save(model: T, typeClass: Class<T>)
}