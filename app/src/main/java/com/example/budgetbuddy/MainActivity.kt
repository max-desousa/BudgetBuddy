package com.example.budgetbuddy

import SavingsItem
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.budgetbuddy.ui.MainScreen.BudgetBuddyTopBar
import com.example.budgetbuddy.ui.MainScreen.Screen_BudgetBuddyApp
import com.example.budgetbuddy.ui.Navigation.BudgetBuddyTopRowContents
import com.example.budgetbuddy.ui.Navigation.MonthlyBudgetTracker
import com.example.budgetbuddy.ui.Navigation.SavingsTracker
import com.example.budgetbuddy.ui.Navigation.SettingsScreen
import com.example.budgetbuddy.ui.screens.SavingsScreen
import com.example.budgetbuddy.ui.screens.SettingsScreen
import com.example.budgetbuddy.ui.theme.BudgetBuddyTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BudgetBuddyApp()
        }
    }
}


@Preview
@Composable
fun BudgetBuddyApp() {
    BudgetBuddyTheme {
        val navController = rememberNavController()
        val currentBackStack by navController.currentBackStackEntryAsState()
        val currentDestination = currentBackStack?.destination
        val currentScreen = BudgetBuddyTopRowContents.find { it.route == currentDestination?.route } ?: MonthlyBudgetTracker
        Scaffold (
            topBar = {
                BudgetBuddyTopBar(
                    _screensToAdd = BudgetBuddyTopRowContents,
                    _onTabSelected = {newScreen ->
                        navController.navigateSingleTopTo(newScreen.route)
                    },
                    _currentScreen = currentScreen
                )
            }
        ){
            innerPadding ->
            NavHost(
                navController = navController,
                startDestination = MonthlyBudgetTracker.route,
                modifier = Modifier
                    .padding(innerPadding)
            ) {
                composable(route = MonthlyBudgetTracker.route) {
                    Screen_BudgetBuddyApp()
                }
                composable(route = SavingsTracker.route) {
                    SavingsScreen(_items = _DEMO_SAVINGS_ITEMS_)
                }
                composable(route = SettingsScreen.route) {
                    SettingsScreen()
                }
            }
        }
    }
}

fun NavHostController.navigateSingleTopTo(route : String) {
    this.navigate(route) {
        popUpTo(
            this@navigateSingleTopTo.graph.findStartDestination().id
        ) {
            saveState = true
        }
        launchSingleTop = true
        restoreState = true
    }
}

private val _DEMO_SAVINGS_ITEMS_ : List<SavingsItem> = listOf(
    SavingsItem("Laptop", 250, 1900),
    SavingsItem("Vacation", 400, 4000),
    SavingsItem("New Car", 350, 12000),
    SavingsItem("A proper house", 15000, 250000),
)