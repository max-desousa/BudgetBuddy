package com.example.budgetbuddy.ui.Navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector

interface AppDestination {
    val route : String
    val icon : ImageVector
}

object MonthlyBudgetTracker : AppDestination {
    override val route = "monthly_spending"
    override val icon = Icons.Filled.Search
}

object SavingsTracker : AppDestination {
    override val route = "savings_tracker"
    override val icon = Icons.Filled.Done
}

object SettingsScreen : AppDestination {
    override val route = "settings_screen"
    override val icon = Icons.Filled.Settings
}

val BudgetBuddyTopRowContents = listOf(MonthlyBudgetTracker, SavingsTracker, SettingsScreen)