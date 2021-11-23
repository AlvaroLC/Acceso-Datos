package com.alvarolc.aad_playground.ut03_database.ex_03.app.storage

import com.alvarolc.aad_playground.ut03_database.ex_03.data.local.LocalModel

class FileLocalStorage<T: LocalModel> : LocalStorage<T> {
    override fun fetch(modelId: String, typeClass: Class<T>): T? {
        TODO("Not yet implemented")
    }

    override fun save(model: T, typeClass: Class<T>) {
        TODO("Not yet implemented")
    }
}