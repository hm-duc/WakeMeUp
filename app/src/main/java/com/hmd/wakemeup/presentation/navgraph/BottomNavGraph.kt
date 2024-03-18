package com.hmd.wakemeup.presentation.navgraph

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.hmd.wakemeup.presentation.alarm.AlarmScreen
import com.hmd.wakemeup.presentation.sleep.SleepScreen
import com.hmd.wakemeup.presentation.stopwatch.StopwatchScreen

@Composable
fun BottomNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = BottomRoute.AlarmScreen.route
    ) {
        composable(route = BottomRoute.AlarmScreen.route) {
            AlarmScreen()
        }
        composable(route = BottomRoute.SleepScreen.route) {
            SleepScreen()
        }
        composable(route = BottomRoute.StopwatchScreen.route) {
            StopwatchScreen()
        }
    }
}