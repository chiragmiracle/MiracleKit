package com.miracle.miraclekit.ListGrid

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.miracle.miraclekit.AppBarTitleText
import com.miracle.miraclekit.R
import com.miracle.miraclekit.selectedButton
import com.miracle.miraclekit.theme.Clr1
import com.miracle.miraclekit.theme.Clr2
import com.miracle.miraclekit.theme.Clr3
import com.miracle.miraclekit.theme.Clr4
import com.miracle.miraclekit.theme.Clr5
import com.miracle.miraclekit.theme.Clr6
import com.miracle.miraclekit.theme.Clr7
import com.miracle.miraclekit.theme.L_Clr1
import com.miracle.miraclekit.theme.L_Clr2
import com.miracle.miraclekit.theme.L_Clr3
import com.miracle.miraclekit.theme.L_Clr4
import com.miracle.miraclekit.theme.L_Clr5
import com.miracle.miraclekit.theme.L_Clr6
import com.miracle.miraclekit.theme.L_Clr7
import com.miracle.miraclekit.theme.MiracleTheme

class MainListGridPage : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MiracleTheme {
                Surface(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(),
                ) {
                    MainListGridPageUI()
                }
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun MainListGridPageUI() {
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
                AppBarTitleText(Mpadding, text = "List & Grid")

            }

            Column(
                modifier = Modifier
                    .verticalScroll(rememberScrollState())
                    .fillMaxWidth()
                    .fillMaxHeight()
            ) {

                Spacer(modifier = Modifier.height(10.dp))

                selectedButton(R.drawable.ic_listgrid, "Lazy Column 1", Clr1, L_Clr1,
                    tags = listOf(
                        "Lazy Column",
                        "Compose",
                        "Vertical Arrangement",
                        "Contact Padding",
                        "Model Class",
                        "Custom Card Item",
                        "Favourite",
                    ),
                    onIntent = {
                        startActivity(
                            Intent(
                                this@MainListGridPage, LazyColumnPage1::class.java
                            )
                        )
                    })

                selectedButton(R.drawable.ic_listgrid, "Lazy Column 2", Clr2, L_Clr2,
                    tags = listOf(
                        "Custom Lazy Column",
                        "Compose",
                        "Vertical Arrangement",
                        "Contact Padding",
                        "Custom Lazy Scroll",
                        "Add Item",
                        "Remove Item",
                        "Swipe to Top",
                        "Swipe to Bottom",
                        "Model Class",
                        "Custom Card Item",
                        "Favourite",
                    ),
                    onIntent = {
                        startActivity(
                            Intent(
                                this@MainListGridPage, LazyColumnPage2::class.java
                            )
                        )
                    })

                selectedButton(R.drawable.ic_listgrid, "Lazy Row", Clr3, L_Clr3,
                    tags = listOf(
                        "Lazy Row",
                        "Compose",
                        "Vertical Arrangement",
                        "Contact Padding",
                        "Model Class",
                        "Custom Card Item",
                        "Favourite",
                    ),
                    onIntent = {
                        startActivity(
                            Intent(
                                this@MainListGridPage, LazyRowPage::class.java
                            )
                        )
                    })

                selectedButton(R.drawable.ic_listgrid, "Lazy Vertical Grid", Clr4, L_Clr4,
                    tags = listOf(
                        "Lazy Vertical Grid",
                        "Compose",
                        "Grid Cell",
                        "Vertical Arrangement",
                        "Contact Padding",
                    ),
                    onIntent = {
                        startActivity(
                            Intent(
                                this@MainListGridPage, LazyVerticalGridPage::class.java
                            )
                        )
                    })

                selectedButton(R.drawable.ic_listgrid, "Dynamic Lazy Vertical Grid", Clr5, L_Clr5,
                    tags = listOf(
                        "Lazy Vertical Grid",
                        "Compose",
                        "Grid Cell",
                        "Vertical Arrangement",
                        "Contact Padding",
                    ),
                    onIntent = {
                        startActivity(
                            Intent(
                                this@MainListGridPage, DynamicLazyVerticalGridPage::class.java
                            )
                        )
                    })

                selectedButton(R.drawable.ic_listgrid, "Lazy Vertical Staggered Grid", Clr6, L_Clr6,
                    tags = listOf(
                        "Staggered Grid",
                        "Lazy Vertical Grid",
                        "Compose",
                        "Grid Cell",
                        "Vertical Arrangement",
                        "Contact Padding",
                    ),
                    onIntent = {
                        startActivity(
                            Intent(
                                this@MainListGridPage, LazyVerticalStaggeredGridPage::class.java
                            )
                        )
                    })

                selectedButton(R.drawable.ic_listgrid, "Vertical List Items", Clr7, L_Clr7,
                    tags = listOf(
                        "Lazy Column",
                        "Compose",
                        "List Items",
                    ),
                    onIntent = {
                        startActivity(
                            Intent(
                                this@MainListGridPage, VerticalListItemsPage::class.java
                            )
                        )
                    })
            }
        }
    }
}