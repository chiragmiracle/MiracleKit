package com.miracle.miraclekit.NavDrawer

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.material.Snackbar
import androidx.compose.material.SnackbarHost
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.miracle.miraclekit.R
import com.miracle.miraclekit.Selector.isInPreview
import com.miracle.miraclekit.theme.L_Clr1
import com.miracle.miraclekit.theme.L_Clr10
import com.miracle.miraclekit.theme.MiracleTheme
import com.miracle.miraclekit.ui.DrawerButton
import kotlinx.coroutines.launch

class SideNavPage : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MiracleTheme {
                SideNavPageUI()
            }
        }
    }

    @Composable
    private fun SideNavPageUI(scaffoldState: ScaffoldState = rememberScaffoldState()) {
        var currentRoute by remember { mutableStateOf(Routes.HOME_ROUTE) }
        val navController = rememberNavController()
        val coroutineScope = rememberCoroutineScope()
        val openDrawer: () -> Unit = { coroutineScope.launch { scaffoldState.drawerState.open() } }
        val closeDrawer: () -> Unit =
            { coroutineScope.launch { scaffoldState.drawerState.close() } }
        val context = LocalContext.current
        val isInPreview = isInPreview

        Scaffold(
            scaffoldState = scaffoldState,
            backgroundColor = Color.White,
            drawerContent = {
                AppDrawer(
                    currentRoute = currentRoute,
                    navigateToHome = {
                        currentRoute = Routes.HOME_ROUTE
                        navController.popBackStack()
                        navController.navigate(currentRoute)
                    }, navigateToSettings = {
                        currentRoute = Routes.SETTINGS_ROUTE
                        navController.popBackStack()
                        navController.navigate(currentRoute)
                    }, closeDrawer = closeDrawer
                )
            }, topBar = {
                TopAppBar(
                    backgroundColor = Color.White,
                    title = {
                        Text("Side Navigation", color = Color.Black)
                    }, navigationIcon = {
                        IconButton(onClick = openDrawer) {
                            Icon(
                                imageVector = Icons.Filled.Menu,
                                contentDescription = null,
                                tint = Color.Black,
                            )
                        }
                    }, actions = {
                        IconButton(onClick = {
                            // show snackbar as a suspend function
                            coroutineScope.launch {
                                scaffoldState.snackbarHostState.showSnackbar("Snackbar")
                            }
                        }) {
                            Icon(
                                imageVector = Icons.Filled.Call,
                                contentDescription = null,
                                tint = Color.Black,
                            )
                        }
                    })
            }, snackbarHost = {
                SnackbarHost(hostState = it) { snackbarData ->
                    Snackbar(modifier = Modifier.padding(4.dp), action = {
                        Text(text = "Action", modifier = Modifier
                            .clickable {
                                if (!isInPreview) {
                                    Toast
                                        .makeText(
                                            context, "Action invoked", Toast.LENGTH_SHORT
                                        )
                                        .show()
                                }
                            }
                            .padding(4.dp))
                    }) {
                        Text(snackbarData.message)
                    }
                }
            }) { paddingValues ->
            NavHost(
                navController = navController,
                startDestination = Routes.HOME_ROUTE,
                modifier = Modifier.padding(paddingValues)
            ) {
                composable(Routes.HOME_ROUTE) {
                    HomeComponent()
                }
                composable(Routes.SETTINGS_ROUTE) {
                    SettingsComponent()
                }
            }
        }
    }
}

@Composable
fun AppDrawer(
    currentRoute: String,
    navigateToHome: () -> Unit,
    navigateToSettings: () -> Unit,
    closeDrawer: () -> Unit
) {

    Column(modifier = Modifier.fillMaxSize()) {
        DrawerHeader()
        DrawerButton(
            icon = Icons.Filled.Home,
            label = "Home",
            isSelected = currentRoute == Routes.HOME_ROUTE,
            action = {
                if (currentRoute != Routes.HOME_ROUTE) {
                    navigateToHome()
                }
                closeDrawer()
            }
        )

        DrawerButton(
            icon = Icons.Filled.Settings,
            label = "Settings",
            isSelected = currentRoute == Routes.SETTINGS_ROUTE,
            action = {
                if (currentRoute != Routes.SETTINGS_ROUTE) {
                    navigateToSettings()
                }
                closeDrawer()
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun AppDrawerPreview() {
    MiracleTheme {
        AppDrawer(
            currentRoute = Routes.HOME_ROUTE,
            navigateToHome = {},
            navigateToSettings = {},
            closeDrawer = {}
        )
    }
}

@Composable
private fun DrawerHeader() {
    Box(
        contentAlignment = Alignment.BottomStart,
        modifier = Modifier
            .background(Color.White)
            .shadow(
                elevation = 8.dp,
                shape = RoundedCornerShape(bottomEnd = 30.dp, bottomStart = 30.dp)
            )
    ) {
        Image(
            contentScale = ContentScale.Crop,
            modifier = Modifier.height(160.dp),
            painter = painterResource(id = R.drawable.drawer_bg2),
            contentDescription = null
        )

        Column(
            modifier = Modifier
                .padding(horizontal = 15.dp, vertical = 10.dp)
        ) {
            Spacer(modifier = Modifier.height(8.dp))
            Image(
                modifier = Modifier
                    .size(70.dp)
                    .clip(CircleShape),
                painter = painterResource(id = R.drawable.avtar),
                contentDescription = null
            )

            Spacer(modifier = Modifier.height(4.dp))
            Text(text = "Smart Tool Factory", color = Color.White)
            Text(text = "themiracleitsolutions@gmail.com", color = Color.White)
        }
    }
}

@Preview
@Composable
private fun DrawerHeaderPreview() {
    MiracleTheme {
        DrawerHeader()
    }
}


@Preview
@Composable
private fun DrawerButtonPreview() {
    MiracleTheme {
        DrawerButton(
            icon = Icons.Filled.Home,
            label = "Home",
            isSelected = true,
            action = {
            }
        )
    }
}

@Composable
fun HomeComponent() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(L_Clr1)
    ) {
        Text(color = Color.Black, text = "Home", fontSize = 50.sp, fontWeight = FontWeight.Bold)
    }
}

@Preview
@Composable
private fun HomeComponentPreview() {
    MiracleTheme {
        HomeComponent()
    }
}

@Composable
fun SettingsComponent() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(L_Clr10)
    ) {
        Text(color = Color.Black, text = "Settings", fontSize = 50.sp, fontWeight = FontWeight.Bold)
    }
}

@Preview
@Composable
private fun SettingsComponentPreview() {
    MiracleTheme {
        SettingsComponent()
    }
}

object Routes {
    const val HOME_ROUTE = "Home"
    const val SETTINGS_ROUTE = "Settings"
}