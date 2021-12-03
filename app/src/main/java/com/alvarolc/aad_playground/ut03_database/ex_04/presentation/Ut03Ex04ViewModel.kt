package com.alvarolc.aad_playground.ut03_database.ex_04.presentation

import androidx.lifecycle.ViewModel
import com.alvarolc.aad_playground.ut03_database.ex_04.domain.GetUseCase

class Ut03Ex04ViewModel(private val useCase: GetUseCase) : ViewModel() {

    /**
     * Ejecuto una coroutine con un Scope (alcance) Global
     */
/**
    private val repository: CustomerRepository by lazy {
        CustomerDataRepository(CustomerLocalSource(applicationContext))
    }

    fun saveCustomer() {
        viewModelScope.launch(Dispatchers.Main) {
            var customers: List <CustomerModel> = mutableListOf()
            customers = useCase.execute()

            repository.savePerson(
            PersonModel(
            1, "Pepe", 10, "Calle Mayor",
            PetModel(3, "Pepe", 1),
            mutableListOf(CarModel(1, "Seat", "127"),
            CarModel(2, "Ford", "Malaga")),
            mutableListOf(JobModel(1, "Teacher"),
            JobModel(2, "Android Developer"))
            )
            )
            Log.d("@dev", "$customers")

        }

    }*/
}