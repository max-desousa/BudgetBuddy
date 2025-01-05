package com.example.budgetbuddy.ui.screens

import SavingsItem
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun SavingsScreen(_items : List<SavingsItem>) {
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        Text(
            text = "Your Savings initiative!",
        )
        LazyColumn (
            modifier = Modifier.weight(1f)
        ){
            _items.forEach {
                item {
                    SavingsCard(
                        _title = it.Name,
                        _amountSaved = it.AmountSaved,
                        _targetSavings = it.FinancialTarget,
                        //_modifier = Modifier.padding(all = 3.dp)
                    )
                }
            }
        }
        Card (
            //modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(all = 5.dp)
            ) {
                Button(
                    onClick = { /*TODO*/ }
                ) {
                    Text(
                        text = "Add Savings Item"
                    )
                }
                Button(
                    onClick = {}
                ) {
                    Text(
                        text = "Delete Savings Item"
                    )
                }
            }
        }
    }
}

@Composable
fun SavingsCard (
    _title : String,
    _amountSaved : Int,
    _targetSavings : Int,
    _modifier : Modifier = Modifier
) {
    Card (
        modifier = Modifier
            .fillMaxWidth()
            .padding(all = 10.dp)
    ){
        Column {
            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,

            ) {
                Text(
                    text = "${_title}",
                    modifier = Modifier.padding(top = 5.dp, start = 5.dp)
                )
            }
            Row (
                verticalAlignment = Alignment.CenterVertically
            ){
                Spacer(modifier = Modifier.weight(1f))
                LinearProgressIndicator(progress = _amountSaved/_targetSavings.toFloat(),
                    trackColor = Color.LightGray,
                    //modifier = Modifier.padding(start = 15.dp, end = 15.dp, top = 5.dp, bottom = 5.dp)
                )
                Spacer(modifier = Modifier.weight(1f))
                Text(text = "\$${_amountSaved}")
                Text(text = "/")
                Text(text = "\$${_targetSavings}")
                Spacer(modifier = Modifier.weight(1f))
            }
        }
    }
}

@Preview
@Composable
fun previewSavingsCard() {
    SavingsCard(
        "Laptop",
        300,
        1900
    )
}

@Preview(showBackground = true)
@Composable
fun previewSavingsScreen() {
    var localListOfItems = listOf(
        SavingsItem(Name = "laptop", AmountSaved = 5, FinancialTarget = 100),
        SavingsItem(Name = "laptop", AmountSaved = 53, FinancialTarget = 100),
        SavingsItem(Name = "laptop", AmountSaved = 86, FinancialTarget = 100),
        SavingsItem(Name = "laptop", AmountSaved = 99, FinancialTarget = 100),
        SavingsItem(Name = "laptop", AmountSaved = 99, FinancialTarget = 100),
        SavingsItem(Name = "laptop", AmountSaved = 99, FinancialTarget = 100),
        SavingsItem(Name = "laptop", AmountSaved = 99, FinancialTarget = 100),
        SavingsItem(Name = "laptop", AmountSaved = 99, FinancialTarget = 100),
        SavingsItem(Name = "laptop", AmountSaved = 99, FinancialTarget = 100),
        SavingsItem(Name = "laptop", AmountSaved = 99, FinancialTarget = 100),
        SavingsItem(Name = "laptop", AmountSaved = 99, FinancialTarget = 100),
        SavingsItem(Name = "laptop", AmountSaved = 99, FinancialTarget = 100),
        SavingsItem(Name = "laptop", AmountSaved = 99, FinancialTarget = 100),
        SavingsItem(Name = "laptop", AmountSaved = 99, FinancialTarget = 100),
        SavingsItem(Name = "laptop", AmountSaved = 99, FinancialTarget = 100),
        SavingsItem(Name = "laptop", AmountSaved = 99, FinancialTarget = 100),
        SavingsItem(Name = "laptop", AmountSaved = 99, FinancialTarget = 100),
        SavingsItem(Name = "laptop", AmountSaved = 99, FinancialTarget = 100),
        SavingsItem(Name = "laptop", AmountSaved = 99, FinancialTarget = 100),
        SavingsItem(Name = "laptop", AmountSaved = 99, FinancialTarget = 100),
        SavingsItem(Name = "laptop", AmountSaved = 99, FinancialTarget = 100),
        SavingsItem(Name = "laptop", AmountSaved = 99, FinancialTarget = 100),
        SavingsItem(Name = "laptop", AmountSaved = 99, FinancialTarget = 100),
        SavingsItem(Name = "laptop", AmountSaved = 99, FinancialTarget = 100),
        SavingsItem(Name = "laptop", AmountSaved = 99, FinancialTarget = 100),
        SavingsItem(Name = "laptop", AmountSaved = 99, FinancialTarget = 100),
        SavingsItem(Name = "laptop", AmountSaved = 99, FinancialTarget = 100),
        SavingsItem(Name = "laptop", AmountSaved = 99, FinancialTarget = 100),
        SavingsItem(Name = "laptop", AmountSaved = 99, FinancialTarget = 100),
        SavingsItem(Name = "laptop", AmountSaved = 99, FinancialTarget = 100),
        SavingsItem(Name = "laptop", AmountSaved = 99, FinancialTarget = 100),
        SavingsItem(Name = "laptop", AmountSaved = 99, FinancialTarget = 100),
        SavingsItem(Name = "laptop", AmountSaved = 99, FinancialTarget = 100),
        SavingsItem(Name = "laptop", AmountSaved = 99, FinancialTarget = 100),
        SavingsItem(Name = "laptop", AmountSaved = 99, FinancialTarget = 100),
        SavingsItem(Name = "laptop", AmountSaved = 99, FinancialTarget = 100),
        SavingsItem(Name = "laptop", AmountSaved = 99, FinancialTarget = 100),
        SavingsItem(Name = "laptop", AmountSaved = 99, FinancialTarget = 100),
    )
    SavingsScreen(localListOfItems)
}