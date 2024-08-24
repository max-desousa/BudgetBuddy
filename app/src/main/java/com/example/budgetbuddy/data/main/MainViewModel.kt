package com.example.budgetbuddy.data.main

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import java.math.BigDecimal

class MainViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(MainUiState())
    val uiState : StateFlow<MainUiState> = _uiState.asStateFlow()

    init {
        readDatabase()
    }

    fun readDatabase() {
        _uiState.value = MainUiState()
    }

    fun addExpense(_expense : BigDecimal) {
        _uiState.value.periodSpending.plus(_expense)
        _uiState.value.dailyExpenditure.plus(_expense)

    }
}