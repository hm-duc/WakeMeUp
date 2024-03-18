package com.hmd.wakemeup.presentation.navgraph

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Check
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NamedNavArgument

sealed class BottomRoute(
    val route: String,
    val icon: ImageVector,
    val label: String
)  {
     object AlarmScreen: BottomRoute(route = "alarm", icon = Icons.Default.Check, label = "Alarm")
     object SleepScreen: BottomRoute(route = "sleep", icon = Icons.Default.AccountBox, label = "Sleep")
     object StopwatchScreen: BottomRoute(route = "stopwatch", icon = Icons.Default.Build, label = "Stopwatch")
}