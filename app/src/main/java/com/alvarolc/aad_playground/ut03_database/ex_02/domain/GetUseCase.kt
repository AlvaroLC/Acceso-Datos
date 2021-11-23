package com.alvarolc.aad_playground.ut03_database.ex_02.domain

class GetUseCase(private val personRepository: PersonRepository) {
    suspend fun execute(): List<PersonModel> = personRepository.getPersonAndPetsAndCarsAndJobs()
}
