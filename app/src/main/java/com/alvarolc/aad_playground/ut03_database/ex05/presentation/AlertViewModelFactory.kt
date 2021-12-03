package com.alvarolc.aad_playground.ut03_database.ex05.presentation

import com.alvarolc.aad_playground.ut03_database.ex05.app.api.RetrofitApiClient
import com.alvarolc.aad_playground.ut03_database.ex05.data.AlertDataRepository
import com.alvarolc.aad_playground.ut03_database.ex05.data.local.AlertLocalSource
import com.alvarolc.aad_playground.ut03_database.ex05.data.remote.AlertRemoteSource
import com.alvarolc.aad_playground.ut03_database.ex05.domain.FindAlertUseCase
import com.alvarolc.aad_playground.ut03_database.ex05.domain.GetAlertsUseCase

class AlertViewModelFactory {

    companion object {
        fun build(alertLocalSource: AlertLocalSource): Ut03ex05ViewModel {
            val repository =
                AlertDataRepository(alertLocalSource, AlertRemoteSource(RetrofitApiClient()))

            return Ut03ex05ViewModel(GetAlertsUseCase(repository), FindAlertUseCase(repository))
        }
    }
}