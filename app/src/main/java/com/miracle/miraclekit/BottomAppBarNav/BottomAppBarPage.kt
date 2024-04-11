package com.miracle.miraclekit.BottomAppBarNav

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomAppBar
import androidx.compose.material.Card
import androidx.compose.material.ContentAlpha
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.FabPosition
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.ListItem
import androidx.compose.material.LocalContentAlpha
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.miracle.miraclekit.R
import com.miracle.miraclekit.theme.BgColor
import com.miracle.miraclekit.theme.Clr1
import com.miracle.miraclekit.theme.L_Clr1
import com.miracle.miraclekit.theme.MiracleTheme

class BottomAppBarPage : ComponentActivity() {

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MiracleTheme {
                BottomAppBarPageUI()
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun BottomAppBarPageUI() {
        Scaffold(
            modifier = Modifier.background(BgColor),
            floatingActionButton = {
                FloatingActionButton(
                    onClick = {},
                    containerColor = Clr1,
                    elevation = FloatingActionButtonDefaults.bottomAppBarFabElevation(
                        defaultElevation = 7.dp,
                        pressedElevation = 0.dp,
                        hoveredElevation = 7.dp,
                        focusedElevation = 7.dp
                    )
                ) {
                    Icon(
                        Icons.Filled.Add, tint = Color.White,
                        contentDescription = null
                    )
                }
            },
            isFloatingActionButtonDocked = true,
            floatingActionButtonPosition = FabPosition.Center,
            bottomBar = {
                BottomAppBarComponent()
            }
        ) {
            UserListContent(it.calculateBottomPadding())
        }
    }

    @Composable
    fun BottomAppBarComponent() {
        BottomAppBar(
            backgroundColor = L_Clr1,
            contentColor = Color.White,
            elevation = 5.dp,
            cutoutShape = RoundedCornerShape(15.dp),
        ) {
            CompositionLocalProvider(value = LocalContentAlpha provides ContentAlpha.high) {
                Image(
                    Icons.Filled.ArrowBack,
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
            }
            Spacer(modifier = Modifier.weight(1f))
            IconButton(onClick = { }) {
                Image(
                    Icons.Filled.Search,
                    colorFilter = ColorFilter.tint(Color.Black),
                    contentDescription = null
                )
            }

            IconButton(onClick = { }) {
                Image(
                    Icons.Filled.MoreVert,
                    colorFilter = ColorFilter.tint(Color.Black),
                    contentDescription = null
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun UserListContent(calculateBottomPadding: Dp) {
    LazyColumn(
        modifier = Modifier.background(BgColor),
        contentPadding = PaddingValues(
            top = 10.dp,
            start = 10.dp,
            end = 10.dp,
            bottom = calculateBottomPadding + 10.dp
        ),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        items(userList) { item: String ->
            Card(shape = RoundedCornerShape(10.dp), elevation = 2.dp) {
                ListItem(
                    modifier = Modifier.clickable {},
                    icon = {
                        Image(
                            modifier = Modifier
                                .size(40.dp)
                                .clip(CircleShape),
                            painter = painterResource(id = R.drawable.avtar),
                            contentDescription = null
                        )
                    },
                    secondaryText = {
                        Text(text = "Secondary text", color = Color.LightGray)
                    }
                ) {
                    Text(text = item, fontSize = 16.sp, fontWeight = FontWeight.Bold)
                }
            }
        }
    }
}

val userList = listOf(
    "User1",
    "User2",
    "User3",
    "User4",
    "User5",
    "User6",
    "User7",
    "User8",
    "User9",
    "User10",
    "User11",
    "User12",
    "User13",
    "User14",
    "User15",
)