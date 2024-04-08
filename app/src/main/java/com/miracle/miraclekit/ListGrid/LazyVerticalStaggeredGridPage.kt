package com.miracle.miraclekit.ListGrid

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
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.miracle.miraclekit.R
import com.miracle.miraclekit.theme.MiracleTheme
import kotlin.random.Random

class LazyVerticalStaggeredGridPage : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MiracleTheme {
                Surface(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(),
                ) {
                    LazyVerticalStaggeredGridPageUI()
                }
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun LazyVerticalStaggeredGridPageUI() {
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
                    text = "Lazy Vertical Staggered Grid",
                    color = Color.Black,
                    fontFamily = FontFamily.SansSerif,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.align(alignment = Alignment.Center)
                )
            }

            val items = (1..100).map {
                ListItem(
                    height = Random.nextInt(100, 300).dp, color = Color(
                        Random.nextLong(0xFFFFFFFF)
                    ).copy(alpha = 1f)
                )
            }

            LazyVerticalStaggeredGrid(
                columns = StaggeredGridCells.Fixed(2),
                verticalItemSpacing = 10.dp,
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                content = {
                    items(items) { item ->
                        RandomColorBox(item = item)
                    }
                },
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 10.dp),
            )

//            LazyVerticalStaggeredGrid(
//                columns = StaggeredGridCells.Fixed(2),
//                verticalItemSpacing = 10.dp,
//                horizontalArrangement = Arrangement.spacedBy(10.dp),
//                content = {
//                    items(places) { place: Place ->
//                        ImgPlaceCard(place = place)
//                    }
//                },
//                modifier = Modifier
//                    .fillMaxSize()
//                    .padding(horizontal = 10.dp),
//            )

        }
    }
}

data class ListItem(
    val height: Dp, val color: Color
)

@Composable
fun RandomColorBox(item: ListItem) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(item.height)
            .clip(RoundedCornerShape(10.dp))
            .background(item.color)
    )
}

//@Composable
//fun ImgPlaceCard(place: Place) {
//    val painter = painterResource(id = place.imgRes)
//    Box(
//        contentAlignment = Alignment.BottomStart,
//        modifier = Modifier
//            .fillMaxWidth()
//            .aspectRatio(
//                ratio = Random
//                    .nextDouble(0.2, 1.8)
//                    .toFloat()
//            ),
//    ) {
//        Image(
//            painter = painter,
//            contentScale = ContentScale.FillBounds,
//            modifier = Modifier
//                .clickable { }
//                .fillMaxHeight()
//                .fillMaxWidth(),
//            contentDescription = null
//        )
//    }
//}
