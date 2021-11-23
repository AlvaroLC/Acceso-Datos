package com.alvarolc.aad_playground.ut03_database.ex_03.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import com.alvarolc.aad_playground.ut03_database.ex_03.app.api.RetrofitApiClient
import com.alvarolc.aad_playground.ut03_database.ex_03.domain.FindAlertUseCase
import com.alvarolc.aad_playground.ut03_database.ex_03.domain.GetAlertsUseCase

class Ut03Ex03ViewModel(private val getAlertsUseCase: GetAlertsUseCase,
                        private val findAlertUseCase: FindAlertUseCase) : ViewModel() {

    private val _alerts: MutableLiveData<AlertViewState> by lazy {
        MutableLiveData<AlertViewState>()
    }

    val alertObservable: LiveData<AlertViewState>
        get() = _alerts

    private val _alertDetail: MutableLiveData<AlertDetailViewState> by lazy {
        MutableLiveData<AlertDetailViewState>()
    }

    val alertDetailObservable: LiveData<AlertDetailViewState>
        get() = _alertDetail

    fun getAlerts() = viewModelScope.launch(Dispatchers.Main) {
        val alerts = getAlertsUseCase.execute()
        _alerts.value = AlertViewState(alerts)
    }

    fun findAlertDetail(alertId: String) = viewModelScope.launch(Dispatchers.Main) {
        val alertDetail = findAlertUseCase.execute(alertId)
        _alertDetail.value = AlertDetailViewState(alertDetail)
    }
}