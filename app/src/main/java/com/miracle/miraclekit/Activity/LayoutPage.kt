package com.miracle.miraclekit.Activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
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
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.miracle.miraclekit.AppBarTitleText
import com.miracle.miraclekit.NormalTextDescription
import com.miracle.miraclekit.R
import com.miracle.miraclekit.SmallTextDescription
import com.miracle.miraclekit.SpaceLine
import com.miracle.miraclekit.TitleText
import com.miracle.miraclekit.theme.Clr1
import com.miracle.miraclekit.theme.Clr2
import com.miracle.miraclekit.theme.Clr3
import com.miracle.miraclekit.theme.L_Clr1
import com.miracle.miraclekit.theme.L_Clr2
import com.miracle.miraclekit.theme.L_Clr3
import com.miracle.miraclekit.theme.MiracleTheme

class LayoutPage : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MiracleTheme {
                Surface {
                    LayoutPageUI()
                }
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun LayoutPageUI() {
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

                val Mpadding = Modifier.align(Alignment.CenterStart)
                AppBarTitleText(Mpadding, text = "Layout")
            }

            Column(
                modifier = Modifier
                    .verticalScroll(rememberScrollState())
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .padding(10.dp)
            ) {
                TitleText("Row :")
                NormalTextDescription(stringResource(id = R.string.Row))
                RowDemo()
                SpaceLine()

                TitleText("Column :")

                NormalTextDescription(stringResource(id = R.string.Column1))
                ColumnDemo()
                Spacer(modifier = Modifier.height(10.dp))

                NormalTextDescription(stringResource(id = R.string.Column2))
                Spacer(modifier = Modifier.height(10.dp))
                ColumnsPaddingsDemo()

                Spacer(modifier = Modifier.height(10.dp))
                NormalTextDescription(stringResource(id = R.string.Column3))
                Spacer(modifier = Modifier.height(10.dp))
                ShadowDemo()

                SpaceLine()

                TitleText("Box :")
                NormalTextDescription(stringResource(id = R.string.Box))
                Spacer(modifier = Modifier.height(10.dp))
                BoxDemo()
                Spacer(modifier = Modifier.height(10.dp))
                NormalTextDescription(stringResource(id = R.string.Box1))
                Spacer(modifier = Modifier.height(10.dp))
                BoxShadowAndAlignmentDemo()
                Spacer(modifier = Modifier.height(10.dp))
                NormalTextDescription(stringResource(id = R.string.Box2))
                Spacer(modifier = Modifier.height(10.dp))
                WeightDemo()
                Spacer(modifier = Modifier.height(10.dp))
                NormalTextDescription(stringResource(id = R.string.Box3))
                Spacer(modifier = Modifier.height(10.dp))
                WeightAndSpacerDemo()
                Spacer(modifier = Modifier.height(10.dp))

            }
        }
    }

    @Composable
    fun RowDemo() {
        Spacer(modifier = Modifier.height(10.dp))
        SmallTextDescription(text = "Arrangement.Start")
        Spacer(modifier = Modifier.height(5.dp))
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Start) {
            InnerBox()
        }

        Spacer(modifier = Modifier.height(10.dp))
        SmallTextDescription(text = "Arrangement.End")
        Spacer(modifier = Modifier.height(5.dp))
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End) {
            InnerBox()
        }

        Spacer(modifier = Modifier.height(10.dp))
        SmallTextDescription(text = "Arrangement.Center")
        Spacer(modifier = Modifier.height(5.dp))
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
            InnerBox()
        }

        Spacer(modifier = Modifier.height(10.dp))
        SmallTextDescription(text = "Arrangement.SpaceEvenly")
        Spacer(modifier = Modifier.height(5.dp))
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
            InnerBox()
        }

        Spacer(modifier = Modifier.height(10.dp))
        SmallTextDescription(text = "Arrangement.SpaceAround")
        Spacer(modifier = Modifier.height(5.dp))
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceAround) {
            InnerBox()
        }

        Spacer(modifier = Modifier.height(10.dp))
        SmallTextDescription(text = "Arrangement.SpaceBetween")
        Spacer(modifier = Modifier.height(5.dp))
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            InnerBox()
        }
    }

    @Composable
    fun ColumnDemo() {
        val modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .height(100.dp)
            .background(Color.LightGray)

        SmallTextDescription(text = "Arrangement.Top")
        Column(modifier = modifier, verticalArrangement = Arrangement.Top) {
            InnerBox()
        }

        SmallTextDescription(text = "Arrangement.Bottom")
        Column(modifier = modifier, verticalArrangement = Arrangement.Bottom) {
            InnerBox()
        }

        SmallTextDescription(text = "Arrangement.Center")
        Column(modifier = modifier, verticalArrangement = Arrangement.Center) {
            InnerBox()
        }

        SmallTextDescription(text = "Arrangement.SpaceEvenly")
        Column(modifier = modifier, verticalArrangement = Arrangement.SpaceEvenly) {
            InnerBox()
        }

        SmallTextDescription(text = "Arrangement.SpaceAround")
        Column(modifier = modifier, verticalArrangement = Arrangement.SpaceAround) {
            InnerBox()
        }

        SmallTextDescription(text = "Arrangement.SpaceBetween")
        Column(modifier = modifier, verticalArrangement = Arrangement.SpaceBetween) {
            InnerBox()
        }

    }

    @Preview(showBackground = true)
    @Composable
    fun ColumnsPaddingsDemo() {
        val rowModifier = Modifier
            .background(Color.Gray)
            .fillMaxWidth()
            .wrapContentHeight()

        // 🔥 Padding after Yellow background leaves space inside container
        val modifierA = Modifier
            .background(L_Clr1)
            .padding(15.dp)

        // 🔥 Padding(10dp) before cyan color acts as margin while padding end leaves
        // space(padding) for the content inside the container
        val modifierB = Modifier
            .padding(10.dp)
            .background(L_Clr2)
            .padding(end = 15.dp)


        val modifierC = Modifier
            .background(L_Clr3)
            .padding(10.dp)
        Row(modifier = rowModifier, horizontalArrangement = Arrangement.SpaceEvenly) {
            Column(
                modifier = modifierA
                    .background(Clr1)
                    .padding(8.dp)
            ) {
                Text(text = "Text A1")
                Text(text = "Text A2")
                Text(text = "Text A3")
            }
            Column(
                modifier = modifierB
                    .background(Clr2)
                    .padding(top = 12.dp, bottom = 22.dp)
            ) {
                Text(text = "Text B1")
                Text(text = "Text B2")
                Text(text = "Text B3")
            }

            Column(modifier = modifierC.background(Clr3)) {
                Text(text = "Text C1")
                Text(text = "Text C2")
                Text(text = "Text C3")
            }
        }
    }

    @Composable
    fun InnerBox() {
        Box(
            modifier = Modifier
                .width(20.dp)
                .height(20.dp)
                .background(Color.Red)
                .padding(4.dp)
        )
        Box(
            modifier = Modifier
                .width(20.dp)
                .height(20.dp)
                .background(Color.Yellow)
                .padding(4.dp)
        )
        Box(
            modifier = Modifier
                .width(20.dp)
                .height(20.dp)
                .background(Color.Green)
                .padding(4.dp)
        )
    }

    @Preview(showBackground = true)
    @Composable
    fun ShadowDemo() {
        Row(
            modifier = Modifier
                .padding(8.dp)
                .shadow(
                    elevation = 4.dp,
                    shape = RoundedCornerShape(8.dp)
                )
        ) {
            InnerBox()
        }

        Column(
            modifier = Modifier
                .padding(8.dp)
                .shadow(
                    elevation = 4.dp,
                    shape = RoundedCornerShape(8.dp)
                )
        ) {
            InnerBox()
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun BoxDemo() {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp)
                .background(Color.LightGray)

        ) {
            // This is the one at the bottom
            Text(
                text = "First",
                modifier = Modifier
                    .background(Color(0xFF1976D2))
                    .size(120.dp),
                color = Color.White,
            )

            // This is the one in the middle
            Text(
                text = "Second",
                modifier = Modifier
                    .background(Color(0xFF2196F3))
                    .size(100.dp),
                color = Color.White
            )

            // This is the one on top
            Text(
                text = "Third ",
                modifier = Modifier
                    .background(Color(0xFF64B5F6))
                    .size(80.dp),
                color = Color.White
            )
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun BoxShadowAndAlignmentDemo() {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp)
                .background(Color.LightGray)
                .padding(8.dp)
        ) {
            Box(
                modifier = Modifier
                    .shadow(
                        elevation = 4.dp,
                        shape = RoundedCornerShape(8.dp)
                    )
            ) {
                Text(
                    text = "First",
                    modifier = Modifier
                        .background(Clr1)
                        .size(120.dp),
                    color = Color.White,
                )
            }
            Box(
                modifier = Modifier
                    .shadow(
                        elevation = 8.dp,
                        shape = RoundedCornerShape(8.dp)
                    )
                    .align(Alignment.TopEnd)

            ) {
                Text(
                    text = "Second",
                    modifier = Modifier
                        .background(Clr2)
                        .size(80.dp),
                    color = Color.White
                )
            }

            Box(
                modifier = Modifier
                    .shadow(
                        elevation = 4.dp,
                        shape = RoundedCornerShape(8.dp)
                    )
                    .align(Alignment.BottomStart)
            ) {
                Text(
                    text = "Third ",
                    modifier = Modifier
                        .background(Clr3)
                        .size(70.dp),
                    color = Color.White
                )
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun WeightDemo() {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.LightGray)
        ) {
            Row {
                Text(
                    text = "Row1", modifier = Modifier
                        .background(Clr1)
                        .padding(4.dp)
                )

                // 🔥 This spacer fills space between Row1 and space other than Row2, and Row3
                Spacer(modifier = Modifier.weight(1f))

                Text(
                    text = "Row2", modifier = Modifier
                        .background(Clr2)
                        .padding(4.dp)
                )
                Text(
                    text = "Row3", modifier = Modifier
                        .background(Clr3)
                        .padding(4.dp)
                )
            }

            Column(modifier = Modifier.height(150.dp)) {
                Text(
                    text = "Column1", modifier = Modifier
                        .background(Clr3)
                        .padding(4.dp)
                )
                Spacer(modifier = Modifier.weight(1f))
                Text(
                    text = "Column2", modifier = Modifier
                        .background(Clr2)
                        .padding(4.dp)
                )
                Text(
                    text = "Column3", modifier = Modifier
                        .background(Clr1)
                        .padding(4.dp)
                )
            }
        }
    }

    @Composable
    fun WeightAndSpacerDemo() {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .background(Color.LightGray)
        ) {

            Text(
                fontSize = 12.sp,
                text = "Weight 2",
                modifier = Modifier
                    .fillMaxHeight()
                    .background(Clr1)
                    .padding(4.dp)
                    .weight(2f)
            )

            // Spacer creates a space with given modifier width or height based on which scope(row/column) it exists
            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp)
                    .background(Color.LightGray)
                    .weight(1f)
            )

            Text(
                fontSize = 12.sp,
                text = "Weight 3",
                modifier = Modifier
                    .fillMaxHeight()
                    .background(Clr1)
                    .padding(4.dp)
                    .weight(3f)
            )

            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp)
                    .background(Color.LightGray)
                    .weight(1f)
            )

            Text(
                fontSize = 12.sp,
                text = "Weight 2",
                modifier = Modifier
                    .fillMaxHeight()
                    .background(Clr1)
                    .padding(4.dp)
                    .weight(2f)
            )
        }

        // This spacer is for column which behaves as padding below this component
        Spacer(modifier = Modifier.height(16.dp))
    }
}