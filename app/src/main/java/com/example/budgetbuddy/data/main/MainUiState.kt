package com.example.budgetbuddy.data.main

data class MainUiState(
    val remainingAllowance : Int = 0,
    val overDailyBudget : Boolean = false,
    val overMonthlyBudget : Boolean = false,
)