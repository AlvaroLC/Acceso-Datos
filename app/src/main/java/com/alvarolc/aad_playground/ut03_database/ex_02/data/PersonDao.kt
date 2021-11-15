package com.alvarolc.aad_playground.ut03_database.ex_02.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction

@Dao
interface PersonDao {

    @Query("SELECT * FROM person")
    fun findAll(): List<PersonEntity>

    @Insert
    fun insert(personEntity: PersonEntity): Long

    @Insert
    fun insertPersonAndPet(personEntity: PersonEntity, petEntity: PetEntity)

    @Insert
    fun insertPeopleAndPetAndCarsAndJobs(
        personEntity: PersonEntity,
        petEntity: PetEntity,
        carsEntity: List<CarEntity>,
        jobsEntities: List<JobEntity>,
        joinEntities: List<PersonJobEntity>
    )


    @Transaction
    @Query("SELECT * FROM person")
    fun getPersonAndPets(): List<PersonAndPet>?
/**
    @Transaction
    @Query("SELECT * FROM person")
    fun getPersonAndPetsAndCars(): List<PersonAndPetAndCar>?*/

    @Transaction
    @Query("SELECT * FROM person")
    fun getPersonAndPetsAndCarsAndJobs(): List<PersonAndPetAndCarAndJob>

}
