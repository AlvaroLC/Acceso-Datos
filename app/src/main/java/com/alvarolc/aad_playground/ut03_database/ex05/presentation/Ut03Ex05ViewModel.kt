package com.alvarolc.aad_playground.ut03_database.ex05.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alvarolc.aad_playground.ut03_database.ex05.domain.FindAlertUseCase
import com.alvarolc.aad_playground.ut03_database.ex05.domain.GetAlertsUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class Ut03ex05ViewModel(private val getAlertsUseCase: GetAlertsUseCase,
                        private val findAlertUseCase: FindAlertUseCase
) : ViewModel() {

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