package com.alvarolc.aad_playground.ut03_database.ex_02.data

import com.alvarolc.aad_playground.ut03_database.ex_02.domain.PersonModel
import com.alvarolc.aad_playground.ut03_database.ex_02.domain.PersonRepository

class PersonDataRepository(private val personLocalSource: PersonLocalSource) : PersonRepository{

    override fun savePerson(personModel: PersonModel){
        personLocalSource.save(personModel)
    }

    override suspend fun getPersonAndPetsAndCarsAndJobs(): List<PersonModel> {
        return personLocalSource.findPersonAndPetAndCarsAndJobs()
    }

    //override fun fetchAll(): List<PersonModel> = personLocalSource.findAll()
/**
    override fun getPersonAndPet(): List<PersonModel> {
        return personLocalSource.findPersonAndPet()
    }*/




}