package com.hmd.wakemeup.presentation.main

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.hmd.wakemeup.presentation.navgraph.BottomNavGraph
import com.hmd.wakemeup.presentation.navgraph.BottomRoute

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen() {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = {
            BottomBar(navController = navController)
        }
    ) {
        BottomNavGraph(navController = navController)
    }
}

@Composable
fun BottomBar(navController: NavHostController) {
    val screens = listOf(
        BottomRoute.AlarmScreen,
        BottomRoute.SleepScreen,
        BottomRoute.StopwatchScreen
    )

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    BottomNavigation {
        screens.forEach { screen ->
            AddItem(screen = screen, currentDestination = currentDestination, navController = navController)
        }
    }
}

@Composable
fun RowScope.AddItem(
    screen: BottomRoute,
    currentDestination: NavDestination?,
    navController: NavHostController
) {
    currentDestination?.hierarchy?.any {
        it.route == screen.route
    }?.let {
        BottomNavigationItem(
        label = {
            Text(text = screen.label)
        },
        icon = {
            Icon(imageVector = screen.icon, contentDescription = "")
        },
        selected = it,
        onClick = {
            navController.navigate(screen.route)
        }
    )
    }
}