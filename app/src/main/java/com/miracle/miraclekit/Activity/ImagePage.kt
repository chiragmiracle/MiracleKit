package com.miracle.miraclekit.Activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.BlurredEdgeTreatment
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ColorMatrix
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.miracle.miraclekit.R
import com.miracle.miraclekit.SmallTextDescription
import com.miracle.miraclekit.SpaceLine
import com.miracle.miraclekit.TitleText
import com.miracle.miraclekit.theme.Divider_Clr
import com.miracle.miraclekit.theme.MiracleTheme
import com.miracle.miraclekit.theme.Theme_Clr
import com.miracle.miraclekit.theme.White

class ImagePage : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MiracleTheme {
                Surface {
                    ImagePageUI()
                }
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun ImagePageUI() {
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
                    text = "Icon & Image",
                    color = Color.Black,
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

                TitleText("Icon :")
                IconIMG()
                SpaceLine()

                TitleText("Simple Image :")
                SimpleImage()
                SpaceLine()

                TitleText("Shape Image :")
                ShapeImageView()
                SpaceLine()

                TitleText("Fit Image :")
                InsideFitImage()
                SpaceLine()

                TitleText("Image Color Filter :")
                ImgColorFilter()
                SpaceLine()

            }
        }
    }

    @Composable
    fun IconIMG() {
        SmallTextDescription(stringResource(id = R.string.Icon1))
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {

            Icon(
                imageVector = Icons.Default.ArrowBack,
                tint = Color.Black,
                contentDescription = "Set Default Icon"
            )
            Spacer(modifier = Modifier.width(15.dp))
            Icon(
                painter = painterResource(id = R.drawable.ic_back),
                contentDescription = "Icon Drawable",
                tint = Color.Black,
                modifier = Modifier
                    .size(30.dp)
                    .padding(5.dp)
            )
            Spacer(modifier = Modifier.width(15.dp))
            Icon(
                imageVector = Icons.Filled.Email,
                contentDescription = "Set Tint Icon",
                tint = Color.Red,
                modifier = Modifier
                    .size(35.dp)
            )
            Spacer(modifier = Modifier.width(15.dp))
            Icon(
                imageVector = Icons.Filled.Email,
                contentDescription = "Opacity Down Icon",
                tint = Color.Red,
                modifier = Modifier
                    .alpha(0.5f) //Down Opacity
                    .size(35.dp)
            )
            Spacer(modifier = Modifier.width(15.dp))
            Icon(
                imageVector = Icons.Filled.Email,
                contentDescription = "Rotate Icon",
                tint = Color.Red,
                modifier = Modifier
                    .size(35.dp)
                    .rotate(90F)
            )
        }

    }

    @Composable
    fun SimpleImage() {
        Image(
            painter = painterResource(id = R.drawable.ic_image),
            contentDescription = "Andy Rubin",
            modifier = Modifier.size(50.dp)
        )
    }

    @Composable
    fun ShapeImageView() {
        SmallTextDescription(stringResource(id = R.string.Icon2))
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(R.drawable.test1),
                contentDescription = "Circle Image",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(50.dp)
                    .clip(CircleShape) // clip to the circle shape
                    .border(1.dp, Color.Black, CircleShape)//optional
            )
            Spacer(modifier = Modifier.width(15.dp))
            Image(
                painter = painterResource(R.drawable.test1),
                contentDescription = "Round corner image",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(50.dp)
                    .clip(RoundedCornerShape(10))
                    .border(1.dp, Color.Black, RoundedCornerShape(10))
            )
            Spacer(modifier = Modifier.width(15.dp))
            val rainbowColorsBrush = remember {
                Brush.sweepGradient(
                    listOf(
                        Color(0xFF9575CD),
                        Color(0xFFBA68C8),
                        Color(0xFFE57373),
                        Color(0xFFFFB74D),
                        Color(0xFFFFF176),
                        Color(0xFFAED581),
                        Color(0xFF4DD0E1),
                        Color(0xFF9575CD)
                    )
                )
            }
            val borderWidth = 2.dp
            Image(
                painter = painterResource(id = R.drawable.test1),
                contentDescription = "Gradient Border Image",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(50.dp)
                    .border(
                        BorderStroke(borderWidth, rainbowColorsBrush),
                        CircleShape
                    )
                    .padding(borderWidth)
                    .clip(CircleShape)
            )
        }
    }

    @Composable
    fun InsideFitImage() {
        SmallTextDescription(stringResource(id = R.string.Icon3))
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.test1),
                contentDescription = "",
                modifier = Modifier
                    .size(50.dp)
                    .background(Color.LightGray),
                contentScale = ContentScale.Inside,
            )
            Spacer(modifier = Modifier.width(10.dp))
            Image(
                painter = painterResource(id = R.drawable.test1),
                contentDescription = "",
                modifier = Modifier
                    .size(50.dp)
                    .background(Color.LightGray),
                contentScale = ContentScale.Fit,
            )
            Spacer(modifier = Modifier.width(10.dp))
            Image(
                painter = painterResource(id = R.drawable.test1),
                contentDescription = "",
                modifier = Modifier
                    .size(50.dp)
                    .background(Color.LightGray),
                contentScale = ContentScale.Crop,
            )
            Spacer(modifier = Modifier.width(10.dp))
            Image(
                painter = painterResource(id = R.drawable.test1),
                contentDescription = "",
                modifier = Modifier
                    .size(50.dp)
                    .background(Color.LightGray),
                contentScale = ContentScale.FillBounds,
            )
            Spacer(modifier = Modifier.width(10.dp))
            Image(
                painter = painterResource(id = R.drawable.test1),
                contentDescription = "",
                modifier = Modifier
                    .size(50.dp)
                    .background(Color.LightGray),
                contentScale = ContentScale.FillHeight,
            )
            Spacer(modifier = Modifier.width(10.dp))
            Image(
                painter = painterResource(id = R.drawable.test1),
                contentDescription = "",
                modifier = Modifier
                    .size(50.dp)
                    .background(Color.LightGray),
                contentScale = ContentScale.FillWidth,
            )
            Spacer(modifier = Modifier.width(10.dp))
        }


    }

    @Composable
    fun ImgColorFilter() {
        SmallTextDescription(stringResource(id = R.string.Icon4))
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.test1),
                contentDescription = "Green Color Filter",
                contentScale = ContentScale.Crop,
                colorFilter = ColorFilter.tint(Color.Green, blendMode = BlendMode.Darken),
                modifier = Modifier
                    .size(50.dp)
            )
            Spacer(modifier = Modifier.width(10.dp))
            Image(
                painter = painterResource(id = R.drawable.test1),
                contentDescription = "Black & White Color Filter",
                contentScale = ContentScale.Crop,
                colorFilter = ColorFilter.colorMatrix(ColorMatrix().apply { setToSaturation(0f) }),
                modifier = Modifier
                    .size(50.dp)
            )
            Spacer(modifier = Modifier.width(10.dp))
            val contrast = 2f // 0f..10f (1 should be default)
            val brightness = -180f // -255f..255f (0 should be default)
            val colorMatrix = floatArrayOf(
                contrast, 0f, 0f, 0f, brightness,
                0f, contrast, 0f, 0f, brightness,
                0f, 0f, contrast, 0f, brightness,
                0f, 0f, 0f, 1f, 0f
            )
            Image(
                painter = painterResource(id = R.drawable.test1),
                contentDescription = "Color Matrix Filter",
                contentScale = ContentScale.Crop,
                colorFilter = ColorFilter.colorMatrix(ColorMatrix(colorMatrix)),
                modifier = Modifier
                    .size(50.dp)
            )
            Spacer(modifier = Modifier.width(10.dp))
            val colorMatrix1 = floatArrayOf(
                -1f, 0f, 0f, 0f, 255f,
                0f, -1f, 0f, 0f, 255f,
                0f, 0f, -1f, 0f, 255f,
                0f, 0f, 0f, 1f, 0f
            )
            Image(
                painter = painterResource(id = R.drawable.test1),
                contentDescription = "Color Matrix Filter",
                contentScale = ContentScale.Crop,
                colorFilter = ColorFilter.colorMatrix(ColorMatrix(colorMatrix1)),
                modifier = Modifier
                    .size(50.dp)
            )
            Spacer(modifier = Modifier.width(10.dp))

            Image(
                painter = painterResource(id = R.drawable.test1),
                contentDescription = "Blur Image",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(50.dp)
                    .blur(
                        radiusX = 5.dp,
                        radiusY = 5.dp,
                        edgeTreatment = BlurredEdgeTreatment.Unbounded
                    )
                    .clip(RoundedCornerShape(8.dp))
            )
            Spacer(modifier = Modifier.width(10.dp))
        }


    }
}

