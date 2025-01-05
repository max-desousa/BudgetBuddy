package com.example.budgetbuddy

import UserSettingsRepository
import android.app.Application
import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore

class BudgetBuddyApplication : Application() {

    lateinit var userMonthlySpendingDataStore : UserSettingsRepository

    override fun onCreate() {
        super.onCreate()
        userMonthlySpendingDataStore = UserSettingsRepository(dataStore)
    }
}

private const val MONTHLY_SPENDING_LIMIT_NAME : String = "montly_spending_preferences"
private val Context.dataStore : DataStore<Preferences> by preferencesDataStore(
    name = MONTHLY_SPENDING_LIMIT_NAME
)