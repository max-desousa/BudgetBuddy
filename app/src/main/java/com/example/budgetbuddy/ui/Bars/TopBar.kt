package com.example.budgetbuddy.ui.MainScreen

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.clearAndSetSemantics
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.budgetbuddy.ui.Navigation.AppDestination
import java.util.Locale


private val TabHeight = 56.dp



@Composable
fun BudgetBuddyTopBar(
    _screensToAdd : List<AppDestination>,
    _onTabSelected: (AppDestination) -> Unit,
    _currentScreen : AppDestination
) {
    Surface (
        Modifier
            .height(TabHeight)
            .fillMaxWidth()
    ) {
        Row(
            Modifier
                .selectableGroup()
        ) {
            _screensToAdd.forEach {
                screen ->
                BudgetBuddyTab(
                    _text = screen.route,
                    _icon = screen.icon,
                    _onSelected = {_onTabSelected(screen)},
                    _isSelected = _currentScreen == screen
                )
            }
        }
    }
}

@Composable
private fun BudgetBuddyTab (
    _text : String,
    _icon : ImageVector,
    _onSelected : () -> Unit,
    _isSelected : Boolean
) {
    Row (
        modifier = Modifier
            .padding(16.dp)
            .animateContentSize()
            .height(TabHeight)
            .selectable(
                selected = _isSelected,
                onClick = _onSelected,
                role = Role.Tab,
                interactionSource = remember {
                    MutableInteractionSource()
                },
                indication = rememberRipple(
                    bounded = false,
                    radius = Dp.Unspecified,
                    color = Color.Unspecified
                ),
            )
            .clearAndSetSemantics { contentDescription = _text }
    ) {
        Icon(
            imageVector = _icon,
            contentDescription = _text,
        )
        if (_isSelected) {
            Spacer(modifier = Modifier.width(12.dp))
            Text(text = _text.uppercase(Locale.getDefault()))
        }
    }
}