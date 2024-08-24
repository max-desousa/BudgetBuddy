package com.example.budgetbuddy.data.main

import java.math.BigDecimal

data class MainUiState(
    val periodSpending : BigDecimal = BigDecimal.ZERO,
    val periodLimit : BigDecimal = BigDecimal("1000.00"),
    val dailyExpenditure : BigDecimal = BigDecimal.ZERO,
    val overDailyBudget : Boolean = false,
    val overMonthlyBudget : Boolean = false,
)