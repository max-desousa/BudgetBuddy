package com.example.budgetbuddy

import SavingsItem
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.budgetbuddy.ui.MainScreen.BudgetBuddyApp
import com.example.budgetbuddy.ui.MainScreen.BudgetBuddyTopBar
import com.example.budgetbuddy.ui.Navigation.BudgetBuddyTopRowContents
import com.example.budgetbuddy.ui.Navigation.MonthlyBudgetTracker
import com.example.budgetbuddy.ui.Navigation.SavingsTracker
import com.example.budgetbuddy.ui.Navigation.SettingsScreen
import com.example.budgetbuddy.ui.Screens.SavingsScreen
import com.example.budgetbuddy.ui.theme.BudgetBuddyTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BudgetBuddyApplication()
        }
    }
}


@Preview
@Composable
fun BudgetBuddyApplication() {
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
                    BudgetBuddyApp()
                }
                composable(route = SavingsTracker.route) {
                    SavingsScreen(_items = _DEMO_SAVINGS_ITEMS_)
                }
                composable(route = SettingsScreen.route) {

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