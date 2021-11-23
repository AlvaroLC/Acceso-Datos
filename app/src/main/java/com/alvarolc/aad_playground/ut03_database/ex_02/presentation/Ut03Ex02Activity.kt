package com.alvarolc.aad_playground.ut03_database.ex_02.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.viewModelScope
import com.alvarolc.aad_playground.R
import com.alvarolc.aad_playground.ut03_database.ex_02.data.PersonDataRepository
import com.alvarolc.aad_playground.ut03_database.ex_02.data.PersonLocalSource
import com.alvarolc.aad_playground.ut03_database.ex_02.domain.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class Ut03Ex02Activity : AppCompatActivity() {

    //private val TAG = Ut03Ex02Activity::class.java.simpleName
    //private val viewModel by viewModels<Ut03Ex02ViewModel>()

    private val viewModel = Ut03Ex02ViewModel(GetUseCase(PersonDataRepository(PersonLocalSource(applicationContext))))


                //private val repository: PersonRepository by lazy {
                //PersonDataRepository(PersonLocalSource((applicationContext)))
                //}

        override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_example02)
        executeQuery()
    }
                /**
                private fun executeQuery() {
                Thread{
            val carList: MutableList<CarModel> = mutableListOf(
                CarModel(1, "Audi", "A3"),
                CarModel(1, "Audi", "A5")
            )
            val carList1: MutableList<JobModel> = mutableListOf(
                JobModel(1, "name1"),
                JobModel(1, "name2")
            )
            repository.savePerson(PersonModel(1, "Name01", 1, "1", PetModel(1,"perro",2), carList,carList1))
            val people = repository.getPersonAndPetAndCars()
            Log.d(TAG, "$people")
                }.start()
                }*/

                private fun executeQuery() {
        /**
        Thread {
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
        val people = repository.getPersonAndPetsAndCarsAndJobs()
        Log.d("@dev", "$people")
        }.start()*/

        viewModel.getUsers()
    }

}