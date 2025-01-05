package com.example.budgetbuddy.ui.viewModels

import UserSettingsRepository
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.budgetbuddy.ui.uiStates.MainScreen_UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class MainScreen_ViewModel(
    //_dataStore : UserSettingsRepository
) : ViewModel() {
    private val _uiState = MutableStateFlow(MainScreen_UiState())
    val uiState : StateFlow<MainScreen_UiState> = _uiState.asStateFlow()


}