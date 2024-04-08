package com.miracle.miraclekit.ListGrid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.selection.toggleable
import androidx.compose.material.Checkbox
import androidx.compose.material.Divider
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.IconToggleButton
import androidx.compose.material.ListItem
import androidx.compose.material.Switch
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.miracle.miraclekit.NormalTextDescription
import com.miracle.miraclekit.R
import com.miracle.miraclekit.TitleText
import com.miracle.miraclekit.theme.MiracleTheme

class VerticalListItemsPage : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MiracleTheme {
                Surface(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(),
                ) {
                    VerticalListItemsPageUI()
                }
            }
        }
    }

    @OptIn(ExperimentalMaterialApi::class)
    @Preview(showBackground = true)
    @Composable
    fun VerticalListItemsPageUI() {
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
                    text = "Vertical List Items",
                    color = Color.Black,
                    fontFamily = FontFamily.SansSerif,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.align(alignment = Alignment.Center)
                )
            }

            LazyColumn(
                contentPadding = PaddingValues(8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {

                item {
                    TitleText(text = "One Line : ")
                    OneLineListItemExample()
                }

                item {
                    TitleText(text = "Two Line : ")
                    TwoLineListItemExample()

                }

                item {
                    TitleText(text = "Three Line : ")
                    ThreeLineListItemExample()

                }

                item {
                    TitleText(text = "Combined : ")
                    CombinedListItemExample()
                }

            }

        }
    }
}

@ExperimentalMaterialApi
@Composable
private fun OneLineListItemExample() {
    Column {
        ListItem(text = { androidx.compose.material.Text("One line list item with no icon") })
        Divider()
        ListItem(
            text = { androidx.compose.material.Text("One line list item with 24x24 icon") },
            icon = {
                FavBtn(modifier = Modifier.size(24.dp))
            }
        )
        Divider()
        ListItem(
            text = { androidx.compose.material.Text("One line list item with 40x40 icon") },
            icon = {
                FavBtn(modifier = Modifier.size(40.dp))
            }
        )
        Divider()
        ListItem(
            text = { androidx.compose.material.Text("One line list item with 56x56 icon") },
            icon = {
                FavBtn(modifier = Modifier.size(56.dp))
            }
        )
        Divider()
        ListItem(
            text = { androidx.compose.material.Text("One line clickable list item") },
            icon = {
                FavBtn(modifier = Modifier.size(56.dp))
            },
            modifier = Modifier.clickable { }
        )
        Divider()
        ListItem(
            text = { androidx.compose.material.Text("One line list item with trailing icon") },
            trailing = {
                FavBtn(modifier = Modifier.size(24.dp))
            }
        )
        Divider()
        ListItem(
            text = { androidx.compose.material.Text("One line list item") },
            icon = {
                FavBtn(modifier = Modifier.size(40.dp))
            },
            trailing = {
                FavBtn(modifier = Modifier.size(24.dp))
            }
        )
        Divider()
    }
}

@ExperimentalMaterialApi
@Composable
private fun TwoLineListItemExample() {
    Column {
        ListItem(
            text = { androidx.compose.material.Text("Two line list item") },
            secondaryText = { androidx.compose.material.Text("Secondary text") }
        )
        Divider()
        ListItem(
            text = { androidx.compose.material.Text("Two line list item") },
            overlineText = { androidx.compose.material.Text("OVERLINE") }
        )
        Divider()
        ListItem(
            text = { androidx.compose.material.Text("Two line list item with 24x24 icon") },
            secondaryText = { androidx.compose.material.Text("Secondary text") },
            icon = {
                FavBtn(modifier = Modifier.size(24.dp))
            }
        )
        Divider()
        ListItem(
            text = { androidx.compose.material.Text("Two line list item with 40x40 icon") },
            secondaryText = { androidx.compose.material.Text("Secondary text") },
            icon = {
                FavBtn(modifier = Modifier.size(40.dp))
            }
        )
        Divider()
        ListItem(
            text = { androidx.compose.material.Text("Two line list item with 40x40 icon") },
            secondaryText = { androidx.compose.material.Text("Secondary text") },
            trailing = { androidx.compose.material.Text("meta") },
            icon = {
                FavBtn(modifier = Modifier.size(40.dp))
            }
        )
        Divider()
    }
}

@ExperimentalMaterialApi
@Composable
private fun ThreeLineListItemExample() {
    Column {
        ListItem(
            text = { androidx.compose.material.Text("Three line list item") },
            secondaryText = {
                androidx.compose.material.Text(
                    "This is a long secondary text for the current list item, " +
                            "displayed on two lines"
                )
            },
            singleLineSecondaryText = false,
            trailing = { androidx.compose.material.Text("meta") }
        )
        Divider()
        ListItem(
            text = { androidx.compose.material.Text("Three line list item") },
            overlineText = { androidx.compose.material.Text("OVERLINE") },
            secondaryText = { androidx.compose.material.Text("Secondary text") }
        )
        Divider()
        ListItem(
            text = { androidx.compose.material.Text("Three line list item with 24x24 icon") },
            secondaryText = {
                androidx.compose.material.Text(
                    "This is a long secondary text for the current list item " +
                            "displayed on two lines"
                )
            },
            singleLineSecondaryText = false,
            icon = {
                FavBtn(modifier = Modifier.size(24.dp))
            }
        )
        Divider()
        ListItem(
            text = { androidx.compose.material.Text("Three line list item with trailing icon") },
            secondaryText = {
                androidx.compose.material.Text(
                    "This is a long secondary text for the current list" +
                            " item, displayed on two lines"
                )
            },
            singleLineSecondaryText = false,
            trailing = {
                FavBtn(modifier = Modifier.size(24.dp))
            }
        )
        Divider()
        ListItem(
            text = { androidx.compose.material.Text("Three line list item") },
            overlineText = { androidx.compose.material.Text("OVERLINE") },
            secondaryText = { androidx.compose.material.Text("Secondary text") },
            trailing = { androidx.compose.material.Text("meta") }
        )
        Divider()
    }
}

@ExperimentalMaterialApi
@Composable
private fun CombinedListItemExample() {
    Column {
        var switched by remember { mutableStateOf(false) }
        val onSwitchedChange: (Boolean) -> Unit = { switched = it }
        ListItem(
            text = { androidx.compose.material.Text("Switch ListItem") },
            trailing = {
                Switch(
                    checked = switched,
                    onCheckedChange = null // null recommended for accessibility with screenreaders
                )
            },
            modifier = Modifier.toggleable(
                value = switched,
                onValueChange = onSwitchedChange
            )
        )
        Divider()
        var checked by remember { mutableStateOf(true) }
        val onCheckedChange: (Boolean) -> Unit = { checked = it }
        ListItem(
            text = { androidx.compose.material.Text("Checkbox ListItem") },
            trailing = {
                Checkbox(
                    checked = checked,
                    onCheckedChange = null // null recommended for accessibility with screenreaders
                )
            },
            modifier = Modifier.toggleable(
                value = checked,
                onValueChange = onCheckedChange
            )
        )
        Divider()
    }
}

@Composable
fun FavBtn(modifier: Modifier) {
    var checked by remember { mutableStateOf(true) }
    IconToggleButton(
        checked = checked,
        onCheckedChange = { checked = it },
    ) {
        val tint by animateColorAsState(
            targetValue = if (checked) Color.Gray else Color.Red,
            animationSpec = tween(durationMillis = 400)
        )
        androidx.compose.material3.Icon(
            Icons.Filled.Favorite,
            tint = tint,
            modifier = modifier,
            contentDescription = null
        )

    }
}
