package com.alvarolc.aad_playground.ut03_database.ex_02.domain

data class PersonModel(
    val id: Int,
    val name: String,
    val age: Int,
    val address: String?,
    val petModel : PetModel,
    val carModel: MutableList<CarModel>,
    val jobModel: MutableList<JobModel>

)

data class PetModel(val id: Int, val name: String, val age: Int)

data class CarModel(val id: Int, val brand: String, val model: String)

data class JobModel(val id: Int, val name: String)