package com.alvarolc.aad_playground.ut03_database.ex_03.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.room.Room
import com.alvarolc.aad_playground.R
import com.alvarolc.aad_playground.ut03_database.ex_03.app.db.AlertDataBase
import com.alvarolc.aad_playground.ut03_database.ex_03.app.api.RetrofitApiClient
import com.alvarolc.aad_playground.ut03_database.ex_03.data.AlertDataRepository
import com.alvarolc.aad_playground.ut03_database.ex_03.data.AlertEntity
import com.alvarolc.aad_playground.ut03_database.ex_03.data.remote.AlertRemoteSource
import com.alvarolc.aad_playground.ut03_database.ex_03.domain.FindAlertUseCase
import com.alvarolc.aad_playground.ut03_database.ex_03.domain.GetAlertsUseCase

class Ut03Ex03Activity : AppCompatActivity() {

    private val TAG = Ut03Ex03Activity::class.java.simpleName

    //**** Código para probar la aplicación con una fuente de datos de ficheros.
    //private val viewModel: Ut03Ex03ViewModel by lazy {
    //    AlertViewModelFactory.build(AlertFileLocalSource(applicationContext,
    //            GsonSerializer(Gson())))
    //}

    //**** Código para probar la aplicación con una Base de Datos (Room)
    //private val viewModel: Ut03Ex03ViewModel by lazy {
    //    AlertViewModelFactory.build(AlertDbLocalSource(applicationContext))
    //}

    //*** Código para probar la aplicación con Shared Preferences (xml)
    //private val viewModel: Ut03Ex03ViewModel by lazy {
    //    AlertViewModelFactory.build(AlertXmlLocalSource(applicationContext, GsonSerializer(Gson())))
    //}

    //*** Código para probar la aplicación con una memoria como almacenamiento
    private val viewModel: Ut03Ex03ViewModel by lazy {
        AlertViewModelFactory.build(AlertMemLocalSource())
    }

    private val binding: ActivityUt03Ex03Binding by lazy {
        ActivityUt03Ex03Binding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupBinding()
        setupObservables()
        loadAlerts()
        loadAlertDetail("1900673") //Este número es un alert_id válido
    }

    private fun setupBinding() {
        setContentView(binding.root)
    }

    private fun setupObservables() {
        //Observador para el listado de Alertas
        val alertObserver = Observer<AlertViewState> { alertViewState ->
            renderAlerts(alertViewState)
        }
        //Uno mi observador al objeto que deseo observar y está en el viewmodel.
        //Paso this como ciclo de vida de la actividad.
        viewModel.alertObservable.observe(this, alertObserver)

        //Observador para el detalle de la alerta
        val alertDetailObserver = Observer<AlertDetailViewState> { alertDetailViewState ->
            renderAlertDetail(alertDetailViewState)
        }
        viewModel.alertDetailObservable.observe(this, alertDetailObserver)
    }

    private fun renderAlerts(alertViewState: AlertViewState) {
        alertViewState.data.forEach { alertModel ->
            Log.d(TAG, "$alertModel")
        }
    }

    private fun renderAlertDetail(alertDetailViewState: AlertDetailViewState) {
        Log.d(TAG, "${alertDetailViewState.data}")
    }

    private fun loadAlerts() {
        viewModel.getAlerts()
    }

    private fun loadAlertDetail(alertId: String) {
        viewModel.findAlertDetail(alertId)
    }
}