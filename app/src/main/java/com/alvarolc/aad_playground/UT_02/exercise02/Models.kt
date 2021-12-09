package com.alvarolc.aad_playground.UT_02.exercise02

interface LocalModel {
    fun getId(): Int
}

data class TapaLocalModel(val tapaId: Int, val name: String, val description: String): LocalModel{
    override fun getId(): Int = tapaId
}