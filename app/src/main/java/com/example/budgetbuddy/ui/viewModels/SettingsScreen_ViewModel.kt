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
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class SettingsScreen_ViewModel(
    val _dataStoreRepository : UserSettingsRepository,
    ) : ViewModel() {

    private val _uiState : MutableStateFlow<SettingsScreen_UiState> = MutableStateFlow(
        SettingsScreen_UiState()
    )
    val uiState : StateFlow<SettingsScreen_UiState> = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            _dataStoreRepository.monthlySpendingLimit.collect {
                value ->
                _uiState.update {
                    currentState ->
                    currentState.copy(SavedDisplayMonthlyLimit = value.toString())
                }
            }
        }
    }

    fun updateMonthlySpendingTextField(_input : String) {
        _uiState.update { currentValue ->
            currentValue.copy(UiDisplayMonthlySpendingLimit = _input)
        }
    }

    suspend fun saveMonthlyMaxSpendingValue() {
        val savedString : String = _uiState.value.UiDisplayMonthlySpendingLimit
        _dataStoreRepository.saveSpendingPreference(savedString.toDouble())
        _uiState.update { currentValue ->
            currentValue.copy(
                UiDisplayMonthlySpendingLimit = "",
                SavedDisplayMonthlyLimit = savedString
            )
        }
    }
}