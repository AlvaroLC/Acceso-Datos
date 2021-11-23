package com.alvarolc.aad_playground.ut03_database.ex_02.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alvarolc.aad_playground.ut03_database.ex_02.domain.*
import kotlinx.coroutines.*

class Ut03Ex02ViewModel(private val useCase: GetUseCase) : ViewModel() {

    /**
     * Ejecuto una coroutine con un Scope (alcance) Global
     */

    fun getUsers() {
        viewModelScope.launch(Dispatchers.Main) {
            var people: List <PersonModel> = mutableListOf()
            people = useCase.execute()
            /**repository.savePerson(
                PersonModel(
                    1, "Pepe", 10, "Calle Mayor",
                    PetModel(3, "Pepe", 1),
                    mutableListOf(CarModel(1, "Seat", "127"),
                        CarModel(2, "Ford", "Malaga")),
                    mutableListOf(JobModel(1, "Teacher"),
                        JobModel(2, "Android Developer"))
                )
            )*/
            Log.d("@dev", "$people")

        }

    }

}