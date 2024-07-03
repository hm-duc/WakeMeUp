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
    val ordinal: Int
)  {
     object AlarmScreen: BottomRoute(route = "alarm", icon = Icons.Default.Check, ordinal = 0)
     object SleepScreen: BottomRoute(route = "sleep", icon = Icons.Default.AccountBox, ordinal = 1)
     object StopwatchScreen: BottomRoute(route = "stopwatch", icon = Icons.Default.Build, ordinal = 2)
}