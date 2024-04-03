package com.miracle.miraclekit.Activity

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
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
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.miracle.miraclekit.NormalTextDescription
import com.miracle.miraclekit.R
import com.miracle.miraclekit.SpaceLine
import com.miracle.miraclekit.TitleText
import com.miracle.miraclekit.ui.theme.Clr1
import com.miracle.miraclekit.ui.theme.Clr2
import com.miracle.miraclekit.ui.theme.Clr3
import com.miracle.miraclekit.ui.theme.Clr4
import com.miracle.miraclekit.ui.theme.L_Clr1
import com.miracle.miraclekit.ui.theme.L_Clr2
import com.miracle.miraclekit.ui.theme.L_Clr3
import com.miracle.miraclekit.ui.theme.L_Clr4
import com.miracle.miraclekit.ui.theme.MiracleTheme

class SurfacePage : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MiracleTheme {
                Surface(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(),
                ) {
                    SurfacePageUI()
                }
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun SurfacePageUI() {
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
                    text = "Surface",
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

                TitleText("Clickable :")
                NormalTextDescription(stringResource(id = R.string.Clickable1))
                Spacer(modifier = Modifier.height(10.dp))
                ClickableDemo()
                SpaceLine()

                TitleText("Surface :")
                NormalTextDescription(stringResource(id = R.string.Surface1))
                Spacer(modifier = Modifier.height(10.dp))
                SurfaceContentColorDemo()
                Spacer(modifier = Modifier.height(10.dp))

                NormalTextDescription(stringResource(id = R.string.Surface2))
                Spacer(modifier = Modifier.height(10.dp))
                SurfaceShapeDemo()

                Spacer(modifier = Modifier.height(10.dp))
                NormalTextDescription(stringResource(id = R.string.Surface3))
                SurfaceIndexDemo()

                Spacer(modifier = Modifier.height(10.dp))
                NormalTextDescription(stringResource(id = R.string.Surface4))
                SurfaceClickPropagationDemo()


            }
        }
    }

    @Composable
    fun ClickableDemo() {
        val context = LocalContext.current
        Row(Modifier.height(60.dp)) {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .background(Clr1)
                    .clickable(onClick = {
                        Toast
                            .makeText(context, "Clicked me", Toast.LENGTH_SHORT)
                            .show()
                    }),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    color = Color.White,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    text = "Click Me"
                )
            }
            Column(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .background(Clr2)
                    .padding(15.dp)
                    .clickable(onClick = {
                        Toast
                            .makeText(context, "Clicked me", Toast.LENGTH_SHORT)
                            .show()
                    }),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    color = Color.White,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    text = "Click Me"
                )
            }
        }
    }

    @Composable
    fun SurfaceContentColorDemo() {
        Surface(
            shape = RoundedCornerShape(10.dp),
            color = Clr1,
            contentColor = L_Clr1
        ) {
            Text(
                text = "Text inside Surface uses Surface's content color as a default color.",
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp,
                modifier = Modifier.padding(8.dp)
            )
        }
    }

    @Composable
    fun SurfaceShapeDemo() {
        Row {
            // Set Aspect ratio to 1:1 to have same width and height
            val modifier = Modifier
                .aspectRatio(1f)
                // Weight makes sure that we use the width - total padding space
                // evenly between composables
                .weight(1f)
                .padding(12.dp)
            // Rectangle Shape
            Surface(
                shape = RectangleShape,
                modifier = modifier,
                color = (Clr1)
            ) {

            }
            // Rounder Corner Shape
            Surface(
                shape = RoundedCornerShape(5.dp),
                modifier = modifier,
                color = (Clr2)
            ) {}
            // Circle Shape
            Surface(
                shape = CircleShape,
                modifier = modifier,
                color = (Clr3)
            ) {}
            //
            Surface(
                shape = CutCornerShape(10.dp),
                modifier = modifier,
                color = (Clr4)
            ) {}
        }
    }

    @Composable
    fun SurfaceIndexDemo() {
        Row {
            // Set Aspect ratio to 1:1 to have same width and height
            val modifier = Modifier
                .aspectRatio(1f)
                // Weight makes sure that we use the width - total padding space
                // evenly between composables
                .weight(1f)
                .padding(12.dp)
            // Rectangle Shape
            Surface(
                shape = RectangleShape,
                modifier = modifier,
                color = (L_Clr1),
                shadowElevation = 2.dp,
                border = BorderStroke(3.dp, color = Clr1)
            ) {}

            // Rounder Corner Shape
            Surface(
                shape = RoundedCornerShape(5.dp),
                modifier = modifier,
                color = (L_Clr2),
                shadowElevation = 5.dp,
                border = BorderStroke(3.dp, color = Clr2)
            ) {}

            // Circle Shape
            Surface(
                shape = CircleShape,
                modifier = modifier,
                color = L_Clr3,
                shadowElevation = 7.dp,
                border = BorderStroke(3.dp, color = Clr3)
            ) {}

            // Rectangle with cut corner on top left
            Surface(
                shape = CutCornerShape(topStartPercent = 20),
                modifier = modifier,
                color = L_Clr4,
                shadowElevation = 10.dp,
                border = BorderStroke(3.dp, color = Clr4)
            ) {}
        }
    }

    @Composable
    fun SurfaceClickPropagationDemo() {
        // Provides a Context that can be used by Android applications
        val context = LocalContext.current

        // 🔥 Offset moves a component in x and y axes which can be either positive or negative
        // 🔥🔥 When a component inside surface is offset from original position it gets clipped.
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .clickable(onClick = {
                    Toast
                        .makeText(context, "Box Clicked", Toast.LENGTH_SHORT)
                        .show()
                })
        ) {

            Surface(
                shadowElevation = 10.dp,
                shape = RoundedCornerShape(10.dp),
                color = Clr1,
                modifier = Modifier
                    .size(150.dp)
                    .padding(10.dp)
                    .clickable(onClick = {
                        Toast
                            .makeText(
                                context,
                                "Surface(Left) inside Box is clicked!",
                                Toast.LENGTH_SHORT
                            )
                            .show()
                    })
            ) {
                Surface(
                    shape = CircleShape,
                    shadowElevation = 12.dp,
                    color = Clr2,
                    modifier = Modifier
                        .size(80.dp)
                        .offset(x = 50.dp, y = (-20).dp)
                        .clickable(onClick = {
                            Toast
                                .makeText(
                                    context,
                                    "Surface inside Surface is clicked!",
                                    Toast.LENGTH_SHORT
                                )
                                .show()
                        }),
                ) {}

            }

            Surface(
                shape = CutCornerShape(10.dp),
                color = Clr4,
                shadowElevation = 8.dp,
                modifier = Modifier
                    .size(110.dp)
                    .padding(12.dp)
                    .offset(x = 110.dp, y = 20.dp)
                    .clickable(onClick = {
                        Toast
                            .makeText(
                                context,
                                "Surface(Right) inside Box is clicked!",
                                Toast.LENGTH_SHORT
                            )
                            .show()

                    }),
            ) {}
        }
    }
}