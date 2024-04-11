package com.miracle.miraclekit.NavDrawer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ContentAlpha
import androidx.compose.material.DrawerValue
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.ListItem
import androidx.compose.material.LocalContentAlpha
import androidx.compose.material.ModalDrawer
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.miracle.miraclekit.BottomAppBarNav.userList
import com.miracle.miraclekit.R
import com.miracle.miraclekit.theme.BgColor
import com.miracle.miraclekit.theme.Clr2
import com.miracle.miraclekit.theme.L_Clr2
import com.miracle.miraclekit.theme.MiracleTheme
import com.miracle.miraclekit.ui.DrawerButton
import kotlinx.coroutines.launch

class ModelNavDrawerPage : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MiracleTheme {
                ModelNavDrawerPageUI()
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    private fun ModelNavDrawerPageUI(drawerValue: DrawerValue = DrawerValue.Closed) {
        val drawerState = rememberDrawerState(initialValue = drawerValue)
        val coroutineScope = rememberCoroutineScope()
        val openDrawer: () -> Unit = { coroutineScope.launch { drawerState.open() } }
        val closeDrawer: () -> Unit = { coroutineScope.launch { drawerState.close() } }
        var selectedIndex by remember { mutableStateOf(0) }

        ModalDrawer(drawerState = drawerState, drawerContent = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .background(L_Clr2)
            ) {
                ModalDrawerContentHeader()
                ModelDrawerContentBody(
                    selectedIndex, onSelected = {
                        selectedIndex = it
                    }, closeDrawer = closeDrawer
                )
            }
        }, content = {
            Column(modifier = Modifier.fillMaxSize()) {
                ModalDrawerTopAppBar(openDrawer)
                UserModalListContent(openDrawer)
            }
        })
    }

}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun UserModalListContent(openDrawer: () -> Unit) {
    LazyColumn(
        modifier = Modifier.background(BgColor),
        contentPadding = PaddingValues(10.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        items(userList) { item: String ->
            Card(shape = RoundedCornerShape(10.dp), elevation = 2.dp) {
                ListItem(modifier = Modifier.clickable {}, icon = {
                    Image(
                        modifier = Modifier
                            .size(40.dp)
                            .clip(CircleShape),
                        painter = painterResource(id = R.drawable.avtar),
                        contentDescription = null
                    )
                }, secondaryText = {
                    Text(text = "Secondary text", color = Color.LightGray)
                }) {
                    Text(text = item, fontSize = 16.sp, fontWeight = FontWeight.Bold)
                }
            }
        }
    }
}


@Composable
fun ModalDrawerTopAppBar(openDrawer: () -> Unit) {
    TopAppBar(backgroundColor = Color.White, title = {
        Text("Modal Drawer")
    }, navigationIcon = {
        IconButton(onClick = openDrawer) {
            Icon(
                imageVector = Icons.Filled.Menu, contentDescription = null
            )
        }
    }, actions = {})
}

@Preview(showBackground = true)
@Composable
fun ModalDrawerContentHeader() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(180.dp)
            .background(
                color = Clr2,
                shape = RoundedCornerShape(bottomStart = 30.dp, bottomEnd = 30.dp)
            )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(20.dp)
        ) {
            Image(
                modifier = Modifier
                    .size(60.dp)
                    .clip(CircleShape),
                painter = painterResource(id = R.drawable.avtar),
                contentDescription = null
            )

            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = "Smart Tool Factory",
                fontWeight = FontWeight.Bold,
                color = Color.White,
                fontSize = 22.sp
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
                    Text(
                        text = "themiracleitsolutions@gmail.com",
                        color = Color.White,
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    Icon(
                        imageVector = Icons.Filled.ArrowDropDown,
                        contentDescription = null,
                        tint = Color.White
                    )
                }
            }
        }
    }
}

@Composable
fun ModelDrawerContentBody(
    selectedIndex: Int, onSelected: (Int) -> Unit, closeDrawer: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(L_Clr2)
    ) {
        modalDrawerList.forEachIndexed { index, pair ->
            val label = pair.first
            val imageVector = pair.second
            DrawerButton(icon = imageVector,
                label = label,
                isSelected = selectedIndex == index,
                action = {
                    onSelected(index)
                })
        }
    }
}

val modalDrawerList = listOf(
    Pair("Favorite", Icons.Filled.Favorite),
    Pair("Starred", Icons.Filled.Star),
    Pair("Call", Icons.Filled.Call),
    Pair("Email", Icons.Filled.Email),
    Pair("Location", Icons.Filled.LocationOn),
    Pair("Settings", Icons.Filled.Build),
    Pair("Share", Icons.Filled.Share),
)