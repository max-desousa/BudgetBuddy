package com.example.budgetbuddy.ui.viewModels

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.budgetbuddy.BudgetBuddyApplication

object AppViewModelProvider {
    val factory = viewModelFactory {
        initializer {
            SettingsScreen_ViewModel(
                budgetApplication().userMonthlySpendingDataStore
            )
        }
        initializer {
            MainScreen_ViewModel(
                //budgetApplication().userMonthlySpendingDataStore
            )
        }
    }
}

fun CreationExtras.budgetApplication() : BudgetBuddyApplication =
    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as BudgetBuddyApplication)