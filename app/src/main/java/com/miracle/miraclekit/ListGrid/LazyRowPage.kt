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
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
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
import com.miracle.miraclekit.Model.Place
import com.miracle.miraclekit.Model.SnackList
import com.miracle.miraclekit.Model.places
import com.miracle.miraclekit.Model.snackList
import com.miracle.miraclekit.R
import com.miracle.miraclekit.theme.BgColor
import com.miracle.miraclekit.theme.Clr1
import com.miracle.miraclekit.theme.MiracleTheme
import com.miracle.miraclekit.ui.HorizontalSnackCard
import com.miracle.miraclekit.ui.PlaceCard
import com.miracle.miraclekit.ui.PlacesToBookComponent

class LazyRowPage : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MiracleTheme {
                Surface(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(),
                ) {
                    LazyColumnPageUI()
                }
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun LazyColumnPageUI() {
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
                    text = "Lazy Row",
                    color = Color.Black,
                    fontFamily = FontFamily.SansSerif,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.align(alignment = Alignment.Center)
                )
            }

            LazyColumn(
                contentPadding = PaddingValues(horizontal = 8.dp, vertical = 8.dp),
                verticalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier
                    .fillMaxHeight()
                    .background(BgColor),
                content = {
                    item {
                        Text(
                            color = Clr1,
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold,
                            text = "Places"
                        )
                    }

                    item {
                        LazyRow(
                            horizontalArrangement = Arrangement.spacedBy(8.dp),
                            content = {
                                items(places) { place: Place ->
                                    PlaceCard(place = place)
                                }
                            }
                        )
                    }
                    item {
                        Spacer(modifier = Modifier.height(10.dp))
                        androidx.compose.material.Text(
                            color = Color(0xffE53935),
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold,
                            text = "Snacks"
                        )
                    }

                    item {
                        LazyRow(
                            horizontalArrangement = Arrangement.spacedBy(8.dp),
                            content = {
                                items(snackList) { snack: SnackList ->
                                    HorizontalSnackCard(snack = snack)
                                }
                            }
                        )
                    }

                    item {
                        Spacer(modifier = Modifier.height(10.dp))
                        androidx.compose.material.Text(
                            color = Color(0xff4CAF50),
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold,
                            text = "Places to Visit"
                        )
                    }

                    item {
                        LazyRow(
                            horizontalArrangement = Arrangement.spacedBy(8.dp),
                            content = {
                                items(places) { place: Place ->
                                    PlacesToBookComponent(place = place)
                                }
                            }
                        )
                    }

                },
            )
        }
    }
}