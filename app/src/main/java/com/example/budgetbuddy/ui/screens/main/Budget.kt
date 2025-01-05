package com.example.budgetbuddy.ui.screens.main

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.budgetbuddy.R
import com.example.budgetbuddy.ui.viewModels.AppViewModelProvider
import com.example.budgetbuddy.ui.viewModels.MainScreen_ViewModel
import java.math.BigDecimal
import java.text.NumberFormat

@Composable
fun BudgetBuddyApp(
    _mainScreenViewModel : MainScreen_ViewModel = viewModel(factory = AppViewModelProvider.factory),
    modifier: Modifier = Modifier
) {
    var overBudget : Boolean = false
    val uiState = _mainScreenViewModel.uiState.collectAsState()
    Column (
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(all = 15.dp)
    ) {
        SimpleDisplayCard(
            _string = stringResource(id = R.string.monthly_limit),
            _num = BigDecimal(uiState.value.MonthlySpendingLimit),
            _modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .padding(bottom = 10.dp)
        )
        SimpleDisplayCard(
            _string = stringResource(id = R.string.total_spending),
            _num = BigDecimal(101),
            _modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 10.dp)
                .weight(1f))
        SimpleDisplayCard(
            _string = stringResource(id = R.string.daily_reminder),
            _num = BigDecimal(10.0),
            _modifier = Modifier
                .padding(bottom = 10.dp)
                .fillMaxWidth()
                .fillMaxHeight()
                .weight(2f)
        )
        Row (
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .padding(bottom = 10.dp)
        ){
            SimpleDisplayCard(
                _string =
                if (overBudget)
                {
                    stringResource(id = R.string.over_budget)
                } else {
                    stringResource(id = R.string.within_budget)
                },
                _num = BigDecimal(12),
                _modifier = Modifier
                    //.padding(10.dp)
                    .padding(end = 5.dp)
                    .weight(1f)
                    .fillMaxSize()
            )
            SimpleDisplayCard(
                _string = stringResource(id = R.string.daily_target),
                _num = BigDecimal(100),
                _modifier = Modifier
                    //.padding(10.dp)
                    .padding(start = 5.dp)
                    .weight(1f)
                    .fillMaxSize()
            )
        }
//        SimpleDisplayCard(
//            _string = "Final Placeholder card",
//            _num = BigDecimal(45),
//            _modifier = Modifier
//                //.fillMaxWidth()
//                .weight(1f)
//        )
        EntryCard(
            modifier = Modifier
                .fillMaxWidth()
        )
    }
}

@Composable
fun SimpleDisplayCard(
    _string : String,
    _num : BigDecimal,
    _modifier : Modifier = Modifier
) {
    Card (
        modifier = _modifier
    ) {
        Column (
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = _modifier
                .padding(10.dp)
        ) {
            Text(text = _string, textAlign = TextAlign.Center)
            Text(text = NumberFormat.getCurrencyInstance().format(_num), textAlign = TextAlign.Center)
        }
    }
}

@Preview
@Composable
fun EntryCard(modifier : Modifier = Modifier) {
    Card {
        Column (
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier =  modifier
                .padding(10.dp)
        ) {
            OutlinedTextField(
                value = "Test",
                onValueChange = {},
                singleLine = true,
                modifier = Modifier
                    .fillMaxWidth()
            )
            OutlinedButton(
                onClick = { /*TODO*/ }
            ) {
                Text(text = stringResource(R.string.add_expense))
            }
        }
    }
}

@Preview (showBackground = true)
@Composable
fun BudgetBuddyPreview() {
    BudgetBuddyApp()
}