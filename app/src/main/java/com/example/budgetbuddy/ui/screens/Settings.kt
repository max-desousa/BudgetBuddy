package com.example.budgetbuddy.ui.screens


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.budgetbuddy.ui.viewModels.AppViewModelProvider
import com.example.budgetbuddy.ui.viewModels.SettingsScreen_ViewModel
import kotlinx.coroutines.launch


@Composable
fun SettingsScreen(
    settingsViewModel : SettingsScreen_ViewModel = viewModel(factory = AppViewModelProvider.factory)
) {
    val coroutineScope = rememberCoroutineScope()
    val settingsUiState = settingsViewModel.uiState.collectAsState()
    Card(
        modifier = Modifier
            .padding(all = 5.dp)
    ) {
        Column (
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .padding(all = 5.dp)
        ) {
            Text(text = "Set Monthly Maximum Spending:")
            OutlinedTextField(
                value = settingsUiState.value.MonthlySpendingLimit,
                enabled = true,
                placeholder = { Text(text = settingsUiState.value.MonthlySpendingLimit) },
                onValueChange = {
                    settingsViewModel.updateMonthlySpendingTextField(it)
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
            Button(
                onClick = {
                    coroutineScope.launch {
                        settingsViewModel.saveMonthlyMaxSpendingValue()
                    }
                }
            ) {
                Text(text = "Save Value to System Memory")
            }
        }
    }
}

@Preview
@Composable
fun PreviewSettingsScreen() {
    SettingsScreen()
}