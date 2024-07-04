package com.example.budgetbuddy

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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.budgetbuddy.ui.MainScreen.BudgetBuddyApp
import com.example.budgetbuddy.ui.theme.BudgetBuddyTheme

//class MainActivity : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContent {
//            BudgetBuddyApp()
//        }
//    }
//}


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BudgetBuddyTheme {
                 BudgetBuddyApp()
            }
        }
    }
}



//@Composable
//fun TotalSpending(
//    _budget : Int,
//    modifier: Modifier = Modifier
//)
//{
//    Card (modifier = modifier) {
//        Column (
//            horizontalAlignment = Alignment.CenterHorizontally,
//            verticalArrangement = Arrangement.Center,
//            modifier = modifier
//        ){
//            Text(text = "Your total spending for the month is:")
//            Text(text = "${_budget}")
//        }
//    }
//}
//
//@Preview(showBackground = true)
//@Composable
//fun TotoalSpendingPreview()
//{
//    TotalSpending(88)
//}
//
//@Composable()
//fun AddItemCard(modifier: Modifier = Modifier)
//{
//    Card (modifier = modifier){
//        Column (
//            horizontalAlignment = Alignment.CenterHorizontally,
//            verticalArrangement = Arrangement.Center,
//            modifier = modifier.padding(10.dp)
//        ) {
//            Text(text = "Add an Expense:")
//            OutlinedButton(
//                onClick = { },
//                shape = CircleShape,
//                border = BorderStroke(1.dp, Color.Blue),
//                contentPadding = PaddingValues(0.dp),
//                colors = ButtonDefaults.outlinedButtonColors(containerColor = Color.Blue),
//                modifier = Modifier.size(50.dp)
//            ) {
//                Icon(
//                    imageVector = Icons.Default.Add,
//                    contentDescription = null
//                )
//            }
//        }
//    }
//}
//
//@Preview(showBackground = true)
//@Composable
//fun AddItemPreview()
//{
//    AddItemCard()
//}
//
//fun BudgetCalc() : Int {
//    var BudgetForDay : Int = 0
//
//
//
//    return BudgetForDay
//}
//
//@Composable
//fun MyApp(modifier: Modifier = Modifier)
//{
//    var TodaysTotal : Int = 0
//    var PeriodTotal : Int = 0
//    var PeriodLimit : Int = 1000
//    Column (
//        verticalArrangement = Arrangement.SpaceBetween,
//        horizontalAlignment = Alignment.CenterHorizontally,
//        modifier = Modifier
//            .fillMaxSize()
//            .padding(all = 15.dp)
//    ){
//        MonthlyLimit(
//            _input = PeriodLimit,
//            modifier = modifier
//                .fillMaxWidth()
//                .weight(1f)
//                .padding(bottom = 10.dp))
//        TotalSpending(_budget = PeriodTotal,
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(bottom = 10.dp)
//                .weight(1f)
//        )
//        DailyRemainder(Balance = 50,
//            modifier = modifier
//                .padding(bottom = 10.dp)
//                .weight(2f)
//        )
//        Row (
//            horizontalArrangement = Arrangement.SpaceBetween,
//            modifier = Modifier
//                .fillMaxWidth()
//                .weight(1f)
//                .padding(bottom = 10.dp)
//        ){
//            OverallStatus(
//                _value = 12,
//                _overBudget = true,
//                modifier = Modifier
//                    .padding(end = 5.dp)
//                    .weight(1f)
//            )
//            DailyTarget(
//                _budget = 69,
//                modifier = Modifier
//                    .padding(start = 5.dp)
//                    .weight(1f)
//            )
//        }
//
//        AddItemCard(modifier = Modifier
//            //.padding(10.dp)
//            .weight(1f))
//    }
//}
//
//@Preview (showBackground = true)
//@Composable
//fun MonthlyLimitPreview(){
//    MonthlyLimit(30)
//}
//
//@Composable
//fun MonthlyLimit(_input : Int, modifier: Modifier = Modifier) {
//    Card (modifier = modifier) {
//        Column(
//            horizontalAlignment = Alignment.CenterHorizontally,
//            verticalArrangement = Arrangement.Center,
//            modifier = modifier
//        ){
//            Text(text = "You have set a budget this month of:")
//            Text(text = "\$$_input")
//        }
//    }
//}
//
//@Composable
//fun DailyTarget(
//    _budget : Int,
//    modifier: Modifier = Modifier
//)
//{
//    Card (modifier = modifier
//        .fillMaxSize()){
//        Column (
//            horizontalAlignment = Alignment.CenterHorizontally,
//            verticalArrangement = Arrangement.Center,
//            modifier = Modifier
//                .padding(10.dp)
//                .fillMaxSize()
//        ){
//            Text(text = "Given your spending - your daily budget is looking like:",
//                textAlign = TextAlign.Center)
//            Text(text = "\$$_budget",
//                textAlign = TextAlign.Center)
//        }
//    }
//}
//
//@Preview(showBackground = true)
//@Composable
//fun DailyTargetPreview()
//{
//    DailyTarget(35)
//}
//
//@Composable
//fun DailyRemainder(
//    Balance : Int,
//    modifier: Modifier = Modifier)
//{
//    Card (
//        colors = CardDefaults.cardColors(
//            containerColor = MaterialTheme.colorScheme.surfaceVariant,
//        ),
//        modifier = modifier
//
//    ) {
//        Column (
//            horizontalAlignment = Alignment.CenterHorizontally,
//            verticalArrangement = Arrangement.Center,
//            modifier = Modifier
//                .fillMaxWidth()
//                .fillMaxHeight()
//                .padding(10.dp)
//        ){
//            Text(
//                text = "Remaining allowance for the day:",
//            )
//            Text(
//                text = "$Balance"
//            )
//        }
//    }
//}
//
//@Composable
//fun OverallStatus(
//    _value : Int,
//    _overBudget : Boolean,
//    modifier: Modifier = Modifier
//)
//{
//    val compute_string : String =
//        if (_overBudget)
//        {
//            "You are OVER your budget by:"
//        }
//        else
//        {
//            "You are within your budget with this much to spare:"
//        }
//    Card (
//        modifier = modifier
//            .fillMaxSize()
//    ){
//        Column (
//            horizontalAlignment = Alignment.CenterHorizontally,
//            verticalArrangement = Arrangement.Center,
//            modifier = Modifier
//                .padding(10.dp)
//                .fillMaxSize()
//        ){
//            Text(text = "Are you over/under budget?",
//                textAlign = TextAlign.Center)
//            Text(text = "${compute_string}",
//                textAlign = TextAlign.Center)
//            Text(text = "\$${_value}")
//        }
//    }
//}
//
//@Preview(showBackground = true)
//@Composable
//fun TopCardPreview(modifier: Modifier = Modifier)
//{
//    DailyRemainder(
//        100,
//
//    )
//}
//
//@Preview(showBackground = true)
//@Composable
//fun OverallStatusPreview()
//{
//    OverallStatus(
//        75,
//        false
//    )
//}
//
//@Composable
//fun Greeting(name: String, modifier: Modifier = Modifier) {
//    Text(
//        text = "Hello $name!",
//        modifier = modifier
//    )
//}
//
//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    BudgetBuddyTheme {
//        Greeting("Android")
//    }
//}
//
//@Preview(showBackground = true, showSystemUi = true)
//@Composable
//fun MyAppPreview()
//{
//    MyApp()
//}