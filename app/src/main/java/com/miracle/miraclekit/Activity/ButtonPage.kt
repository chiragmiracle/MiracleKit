package com.miracle.miraclekit.Activity

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Chip
import androidx.compose.material.ChipDefaults
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ExtendedFloatingActionButton
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconToggleButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.miracle.miraclekit.AppBarTitleText
import com.miracle.miraclekit.R
import com.miracle.miraclekit.SmallTextDescription
import com.miracle.miraclekit.SpaceLine
import com.miracle.miraclekit.TitleText
import com.miracle.miraclekit.theme.Clr1
import com.miracle.miraclekit.theme.Clr10
import com.miracle.miraclekit.theme.Clr2
import com.miracle.miraclekit.theme.Clr3
import com.miracle.miraclekit.theme.Clr4
import com.miracle.miraclekit.theme.Clr5
import com.miracle.miraclekit.theme.Clr6
import com.miracle.miraclekit.theme.Clr7
import com.miracle.miraclekit.theme.Clr8
import com.miracle.miraclekit.theme.Clr9
import com.miracle.miraclekit.theme.MiracleTheme
import com.miracle.miraclekit.ui.IndicatingIconButton

class ButtonPage : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MiracleTheme {
                Surface(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(),
                ) {
                    ButtonPageUI()
                }
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun ButtonPageUI() {
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

                val Mpadding = Modifier.align(Alignment.CenterStart)
                AppBarTitleText(Mpadding, text = "Button")
            }

            Column(
                modifier = Modifier
                    .verticalScroll(rememberScrollState())
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .padding(10.dp)
            ) {
                val Mpadding = Modifier.padding(5.dp)
                TitleText("Button :")
                SimpleButton(Mpadding)
                DisabledButton(Mpadding)
                ButtonIcon(Mpadding)
                ButtonBackground(Mpadding)
                GradientButton(Mpadding)
                SpaceLine()

                TitleText("Icon Button :")
                IconButtonDemo(Mpadding)
                SpaceLine()

                TitleText("Custom Ripple Icon Button :")
                RippleIconButtonDemo(Mpadding)
                SpaceLine()

                TitleText("Floating Action Button :")
                FloatingActionButtonDemo(Mpadding)
                SpaceLine()

                TitleText("Chip Button :")
                ChipDemo()
                SpaceLine()

                TitleText("Custome Chip Button :")
                CustomeChipDemo()
                SpaceLine()
            }
        }
    }
}


@Composable
private fun SimpleButton(modifier: Modifier) {
    SmallTextDescription("1.) Simple Button   2.) Text Button   3.) Outline Button")
    Row {
        Button(onClick = {}, modifier = modifier) {
            Text(text = "Button")
        }

        TextButton(onClick = {}, modifier = modifier) {
            Text(text = "Text Button")
        }

        OutlinedButton(
            onClick = {},
            modifier = modifier,
        ) {
            Text(text = "Outlined")
        }
    }
    SmallTextDescription(
        "1.) Rounded Corner Shape Button\n" + "2.) Rounded Corner -Top Start- Shape Button\n" + "3.) Cut Corner Shape Button"
    )

    Row {
        Button(
            onClick = {}, modifier = modifier, shape = RoundedCornerShape(15.dp)
        ) {
            Text(text = "Rounded")
        }

        Button(
            onClick = {}, modifier = modifier, shape = RoundedCornerShape(
                topStartPercent = 30,
                topEndPercent = 0,
                bottomStartPercent = 0,
                bottomEndPercent = 0
            )
        ) {
            Text(text = "Rounded")
        }

        Button(
            onClick = { }, modifier = modifier, shape = CutCornerShape(20)
        ) {
            Text(text = "CutCorner")
        }
    }
}

@Composable
private fun DisabledButton(modifier: Modifier) {
    SmallTextDescription("1.) Simple Disabled Button   2.) Text Disabled Button   3.) Outline Disabled Button")

    Row {
        Button(
            onClick = {}, modifier = modifier, enabled = false
        ) {
            Text(text = "Button")
        }

        TextButton(
            onClick = {}, modifier = modifier, enabled = false
        ) {
            Text(text = "TextButton")
        }

        OutlinedButton(
            onClick = {}, modifier = modifier, enabled = false
        ) {
            Text(text = "Outlined")
        }
    }
}

@Composable
private fun ButtonIcon(modifier: Modifier) {
    SmallTextDescription(
        "1.) Icon + Text Button\n" + "2.) text + Icon Button\n" + "3.) Icon Button\n" + "4.) Icon + Text + Icon Button"
    )
    Row {
        Button(
            onClick = {}, modifier = modifier
        ) {
            Row {
                Icon(
                    imageVector = Icons.Default.FavoriteBorder,
                    modifier = Modifier.padding(end = 4.dp),
                    contentDescription = null
                )
                Text(text = "Icon+Text")
            }
        }

        Button(
            onClick = {}, modifier = modifier
        ) {
            Text(text = "Text+Icon")
            Icon(
                imageVector = Icons.Default.FavoriteBorder,
                modifier = Modifier.padding(start = 4.dp),
                contentDescription = null
            )
        }

        Button(
            onClick = {}, shape = RoundedCornerShape(20), modifier = modifier
        ) {
            Icon(
                imageVector = Icons.Default.FavoriteBorder, contentDescription = null
            )
        }
    }

    Row {
        OutlinedButton(
            onClick = {}, modifier = Modifier.padding(8.dp)
        ) {
            Icon(
                imageVector = Icons.Default.Call,
                modifier = Modifier.padding(start = 5.dp, end = 5.dp),
                contentDescription = null
            )
            Text(text = "Icon + Text + Icon")
            Icon(
                imageVector = Icons.Default.FavoriteBorder,
                modifier = Modifier.padding(start = 4.dp),
                contentDescription = null
            )
        }
    }
}

@Composable
fun ButtonBackground(modifier: Modifier) {
    SmallTextDescription(
        "1.) Button Background Change\n" + "2.) Text Button Background Change\n" + "3.) Outline Border & Text Color Change"
    )
    Row {
        Button(
            onClick = {},
            modifier = modifier,
            colors = ButtonDefaults.buttonColors(
                containerColor = Clr1, contentColor = Color.White
            ),
        ) {
            Text(text = "Button")
        }

        TextButton(
            onClick = {},
            modifier = modifier,
            colors = ButtonDefaults.textButtonColors(
                contentColor = Clr2
            ),
        ) {
            Text(text = "Text Button")
        }

        OutlinedButton(
            onClick = {},
            modifier = modifier,
            border = BorderStroke(1.dp, Clr3),
            shape = RoundedCornerShape(50), // = 50% percent
            colors = ButtonDefaults.outlinedButtonColors(contentColor = Clr3),
        ) {
            Text(text = "Outlined")
        }
    }
}

@Composable
fun GradientButton(modifier: Modifier) {
    SmallTextDescription(
        "1.) Button set Background Horizontal Gradient \n" + "2.) Vertical Gradient\n" + "3.) Sweep Gradient\n" + "4.) Radial Gradient"
    )
    Column {
        Row(
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.Start,
        ) {
            Column(
                modifier = modifier
                    .clip(RoundedCornerShape(20.dp))
                    .background(
                        brush = Brush.horizontalGradient(
                            colors = listOf(
                                Clr1, Clr2, Clr3, Clr4, Clr5, Clr6, Clr7, Clr8, Clr9, Clr10
                            )
                        )
                    )
                    .clickable(onClick = { })
                    .padding(horizontal = 15.dp, vertical = 7.dp)
            ) {
                Text(text = "Horizontal Gradient", color = Color.Black)
            }
            Column(
                modifier = modifier
                    .clip(RoundedCornerShape(20.dp))
                    .background(
                        brush = Brush.sweepGradient(
                            colors = listOf(
                                Clr1, Clr2, Clr3, Clr4, Clr5, Clr6, Clr7, Clr8, Clr9, Clr10
                            )
                        )
                    )
                    .clickable(onClick = { })
                    .padding(horizontal = 15.dp, vertical = 7.dp)
            ) {
                Text(text = "Sweep Gradient", color = Color.Black)
            }
        }
        Row(
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.Start,
        ) {
            Column(
                modifier = modifier
                    .clip(RoundedCornerShape(20.dp))
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                Clr1, Clr2, Clr3, Clr4, Clr5, Clr6, Clr7, Clr8, Clr9, Clr10
                            )
                        )
                    )
                    .clickable(onClick = { })
                    .padding(horizontal = 15.dp, vertical = 7.dp)
            ) {
                Text(text = "Vertical Gradient", color = Color.Black)
            }

            Column(
                modifier = modifier
                    .clip(RoundedCornerShape(20.dp))
                    .background(
                        brush = Brush.radialGradient(
                            colors = listOf(
                                Clr1, Clr2, Clr3, Clr4, Clr5, Clr6, Clr7, Clr8, Clr9, Clr10
                            )
                        )
                    )
                    .clickable(onClick = { })
                    .padding(horizontal = 15.dp, vertical = 7.dp)
            ) {
                Text(text = "Radial Gradient", color = Color.Black)
            }
        }
    }
}

@Composable
fun IconButtonDemo(modifier: Modifier) {
    Row(
        verticalAlignment = Alignment.Top,
        horizontalArrangement = Arrangement.Start,
    ) {
        IconButton(onClick = {}, modifier = modifier) {
            Icon(Icons.Filled.Favorite, contentDescription = null, tint = Color.Black)
        }

        var checked by remember { mutableStateOf(false) }

        IconToggleButton(
            checked = checked, onCheckedChange = { checked = it }, modifier = modifier
        ) {
            val tint by animateColorAsState(
                targetValue = if (checked) Color.LightGray else Color.Red,
                animationSpec = tween(durationMillis = 400)
            )
            Icon(Icons.Filled.Favorite, tint = tint, contentDescription = null)
        }

    }
}

@Composable
fun RippleIconButtonDemo(modifier: Modifier) {
    Row(
        modifier.padding(horizontal = 30.dp),
        verticalAlignment = Alignment.Top,
        horizontalArrangement = Arrangement.Start,
    ) {
        IndicatingIconButton(
            onClick = {}, indication = rememberRipple(
                bounded = false, radius = 40.dp, color = Color.Black
            )
        ) {
            Icon(
                Icons.Filled.Favorite,
                contentDescription = null,
                tint = Color.Black,
                modifier = Modifier.size(35.dp)
            )
        }

        Spacer(modifier = Modifier.width(40.dp))

        var checked by remember { mutableStateOf(true) }

        IndicatingIconButton(
            onClick = {
                checked = !checked
            }, indication = rememberRipple(
                bounded = false, radius = 50.dp, color = Clr2
            )
        ) {
            val tint by animateColorAsState(
                targetValue = if (checked) Color.LightGray else Color.Red,
                animationSpec = tween(durationMillis = 400)
            )
            Icon(
                Icons.Filled.Favorite,
                contentDescription = null,
                tint = tint,
                modifier = Modifier.size(35.dp)
            )
        }
    }
}

@Composable
fun FloatingActionButtonDemo(modifier: Modifier) {
    Row(
        verticalAlignment = Alignment.Top,
        horizontalArrangement = Arrangement.Start,
    ) {
        FloatingActionButton(onClick = { /*TODO*/ }, modifier = modifier) {
            Icon(
                Icons.Filled.Favorite,
                contentDescription = null
            )
        }

        FloatingActionButton(
            onClick = { /*TODO*/ },
            modifier = modifier,
            backgroundColor = Clr1
        ) {
            Icon(
                Icons.Filled.Done,
                tint = Color.White,
                contentDescription = null
            )
        }

        ExtendedFloatingActionButton(
            text = { androidx.compose.material.Text("Extended") },
            onClick = {},
            modifier = modifier
        )

        ExtendedFloatingActionButton(
            icon = {
                Icon(
                    imageVector = Icons.Filled.Favorite,
                    tint = Color.White,
                    contentDescription = null
                )
            },
            text = { Text("Like", color = Color.White) },
            onClick = {},
            backgroundColor = Clr2,
            modifier = modifier
        )

    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ChipDemo() {
    val context = LocalContext.current
    Row(
        modifier = Modifier.fillMaxWidth()
    ) {
        Chip(onClick = {
            Toast.makeText(context, "Click, Simple Chip Button", Toast.LENGTH_SHORT).show()
        }) {
            Text("Chip", color = Color.Black)
        }

        Spacer(modifier = Modifier.width(10.dp))

        Chip(
            enabled = false,
            onClick = {}
        ) {
            Text("Disabled Chip", color = Color.Black)
        }

        Spacer(modifier = Modifier.width(10.dp))

        Chip(
            border = BorderStroke(1.dp, Color.Black),
            colors = ChipDefaults.chipColors(
                backgroundColor = Clr10,
                contentColor = Color.Black
            ),
            onClick = {}
        ) {
            Text("Colored Chip")
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun CustomeChipDemo() {
    val context = LocalContext.current
    Row(
        modifier = Modifier.fillMaxWidth()
    ) {
        Chip(
            shape = RoundedCornerShape(50),
            onClick = { Toast.makeText(context, "I'm clicked", Toast.LENGTH_SHORT).show() },
            leadingIcon = {
                Image(
                    painter = painterResource(id = R.drawable.test1),
                    contentScale = ContentScale.Crop,
                    contentDescription = null,
                    modifier = Modifier
                        .padding(vertical = 5.dp)
                        .size(30.dp)
                        .clip(CircleShape),
                )
            }
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                androidx.compose.material.Text("Chip")
                Spacer(modifier = Modifier.width(ButtonDefaults.IconSpacing))
                Icon(
                    imageVector = Icons.Filled.Close,
                    tint = Color.White,
                    contentDescription = null,
                    modifier = Modifier
                        .clip(CircleShape)
                        .clickable {
                            Toast
                                .makeText(context, "I'm clicked", Toast.LENGTH_SHORT)
                                .show()
                        }
                        .background(Color.Black.copy(0.6F))
                        .size(20.dp)
                        .padding(5.dp)
                )
            }
        }

        Spacer(modifier = Modifier.width(10.dp))

        Chip(
            shape = RoundedCornerShape(50),
            onClick = { Toast.makeText(context, "I'm clicked", Toast.LENGTH_SHORT).show() },
            border = BorderStroke(1.dp, Color.Black.copy(alpha = .9f)),
            colors = ChipDefaults.chipColors(
                backgroundColor = Clr4,
                contentColor = Color.White
            ),
            leadingIcon = {
                Image(
                    painter = painterResource(id = R.drawable.test1),
                    contentScale = ContentScale.Crop,
                    contentDescription = null,
                    modifier = Modifier
                        .padding(vertical = 5.dp)
                        .size(30.dp)
                        .clip(CircleShape),
                )
            }
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                androidx.compose.material.Text("Chip")
                Spacer(modifier = Modifier.width(ButtonDefaults.IconSpacing))
                Icon(
                    imageVector = Icons.Filled.Close,
                    tint = Color.White,
                    contentDescription = null,
                    modifier = Modifier
                        .clip(CircleShape)
                        .clickable {
                            Toast
                                .makeText(context, "I'm clicked", Toast.LENGTH_SHORT)
                                .show()
                        }
                        .background(Color.Black.copy(0.6F))
                        .size(20.dp)
                        .padding(5.dp)
                )
            }
        }
    }
}