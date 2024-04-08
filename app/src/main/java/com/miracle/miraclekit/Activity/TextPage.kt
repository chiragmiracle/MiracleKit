package com.miracle.miraclekit.Activity

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.miracle.miraclekit.R
import com.miracle.miraclekit.SpaceLine
import com.miracle.miraclekit.theme.MiracleTheme
import com.miracle.miraclekit.theme.Theme_Clr

class TextPage : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MiracleTheme {
                Surface(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(),
                ) {
                    TextPageUI()
                }
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun TextPageUI() {
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
                        .clickable(
                            indication = null,
                            interactionSource = remember { MutableInteractionSource() } // This is mandatory
                        ) {
                            finish()
                        },
                )
                Text(
                    text = "Text",
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
                Spacer(modifier = Modifier.height(10.dp))
                SimpleText()
                SpaceLine()
                StringResourceText()
                SpaceLine()
                ColorText()
                SpaceLine()
                SizeText()
                SpaceLine()
                CustomFontFamilyText()
                SpaceLine()
                FontStyleText()
                SpaceLine()
                customStylingText()
                SpaceLine()
                showTextShadow()
                SpaceLine()
                setTextModifiers()
                SpaceLine()
                TextWithShape()
                SpaceLine()
                setTextWithLine()
                SpaceLine()
                ClickText()
            }
        }
    }


    @Composable
    fun SimpleText() {
        Text(
            "Simple Text",
            color = Color.Black
        )
    }

    @Composable
    fun StringResourceText() {
        Text(
            stringResource(R.string.StringResourceText),
            color = Color.Black
        )
    }

    @Composable
    fun ColorText() {
        Text(
            "Coloring Text  -->  ",
            style = MaterialTheme.typography.titleMedium,
            color = Color.Black
        )
        Spacer(modifier = Modifier.height(8.dp))
        Row {
            Text("Red    ", color = Color.Red)
            Text("Yellow    ", color = Color.Yellow)
            Text("Green    ", color = Color.Green)
            Text("Custome Color    ", color = Theme_Clr)
        }
    }

    @Composable
    fun SizeText() {
        Text(
            "Size Text  -->  ",
            style = MaterialTheme.typography.titleMedium,
            color = Color.Black
        )
        Spacer(modifier = Modifier.height(8.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("12    ", color = Color.Gray, fontSize = 12.sp)
            Text("16    ", color = Color.Gray, fontSize = 16.sp)
            Text("20    ", color = Color.Gray, fontSize = 20.sp)
            Text("24    ", color = Color.Gray, fontSize = 24.sp)
            Text("28    ", color = Color.Gray, fontSize = 28.sp)
            Text("32    ", color = Color.Gray, fontSize = 32.sp)
        }
    }

    @Composable
    fun FontStyleText() {
        Text(
            "Font Style & Weight -->  ",
            style = MaterialTheme.typography.titleMedium,
            color = Color.Black
        )
        Spacer(modifier = Modifier.height(8.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("Normal    ", color = Color.Gray, fontSize = 14.sp, fontStyle = FontStyle.Normal)
            Text("Bold    ", color = Color.Gray, fontSize = 14.sp, fontWeight = FontWeight.Bold)
            Text("Italic    ", color = Color.Gray, fontSize = 14.sp, fontStyle = FontStyle.Italic)
            Text(
                "Line Through",
                color = Color.Gray,
                fontSize = 14.sp,
                style = TextStyle(textDecoration = TextDecoration.LineThrough)
            )
            Spacer(modifier = Modifier.width(10.dp))
            Text(
                "UnderLine",
                color = Color.Gray,
                fontSize = 14.sp,
                style = TextStyle(textDecoration = TextDecoration.Underline)
            )
        }
    }

    @Composable
    fun CustomFontFamilyText() {
        Text(
            "Font Family -->  ",
            style = MaterialTheme.typography.titleMedium,
            color = Color.Black
        )
        Spacer(modifier = Modifier.height(8.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                "Default Cursive FontFamily",
                color = Color.Black,
                fontSize = 16.sp,
                fontFamily = FontFamily.Cursive
            )
            Spacer(modifier = Modifier.width(15.dp))
            Text(
                "Custom FontFamily",
                color = Color.Black,
                fontSize = 16.sp,
                fontFamily = FontFamily(Font(R.font.exotc_bold))
            )
        }
    }

    @Composable
    fun customStylingText() {
        val myHeaderStyle = TextStyle(
            color = Color.Red,
            fontSize = 16.sp,
            fontWeight = FontWeight.SemiBold,
            fontFamily = FontFamily.Monospace,
            fontStyle = FontStyle.Normal,
            letterSpacing = 0.25.sp
        )
        Text(
            text = "Custom Styling Text",
            style = myHeaderStyle,
            modifier = Modifier
                .background(color = Color.Yellow)
                .padding(horizontal = 15.dp, vertical = 5.dp)
        )
    }

    @Composable
    fun showTextShadow() {
        Text(
            text = "Show Text Shadow", color = Color.Red, style = TextStyle(
                fontSize = 24.sp, shadow = Shadow(
                    color = Color.Blue, offset = Offset(5.0f, 10f), blurRadius = 5f
                )
            )
        )
    }

    @Composable
    fun setTextModifiers() {
        val GradientColors = listOf(Color.Cyan, Color.Blue, Color.Red, Color.Yellow)
        Text(
            text = "Text Modifiers With Gradient Background",
            color = Color.Red,
            modifier = Modifier
                .background(
                    Brush.linearGradient(
                        colors = GradientColors
                    )
                )
                .padding(10.dp)
                .clip(RoundedCornerShape((7.dp)))
                .background(Color.DarkGray)
                .padding(10.dp),
        )

    }

    @Composable
    fun setTextWithLine() {
        Text(
            text = " Jetpack Compose — Text composable. Text composable is used to show the text on the screen.".repeat(
                10
            ),
            color = Color.Black,
            maxLines = 3,
            overflow = TextOverflow.Ellipsis,
//            softWrap = false //set Text With Over Flow And Softwrap
        )
    }

    @Composable
    fun TextWithShape() {
        Text(
            text = "Text with round border",
            color = Color.Black,
            modifier = Modifier
                .padding(Dp(10f))
                .border(2.dp, SolidColor(Color.Black), RoundedCornerShape(20.dp))
                .clip(RoundedCornerShape(25.dp))
                .background(Color.LightGray)
                .padding(Dp(15f))
        )
    }

    @Composable
    fun ClickText() {
        val context = LocalContext.current
        Text(
            text = "Clickable Text",
            modifier = Modifier
                .padding(horizontal = 0.dp, vertical = 10.dp)
                .clickable(enabled = true, onClickLabel = "Click", onClick = {
                    Toast
                        .makeText(context, "Clicked", Toast.LENGTH_SHORT)
                        .show()
                }),
            color = Color.Red
        )
    }
}