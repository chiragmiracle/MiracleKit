package com.miracle.miraclekit

import android.content.Intent
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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.miracle.miraclekit.Activity.ImagePage
import com.miracle.miraclekit.Activity.LayoutPage
import com.miracle.miraclekit.Activity.TextPage
import com.miracle.miraclekit.ui.theme.Clr1
import com.miracle.miraclekit.ui.theme.Clr2
import com.miracle.miraclekit.ui.theme.Clr3
import com.miracle.miraclekit.ui.theme.Clr4
import com.miracle.miraclekit.ui.theme.L_Clr1
import com.miracle.miraclekit.ui.theme.L_Clr2
import com.miracle.miraclekit.ui.theme.L_Clr3
import com.miracle.miraclekit.ui.theme.L_Clr4
import com.miracle.miraclekit.ui.theme.MiracleTheme
import com.miracle.miraclekit.ui.theme.White

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MiracleTheme {
                Surface(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(),
                ) {
                    MainUI()
                }
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun MainUI() {
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
                Text(
                    text = "Miracle Kit",
                    color = Color.Black,
                    fontFamily = FontFamily.SansSerif,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .align(alignment = Alignment.CenterStart)
                        .padding(start = 15.dp)
                )
            }
            Column(
                modifier = Modifier
                    .verticalScroll(rememberScrollState())
                    .fillMaxWidth()
                    .fillMaxHeight(),
            ) {
                Spacer(modifier = Modifier.height(10.dp))

                selectedButton(R.drawable.ic_font, "Text", Clr1, L_Clr1,
                    tags = listOf(
                        "Simple Text",
                        "String Resource Text",
                        "Set Color",
                        "Set Size",
                        "Font Family",
                        "Font Style & Weight",
                        "Custom Text",
                        "Set Shadow Text",
                        "Clickable Text",
                    ),
                    onIntent = {
                        startActivity(
                            Intent(
                                this@MainActivity, TextPage::class.java
                            )
                        )
                    })

                selectedButton(R.drawable.ic_image, "Image", Clr2, L_Clr2,
                    tags = listOf(
                        "Icon",
                        "Simple Image",
                        "Set Shape",
                        "Set Inside Fit",
                        "Set Filter"
                    ),
                    onIntent = {
                        startActivity(
                            Intent(
                                this@MainActivity, ImagePage::class.java
                            )
                        )
                    })

                selectedButton(R.drawable.ic_layout, "Column, Row, Box", Clr3, L_Clr3,
                    tags = listOf(
                        "Simple Text",
                        "String Resource Text",
                        "Set Color",
                        "Set Size",
                        "Font Family",
                        "Font Style & Weight",
                        "Custom Text",
                        "Set Shadow Text",
                        "Clickable Text",
                    ),
                    onIntent = {
                        startActivity(
                            Intent(
                                this@MainActivity, LayoutPage::class.java
                            )
                        )
                    })

                selectedButton(R.drawable.ic_image, "Image", Clr4, L_Clr4,
                    tags = listOf(
                        "Icon",
                        "Simple Image",
                        "Set Shape",
                        "Set Inside Fit",
                        "Set Filter"
                    ),
                    onIntent = {
                        startActivity(
                            Intent(
                                this@MainActivity, ImagePage::class.java
                            )
                        )
                    })

            }
        }
    }


    @Composable
    fun selectedButton(
        image: Int,
        title: String,
        dark_clr: Color,
        light_clr: Color,
        tags: List<String> = listOf(),
        onIntent: () -> Unit
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(80.dp)
                .padding(horizontal = 15.dp, vertical = 7.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Box(
                modifier = Modifier
                    .clickable { onIntent() }
                    .fillMaxHeight()
                    .width(70.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .background(color = dark_clr)
                    .clickable(
                        indication = null,
                        interactionSource = remember { MutableInteractionSource() } // This is mandatory
                    ) { onIntent() },
                Alignment.Center
            ) {
                Image(
                    painter = painterResource(image),
                    contentDescription = null,
                    colorFilter = ColorFilter.tint(White),
                    modifier = Modifier
                        .height(40.dp)
                        .width(40.dp)
                )
            }
            Spacer(modifier = Modifier.width(10.dp))
            Column(
                modifier = Modifier
                    .clickable(
                        indication = null,
                        interactionSource = remember { MutableInteractionSource() } // This is mandatory
                    ) { onIntent() }
                    .fillMaxHeight()
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(10.dp))
                    .background(color = light_clr)
                    .padding(10.dp, 7.dp, 0.dp, 7.dp),
            ) {
                Text(
                    text = title,
                    color = Color.Black,
                    fontSize = 16.sp,
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.height(5.dp))
                LazyRow(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    content = {
                        items(tags) { tag ->
                            TutorialChip(tag, dark_clr)
                        }
                    })
            }

        }
    }
}

@Composable
fun TutorialChip(text: String, color: Color) {
    Card(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 0.dp
        ),
        colors = CardDefaults.cardColors(
            containerColor = White,
        ),
        shape = RoundedCornerShape(20.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(horizontal = 7.dp)
                .height(35.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Box(
                modifier = Modifier
                    .size(8.dp, 8.dp)
                    .clip(CircleShape)
                    .background(color = color)
            )
            Spacer(Modifier.width(5.dp))
            Text(
                text = text,
                color = Color.Black,
                fontSize = 12.sp,
                fontWeight = FontWeight.Normal,
                textAlign = TextAlign.Center
            )
        }
    }
}