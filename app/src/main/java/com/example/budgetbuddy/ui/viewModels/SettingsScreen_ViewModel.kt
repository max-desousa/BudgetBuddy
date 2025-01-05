package com.example.budgetbuddy.ui.viewModels

import UserSettingsRepository
import androidx.datastore.dataStore
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.budgetbuddy.ui.uiStates.SettingsScreen_UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.runBlocking

class SettingsScreen_ViewModel(
    val _dataStoreRepository : UserSettingsRepository,
    ) : ViewModel() {
    //private val _uiState : MutableStateFlow<SettingsScreen_UiState> =
    //    //MutableStateFlow(SettingsScreen_UiState())
    //    _dataStoreRepository.monthlySpendingLimit.map { monthlySpending ->
    //        MutableStateFlow(SettingsScreen_UiState(MonthlySpendingLimit = monthlySpending.toString()))
    //    }
    val uiState: StateFlow<SettingsScreen_UiState> =
        _dataStoreRepository.monthlySpendingLimit.map { monthlySpending ->
            SettingsScreen_UiState(MonthlySpendingLimit = monthlySpending.toString())
        }.stateIn(
            scope = viewModelScope,
            // Flow is set to emits value for when app is on the foreground
            // 5 seconds stop delay is added to ensure it flows continuously
            // for cases such as configuration change
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = runBlocking {
                SettingsScreen_UiState(
                    MonthlySpendingLimit = _dataStoreRepository.monthlySpendingLimit.first().toString()
                )
            }
        )
    //private val _uiState = MutableStateFlow(SettingsScreen_UiState())
    //val uiState : StateFlow<SettingsScreen_UiState> = _uiState.asStateFlow()

    //init {
    //    _dataStoreRepository.monthlySpendingLimit.map { monthlySpendingLimit ->
    //        _uiState.update {
    //            currentValue ->123456
    //            currentValue.copy(MonthlySpendingLimit = monthlySpendingLimit.toString())
    //        }
    //    }
    //}

    fun updateMonthlySpendingTextField(_input : String) {
        uiState.update { currentValue ->
            currentValue.copy(MonthlySpendingLimit = _input)
        }
    }

    suspend fun saveMonthlyMaxSpendingValue() {
        //_dataStoreRepository.saveSpendingPreference(_uiState.value.MonthlySpendingLimit.toDouble())
        //_uiState.update { currentValue ->
        //    currentValue.copy(MonthlySpendingLimit = "")
        //}
    }
}