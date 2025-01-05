package com.example.budgetbuddy.ui.Screens

import UserSettingsRepository
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch


@Composable
fun SettingsScreen() {
    val coroutineScope = rememberCoroutineScope()
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
                value = "Test",
                enabled = true,
                onValueChange = {},
            )
            Button(
                onClick = {
                    coroutineScope.launch {

                    }
                }
            ) {
                Text(text = "Save Value to System Memory")
            }
        }
    }
}

@Preview()
@Composable
fun PreviewSettingsScreen() {
    SettingsScreen()
}