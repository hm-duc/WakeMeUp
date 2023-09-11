package com.hmd.wakemeup

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.tween
import androidx.compose.foundation.clickable
import androidx.compose.foundation.indication
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.exyte.animatednavbar.AnimatedNavigationBar
import com.exyte.animatednavbar.animation.balltrajectory.Parabolic
import com.exyte.animatednavbar.animation.indendshape.Height
import com.exyte.animatednavbar.animation.indendshape.shapeCornerRadius
import com.exyte.animatednavbar.utils.noRippleClickable
import com.hmd.wakemeup.ui.theme.WakeMeUpTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WakeMeUpTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainScreen()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen() {
    val navigationBarItems = remember { NavigationBarItems.values() }
    var selectedIndex by remember { mutableStateOf(0) }

    Scaffold(
        modifier = Modifier.padding(all = 12.dp),
        bottomBar = {
            AnimatedNavigationBar(
                modifier = Modifier.height(64.dp),
                selectedIndex = selectedIndex,
                cornerRadius = shapeCornerRadius(cornerRadius = 34.dp),
                ballAnimation = Parabolic(tween(300)),
                indentAnimation = Height(tween(300)),
                barColor = MaterialTheme.colorScheme.primary,
                ballColor = MaterialTheme.colorScheme.primary
            ) {
                navigationBarItems.forEach {item ->
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .noRippleClickable { selectedIndex = item.ordinal },
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            modifier = Modifier.size(30.dp),
                            painter  = painterResource(item.icon),
                            contentDescription = "Bottom bar icon",
                            tint = if (selectedIndex == item.ordinal) MaterialTheme.colorScheme.onBackground
                            else MaterialTheme.colorScheme.inversePrimary
                        )
                    }

                }
            }
        }
    ) {
        
    }
}

enum class NavigationBarItems(val icon: Int) {
    Alarm(icon = R.drawable.alarm),
    WorldTime(icon = R.drawable.time),
    Sleep(icon = R.drawable.bed),
    Stopwatch(icon = R.drawable.timer)
}

fun Modifier.noRippleClickable(onClick: () -> Unit): Modifier = composed {
    clickable (
        indication = null,
        interactionSource = remember { MutableInteractionSource() }
    ) {
        onClick()
    }
}
