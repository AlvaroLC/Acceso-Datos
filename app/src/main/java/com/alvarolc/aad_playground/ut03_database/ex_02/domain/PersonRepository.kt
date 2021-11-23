package com.alvarolc.aad_playground.ut03_database.ex_02.domain

import androidx.room.Query
import com.alvarolc.aad_playground.ut03_database.ex_02.data.PersonAndPetAndCarAndJob

interface PersonRepository {

    fun savePerson(personModel: PersonModel)
    //fun fetchAll(): List<PersonModel>
    //fun getPersonAndPet(): List<PersonModel>
    //fun getPersonAndPetAndCars(): List<PersonModel>
    suspend fun getPersonAndPetsAndCarsAndJobs(): List<PersonModel>
}