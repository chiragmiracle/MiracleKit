package com.miracle.miraclekit.Activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.ScrollableTabRow
import androidx.compose.material.Tab
import androidx.compose.material.TabPosition
import androidx.compose.material.TabRow
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Send
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.debugInspectorInfo
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.miracle.miraclekit.Model.ActionItemMode
import com.miracle.miraclekit.Model.ActionItemSpec
import com.miracle.miraclekit.Model.separateIntoActionAndOverflow
import com.miracle.miraclekit.NormalTextDescription
import com.miracle.miraclekit.R
import com.miracle.miraclekit.SpaceLine
import com.miracle.miraclekit.theme.Clr1
import com.miracle.miraclekit.theme.Clr2
import com.miracle.miraclekit.theme.Clr3
import com.miracle.miraclekit.theme.Clr4
import com.miracle.miraclekit.theme.Clr5
import com.miracle.miraclekit.theme.Clr9
import com.miracle.miraclekit.theme.MiracleTheme

class AppBarTabPage : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MiracleTheme {
                Surface(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(),
                ) {
                    MainListGridPageUI()
                }
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun MainListGridPageUI() {
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
                        .height(55.dp)
                        .width(55.dp)
                        .padding(15.dp)
                        .clipToBounds()
                        .clickable(indication = null,
                            interactionSource = remember { MutableInteractionSource() } // This is mandatory
                        ) {
                            finish()
                        },
                )
                Text(
                    text = "Top AppBar & Tabs",
                    color = Color.Black,
                    fontFamily = FontFamily.SansSerif,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.align(alignment = Alignment.Center)
                )
            }

            Column(
                modifier = Modifier
                    .verticalScroll(rememberScrollState())
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .padding(10.dp)
            ) {
                NormalTextDescription("1.) TopAppbar with IconButtons as Toolbar menus in classic Views.")
                Spacer(modifier = Modifier.height(10.dp))
                ActionTopAppbar()
                SpaceLine()

                NormalTextDescription("2.) TopAppbar with Overflow menu.")
                OverflowTopAppBar()
                OverflowTopAppBar2()
                SpaceLine()

                NormalTextDescription("3.) Fixed tabs only with text. TabRow is our fixed Row with equal size for each tab that contains tabs.")
                Spacer(modifier = Modifier.height(10.dp))
                TextTabComponent()
                SpaceLine()

                NormalTextDescription("4.) Fixed tabs with text and icon.")
                Spacer(modifier = Modifier.height(10.dp))
                CombinedTabComponent()
                SpaceLine()

                NormalTextDescription("5.) Scrollable tabs.")
                Spacer(modifier = Modifier.height(10.dp))
                ScrollableTextTabComponent()
                SpaceLine()

                NormalTextDescription("6.) Custom tabs.")
                Spacer(modifier = Modifier.height(10.dp))
                CustomTabs()
                SpaceLine()

                NormalTextDescription("7.) TopAppBar and Tabs.")
                Spacer(modifier = Modifier.height(10.dp))
                ActionTopAppbar()
                CombinedTabComponent()
                SpaceLine()


            }
        }
    }
}

@Composable
fun CustomTabs() {
    var selectedIndex by remember { mutableStateOf(0) }

    val list = listOf("Home", "Favourite", "Settings")

    TabRow(selectedTabIndex = selectedIndex,
        backgroundColor = Clr9,
        contentColor = Color.White,
        modifier = Modifier
            .clip(RoundedCornerShape(30))
            .background(Clr9)
            .padding(1.dp),
        indicator = { tabPositions: List<TabPosition> ->
            Box {}
        }
    ) {
        list.forEachIndexed { index, text ->
            val selected = selectedIndex == index
            Tab(
                modifier = if (selected) Modifier
                    .clip(RoundedCornerShape(30))
                    .background(Color.White)
                else Modifier
                    .clip(RoundedCornerShape(30))
                    .background(Clr9),
                selected = selected,
                onClick = { selectedIndex = index },
                text = {
                    if (selected)
                        Text(
                            text = text,
                            color = Color.Black,
                            fontWeight = FontWeight.Bold,
                        )
                    else
                        Text(
                            text = text,
                            color = Color.White,
                        )
                }
            )
        }
    }
}

@Composable
fun ScrollableTextTabComponent() {
    var selectedIndex by remember { mutableStateOf(0) }

    val list = listOf("Home", "Map", "Dashboard", "Favorites", "Explore", "Settings")

    ScrollableTabRow(
        edgePadding = 8.dp,
        backgroundColor = Clr5,
        contentColor = Color.White,
        selectedTabIndex = selectedIndex
    ) {
        list.forEachIndexed { index, text ->
            Tab(selected = selectedIndex == index,
                onClick = { selectedIndex = index },
                text = { androidx.compose.material.Text(text = text) }
            )
        }
    }
}

@Composable
fun ActionTopAppbar() {
    TopAppBar(
        title = {
            androidx.compose.material.Text(text = "TopAppBar")
        },
        elevation = 0.dp,
        backgroundColor = Clr4,
        contentColor = Color.White,
        navigationIcon = {
            IconButton(onClick = { }) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = null
                )
            }
        },
        actions = {
            IconButton(onClick = { /* doSomething() */ }) {
                Icon(Icons.Filled.Call, contentDescription = null)
            }

            IconButton(onClick = { /* doSomething() */ }) {
                Icon(Icons.Filled.Refresh, contentDescription = null)
            }

            IconButton(
                onClick = { /* doSomething() */ }) {
                Icon(Icons.Filled.Notifications, contentDescription = null)
            }
        }
    )
}

@Composable
fun OverflowTopAppBar() {
    var showMenu by remember { mutableStateOf(false) }

    TopAppBar(
        title = { androidx.compose.material.Text("Overflow") },
        modifier = Modifier.padding(vertical = 10.dp),
        backgroundColor = Clr1,
        contentColor = Color.White,
        actions = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(Icons.Default.Favorite, contentDescription = null)
            }
            IconButton(onClick = { showMenu = !showMenu }) {
                Icon(Icons.Default.MoreVert, contentDescription = null)
            }
            DropdownMenu(
                expanded = showMenu,
                onDismissRequest = { showMenu = false }
            ) {

                DropdownMenuItem(onClick = { showMenu = !showMenu }) {
                    Icon(Icons.Filled.Refresh, contentDescription = null)
                }

                DropdownMenuItem(onClick = { showMenu = !showMenu }) {
                    Icon(Icons.Filled.Call, contentDescription = null)
                }
            }
        }
    )
}

@Composable
fun OverflowTopAppBar2() {
    val items = listOf(
        ActionItemSpec("Call", Icons.Default.Call, ActionItemMode.ALWAYS_SHOW) {},
        ActionItemSpec("Send", Icons.Default.Send, ActionItemMode.IF_ROOM) {},
        ActionItemSpec("Email", Icons.Default.Email, ActionItemMode.IF_ROOM) {},
        ActionItemSpec("Delete", Icons.Default.Delete, ActionItemMode.IF_ROOM) {},
    )
    TopAppBar(
        title = { androidx.compose.material.Text("Overflow2") },
        backgroundColor = Clr2,
        contentColor = Color.White,
        navigationIcon = {
            IconButton(onClick = {}) {
                Icon(Icons.Default.Menu, "Menu")
            }
        },
        actions = {
            ActionMenu(items, defaultIconSpace = 3)
        }
    )
}

@Composable
fun ActionMenu(
    items: List<ActionItemSpec>,
    defaultIconSpace: Int = 3, // includes overflow menu
    menuExpanded: MutableState<Boolean> = remember { mutableStateOf(false) }
) {
    // decide how many ifRoom icons to show as actions
    val (actionItems, overflowItems) = remember(items, defaultIconSpace) {
        separateIntoActionAndOverflow(items, defaultIconSpace)
    }

    Row {
        for (item in actionItems) {
            IconButton(onClick = item.onClick) {
                Icon(item.icon, item.name)
            }
        }
        if (overflowItems.isNotEmpty()) {
            IconButton(onClick = { menuExpanded.value = true }) {
                Icon(Icons.Default.MoreVert, "More actions")
            }
            DropdownMenu(
                expanded = menuExpanded.value,
                onDismissRequest = { menuExpanded.value = false }
            ) {
                for (item in overflowItems) {
                    DropdownMenuItem(onClick = item.onClick) {
                        //Icon(item.icon, item.name) just have text in the overflow menu
                        Text(item.name)
                    }
                }
            }
        }
    }
}

@Composable
fun TextTabComponent() {
    var selectedIndex by remember { mutableStateOf(0) }

    val list = listOf("Home", "Favorite", "Settings")

    TabRow(selectedTabIndex = selectedIndex,
        backgroundColor = Clr3,
        contentColor = Color.White,
        indicator = { tabPositions: List<TabPosition> ->
            tabPositions.forEachIndexed { index, tabPosition ->
                println(
                    "index: $index, " +
                            "left: ${tabPosition.left}, " +
                            "right: ${tabPosition.right}, " +
                            "width: ${tabPosition.width}"
                )
            }

            Box(
                modifier = Modifier
                    .myTabIndicatorOffset(tabPositions[selectedIndex])
                    .height(4.dp)
                    .background(color = Color.White)
            ) {}
        }) {
        list.forEachIndexed { index, text ->
            Tab(
                selected = selectedIndex == index,
                onClick = { selectedIndex = index },
                text = { androidx.compose.material.Text(text = text, color = Color.White) },
            )
        }
    }
}

fun Modifier.myTabIndicatorOffset(
    currentTabPosition: TabPosition
): Modifier = composed(
    inspectorInfo = debugInspectorInfo {
        name = "tabIndicatorOffset"
        value = currentTabPosition
    }
) {
    val currentTabWidth by animateDpAsState(
        targetValue = currentTabPosition.width,
        animationSpec = tween(durationMillis = 5250, easing = FastOutSlowInEasing),
        label = "tab width"
    )
    val indicatorOffset by animateDpAsState(
        targetValue = currentTabPosition.left,
        animationSpec = tween(durationMillis = 250, easing = FastOutSlowInEasing),
        label = "indicator offset"
    )
    fillMaxWidth()
        .wrapContentSize(Alignment.BottomStart)
        .offset(x = indicatorOffset)
        .width(currentTabWidth)
}

@Composable
fun CombinedTabComponent() {
    var selectedIndex by remember { mutableStateOf(0) }
    val tabContents = listOf(
        "Home" to Icons.Filled.Home,
        "Favorite" to Icons.Filled.Favorite,
        "Settings" to Icons.Filled.Settings
    )

    TabRow(
        selectedTabIndex = selectedIndex,
        backgroundColor = Clr4,
        contentColor = Color.White,
    ) {
        tabContents.forEachIndexed { index, pair: Pair<String, ImageVector> ->
            Tab(selected = selectedIndex == index, onClick = { selectedIndex = index },
                text = { androidx.compose.material.Text(text = pair.first) },
                icon = { Icon(imageVector = pair.second, contentDescription = null) }
            )
        }
    }
}

