package com.alvarolc.aad_playground.ut03_database.ex_03.app.storage

import com.alvarolc.aad_playground.ut03_database.ex_03.data.local.LocalModel

interface LocalStorage<T : LocalModel> {
    fun fetch(modelId: String, typeClass: Class<T>): T?
    fun save(model: T, typeClass: Class<T>)
}