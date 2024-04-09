package com.miracle.miraclekit.Activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.util.fastForEachIndexed
import com.miracle.miraclekit.AppBarTitleText
import com.miracle.miraclekit.NormalTextDescription
import com.miracle.miraclekit.R
import com.miracle.miraclekit.SpaceLine
import com.miracle.miraclekit.theme.Clr1
import com.miracle.miraclekit.theme.Clr2
import com.miracle.miraclekit.theme.Clr3
import com.miracle.miraclekit.theme.MiracleTheme

class BottomNavigationPage : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MiracleTheme {
                Surface(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(),
                ) {
                    BottomNavigationPageUI()
                }
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun BottomNavigationPageUI() {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(55.dp),
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_back),
                    contentDescription = null,
                    colorFilter = ColorFilter.tint(Color.Black),
                    modifier = Modifier
                        .fillMaxHeight()
                        .width(55.dp)
                        .padding(15.dp)
                        .clipToBounds()
                        .clickable(indication = null,
                            interactionSource = remember { MutableInteractionSource() }
                        ) {
                            finish()
                        },
                )
                val Mpadding = Modifier.align(Alignment.CenterStart)
                AppBarTitleText(Mpadding, text = "Bottom Navigation")
            }

            Column(
                modifier = Modifier
                    .verticalScroll(rememberScrollState())
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .padding(10.dp)
            ) {

                NormalTextDescription("1.) BottomNavigation only with Text")
                Spacer(modifier = Modifier.height(10.dp))
                TextBottomNav()
                SpaceLine()

                NormalTextDescription(
                    "2.) BottomNavigation only with Icon and content color on " +
                            "BottomNavigation, and selected and unselected colors with " +
                            "BottomNavigationItem"
                )
                Spacer(modifier = Modifier.height(10.dp))
                IconBottomNav()
                SpaceLine()

                NormalTextDescription("3.) BottomNavigation with Icon and Text")
                Spacer(modifier = Modifier.height(10.dp))
                TextIconBottomNav()
                SpaceLine()

                NormalTextDescription("4.) Material 3 Bottom Navigation")
                Spacer(modifier = Modifier.height(10.dp))
                M3BottomNav()
                SpaceLine()

            }
        }
    }

    @Composable
    fun TextBottomNav() {
        var selectIndex by remember { mutableStateOf(0) }
        val list = listOf("Home", "Favorite", "Settings")

        BottomNavigation(
            elevation = 1.dp,
            backgroundColor = Color.White,
        ) {
            list.fastForEachIndexed { index: Int, text: String ->
                BottomNavigationItem(
                    selected = selectIndex == index,
                    onClick = { selectIndex = index },
                    icon = {},
                    label = { Text(text, fontWeight = FontWeight.Bold, fontSize = 14.sp) },
                    unselectedContentColor = Color.LightGray,
                    selectedContentColor = Clr1,
                )
            }
        }
    }

    @Composable
    fun IconBottomNav() {
        var selectedIndex by remember { mutableStateOf(0) }
        val icons = listOf(Icons.Filled.Home, Icons.Filled.Favorite, Icons.Filled.Settings)

        BottomNavigation(
            elevation = 1.dp,
            backgroundColor = Color.White,
            contentColor = Color.Black,
        ) {
            icons.forEachIndexed { index, imageVector: ImageVector ->
                BottomNavigationItem(
                    unselectedContentColor = Color.LightGray,
                    selectedContentColor = Clr2,
                    icon = { Icon(imageVector, contentDescription = null) },
                    label = null,
                    selected = selectedIndex == index,
                    onClick = {
                        selectedIndex = index
                    }
                )
            }
        }
    }

    @Composable
    fun TextIconBottomNav() {
        var selectedIndex by remember { mutableStateOf(0) }
        val tabContents = listOf(
            "Home" to Icons.Filled.Home,
            "Favorite" to Icons.Filled.Favorite,
            "Settings" to Icons.Filled.Settings
        )

        BottomNavigation(
            backgroundColor = Color.White,
            contentColor = Clr3,
            elevation = 1.dp
        ) {
            tabContents.forEachIndexed { index, pair: Pair<String, ImageVector> ->
                BottomNavigationItem(
                    icon = { Icon(pair.second, contentDescription = null) },
                    label = { Text(pair.first) },
                    selected = selectedIndex == index,
                    alwaysShowLabel = false,
                    onClick = {
                        selectedIndex = index
                    }
                )
            }
        }
    }

    @Composable
    fun M3BottomNav() {
        var selectedItem by remember { mutableIntStateOf(0) }
        val items = listOf("Home", "Favorite", "Settings")
        val icons = listOf(Icons.Filled.Home, Icons.Filled.Favorite, Icons.Filled.Settings)
        NavigationBar(
            containerColor = Clr1,
        ) {
            items.forEachIndexed { index, item ->
                NavigationBarItem(
                    icon = { Icon(icons[index], contentDescription = item) },
                    label = { Text(item) },
                    selected = selectedItem == index,
                    onClick = { selectedItem = index },
                    colors = NavigationBarItemDefaults.colors(
                        unselectedTextColor = Color.Gray,
                        selectedTextColor = Color.White,
                        selectedIconColor = Color.Black,
                        unselectedIconColor = Color.Gray,
                    ),
                )
            }
        }
    }

}