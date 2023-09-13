package com.hmd.wakemeup.presentation.graphs

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.hmd.wakemeup.R
import com.hmd.wakemeup.presentation.alarm_screen.AlarmScreen
import com.hmd.wakemeup.presentation.sleep_screen.SleepScreen
import com.hmd.wakemeup.presentation.watchstop_screen.WatchStopScreen
import com.hmd.wakemeup.presentation.worldtime_screen.WorldTimeScreen

@Composable
fun MainNavigationGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = NavigationBarItems.Alarm.route) {
        composable(NavigationBarItems.Alarm.route) {
            AlarmScreen()
        }
        composable(NavigationBarItems.Sleep.route) {
            SleepScreen()
        }
        composable(NavigationBarItems.WorldTime.route) {
            WorldTimeScreen()
        }
        composable(NavigationBarItems.Stopwatch.route) {
            WatchStopScreen()
        }
    }
}

enum class NavigationBarItems(val icon: Int, val route: String) {
    Alarm(icon = R.drawable.alarm, "Alarm"),
    WorldTime(icon = R.drawable.time, "Sleep"),
    Sleep(icon = R.drawable.bed, "WorldTime"),
    Stopwatch(icon = R.drawable.timer, "Stopwatch")
}
