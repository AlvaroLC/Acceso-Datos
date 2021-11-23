package com.alvarolc.aad_playground.ut03_database.ex_02.data

import android.content.Context
import com.alvarolc.aad_playground.ut03_database.ex_02.app.Ut03Ex02Database
import com.alvarolc.aad_playground.ut03_database.ex_02.domain.PersonModel

class PersonLocalSource(applicationContext: Context) {

    private val db = Ut03Ex02Database.getInstance(applicationContext)

    init {
        Thread {
            db.clearAllTables()
        }.start()
        Thread.sleep(1000)
    }

/**
    fun findAll(): List<PersonModel> {
        val people = db.personDao().findAll()
        return people.map { peopleEntity -> peopleEntity.toModel()}
    }

    fun findPersonAndPet(): List<PersonModel>{
        val personAndPets = db.personDao().getPersonAndPets()
        return personAndPets?.map { element -> element.toModel() } ?: mutableListOf()
    }

    fun findPersonAndPetAndCars(): List<PersonModel>{
        val personAndPetsAndCars = db.personDao().getPersonAndPetsAndCars()
        return personAndPetsAndCars?.map { element -> element.toModel() } ?: mutableListOf()
    }*/

    fun findPersonAndPetAndCarsAndJobs(): List<PersonModel>{
        val personAndPetsAndCarsAndJobs = db.personDao().getPersonAndPetsAndCarsAndJobs()
        return personAndPetsAndCarsAndJobs.map { element -> element.toModel() } ?: mutableListOf()
    }


    fun save(personModel: PersonModel) {
        db.personDao().insertPeopleAndPetAndCarsAndJobs(
                PersonEntity.toEntity(personModel),
                PetEntity.toEntity(personModel.petModel, personModel.id),
                CarEntity.toEntity(personModel.carModel, personModel.id),
                JobEntity.toEntity(personModel.jobModel),
                PersonJobEntity.toEntity(personModel.id, personModel.jobModel.map { it.id })
        )
    }

}