package com.example.budgetbuddy.ui.MainScreen

import android.text.BoringLayout
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.budgetbuddy.R
import com.example.budgetbuddy.data.main.MainViewModel

@Composable
fun BudgetBuddyApp(modifier: Modifier = Modifier) {
    val monthlyLimit : Int = 69
    var overBudget : Boolean = false
    val viewModel : MainViewModel = MainViewModel()
    Column (
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(all = 15.dp)
    ) {
        SimpleDisplayCard(
            _string = stringResource(id = R.string.monthly_limit),
            _num = monthlyLimit,
            _modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .padding(bottom = 10.dp)
        )
        SimpleDisplayCard(
            _string = stringResource(id = R.string.total_spending),
            _num = 7500,
            _modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 10.dp)
                .weight(1f))
        SimpleDisplayCard(
            _string = stringResource(id = R.string.daily_reminder),
            _num = 10,
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
                _num = 12,
                _modifier = Modifier
                    //.padding(10.dp)
                    .padding(end = 5.dp)
                    .weight(1f)
                    .fillMaxSize()
            )
            SimpleDisplayCard(
                _string = stringResource(id = R.string.daily_target),
                _num = 100,
                _modifier = Modifier
                    //.padding(10.dp)
                    .padding(start = 5.dp)
                    .weight(1f)
                    .fillMaxSize()
            )
        }
        SimpleDisplayCard(
            _string = "Final Placeholder card",
            _num = 45,
            _modifier = Modifier
                //.fillMaxWidth()
                .weight(1f)
        )
    }
}

@Composable
fun SimpleDisplayCard(
    _string : String,
    _num : Int,
    _modifier : Modifier = Modifier
) {
    Card (
        modifier = _modifier
    ) {
        Column (
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = _modifier
        ) {
            Text(text = _string, textAlign = TextAlign.Center)
            Text(text = "${_num}", textAlign = TextAlign.Center)
        }
    }
}

@Preview (showBackground = true)
@Composable
fun BudgetBuddyPreview() {
    BudgetBuddyApp()
}