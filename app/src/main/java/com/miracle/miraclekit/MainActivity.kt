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
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.miracle.miraclekit.BottomAppBarNav.AppBarTabPage
import com.miracle.miraclekit.BottomAppBarNav.BottomAppBarNavPage
import com.miracle.miraclekit.Activity.ButtonPage
import com.miracle.miraclekit.Activity.ImagePage
import com.miracle.miraclekit.Activity.LayoutPage
import com.miracle.miraclekit.Activity.SurfacePage
import com.miracle.miraclekit.Activity.TextFieldPage
import com.miracle.miraclekit.Activity.TextPage
import com.miracle.miraclekit.ListGrid.MainListGridPage
import com.miracle.miraclekit.NavDrawer.NavDrawerPage
import com.miracle.miraclekit.Selector.SelectorPage
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
import com.miracle.miraclekit.theme.Divider_Clr
import com.miracle.miraclekit.theme.L_Clr1
import com.miracle.miraclekit.theme.L_Clr10
import com.miracle.miraclekit.theme.L_Clr2
import com.miracle.miraclekit.theme.L_Clr3
import com.miracle.miraclekit.theme.L_Clr4
import com.miracle.miraclekit.theme.L_Clr5
import com.miracle.miraclekit.theme.L_Clr6
import com.miracle.miraclekit.theme.L_Clr7
import com.miracle.miraclekit.theme.L_Clr8
import com.miracle.miraclekit.theme.L_Clr9
import com.miracle.miraclekit.theme.MiracleTheme
import com.miracle.miraclekit.theme.White
import com.miracle.miraclekit.ui.JumpToTopButton
import kotlinx.coroutines.launch

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
                    text = stringResource(id = R.string.app_name),
                    color = Color.Black,
                    fontFamily = FontFamily.SansSerif,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .align(alignment = Alignment.Center)
                )
            }

            Box {
                val scrollState = rememberLazyListState()
                LazyColumn(
                    state = scrollState,
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(),
                    content = {
                        item {
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

                            selectedButton(R.drawable.ic_layout, "Layout", Clr3, L_Clr3,
                                tags = listOf(
                                    "Row",
                                    "Column",
                                    "Box",
                                    "Modifier",
                                    "Arrangement",
                                    "Padding",
                                    "Weight",
                                    "Spacer",
                                ),
                                onIntent = {
                                    startActivity(
                                        Intent(
                                            this@MainActivity, LayoutPage::class.java
                                        )
                                    )
                                })

                            selectedButton(R.drawable.ic_layout, "Surface", Clr4, L_Clr4,
                                tags = listOf(
                                    "Clickable",
                                    "Surface",
                                    "Set Custom Shape",
                                    "Set Border & Shadow",
                                    "Set Off"
                                ),
                                onIntent = {
                                    startActivity(
                                        Intent(
                                            this@MainActivity, SurfacePage::class.java
                                        )
                                    )
                                })

                            selectedButton(R.drawable.ic_button, "Button", Clr5, L_Clr5,
                                tags = listOf(
                                    "Simple Button",
                                    "Disabled Button",
                                    "Button With Icon",
                                    "Set Background",
                                    "Icon Button",
                                    "Custom Icon Button",
                                    "Floating Action Button",
                                    "Chip Button",
                                    "Custom Chip Button",
                                ),
                                onIntent = {
                                    startActivity(
                                        Intent(
                                            this@MainActivity, ButtonPage::class.java
                                        )
                                    )
                                })

                            selectedButton(R.drawable.ic_edit_text, "Text Field", Clr6, L_Clr6,
                                tags = listOf(
                                    "Simple TextField",
                                    "Error TextField",
                                    "Background Color Change",
                                    "Text Style Change",
                                    "Set Custom Background Shape",
                                    "Outline TextField",
                                    "Remove Label",
                                    "Single Line, Line Height",
                                    "KeyboardType Phone & Password",
                                    "Icon with TextField",
                                    "IME Icons and Action",
                                    "Mask Chars",
                                    "Credit Card Input",
                                    "Phone Number Input",
                                    "Custom Composable TextField",
                                ),
                                onIntent = {
                                    startActivity(
                                        Intent(
                                            this@MainActivity, TextFieldPage::class.java
                                        )
                                    )
                                })

                            selectedButton(R.drawable.ic_button, "Selector", Clr7, L_Clr7,
                                tags = listOf(
                                    "SnackBar",
                                    "ProgressBar",
                                    "CheckBox",
                                    "Switch",
                                    "Radio Button",
                                    "Slider",
                                    "Range Slider",
                                ),
                                onIntent = {
                                    startActivity(
                                        Intent(
                                            this@MainActivity, SelectorPage::class.java
                                        )
                                    )
                                })

                            selectedButton(R.drawable.ic_listgrid, "List & Grid", Clr8, L_Clr8,
                                tags = listOf(
                                    "Row",
                                    "Column",
                                    "Box",
                                    "Modifier",
                                    "Arrangement",
                                    "Padding",
                                    "Weight",
                                    "Spacer",
                                ),
                                onIntent = {
                                    startActivity(
                                        Intent(
                                            this@MainActivity, MainListGridPage::class.java
                                        )
                                    )
                                })

                            selectedButton(R.drawable.ic_appbar, "Top AppBar & Tabs", Clr9, L_Clr9,
                                tags = listOf(
                                    "Compose",
                                    "Top AppBar",
                                    "Menu",
                                    "Tab Row",
                                    "Tab",
                                    "Tab Indicator",
                                    "Scrolling Tab",
                                ),
                                onIntent = {
                                    startActivity(
                                        Intent(
                                            this@MainActivity, AppBarTabPage::class.java
                                        )
                                    )
                                })

                            selectedButton(R.drawable.ic_layout,
                                "Bottom AppBar & Navigation",
                                Clr10,
                                L_Clr10,
                                tags = listOf(
                                    "Bottom AppBar",
                                    "Bottom Navigation",
                                    "Bottom Navigation Items",
                                ),
                                onIntent = {
                                    startActivity(
                                        Intent(
                                            this@MainActivity, BottomAppBarNavPage::class.java
                                        )
                                    )
                                })

                            selectedButton(R.drawable.ic_navdrawer,
                                "Navigation Drawer",
                                Clr1,
                                L_Clr1,
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
                                            this@MainActivity, NavDrawerPage::class.java
                                        )
                                    )
                                })

//  -------------------------- EXTRA------------------------------

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

                            selectedButton(R.drawable.ic_layout, "Layout", Clr3, L_Clr3,
                                tags = listOf(
                                    "Row",
                                    "Column",
                                    "Box",
                                    "Modifier",
                                    "Arrangement",
                                    "Padding",
                                    "Weight",
                                    "Spacer",
                                ),
                                onIntent = {
                                    startActivity(
                                        Intent(
                                            this@MainActivity, LayoutPage::class.java
                                        )
                                    )
                                })
                        }
                    }
                )

                val jumpThreshold = with(LocalDensity.current) {
                    56.dp.toPx()
                }

                val jumpToBottomButtonEnabled by remember {
                    derivedStateOf {
                        scrollState.firstVisibleItemIndex != 0 ||
                                scrollState.firstVisibleItemScrollOffset > jumpThreshold
                    }
                }

                val coroutineScope = rememberCoroutineScope()
                JumpToTopButton(
                    enabled = jumpToBottomButtonEnabled,
                    onClicked = {
                        coroutineScope.launch {
                            scrollState.scrollToItem(0)
                        }
                    },
                    modifier = Modifier
                        .align(Alignment.BottomEnd)
                        .navigationBarsPadding()
                )
            }
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
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
            ) {
                Text(
                    text = title,
                    color = Color.Black,
                    fontSize = 16.sp,
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Start,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier
                        .weight(1f)
                )
                Box(
                    modifier = Modifier
                        .padding(horizontal = 10.dp)
                        .size(25.dp)
                        .clip(RoundedCornerShape(10.dp))
                        .background(color = dark_clr)
                        .clickable(
                            indication = null,
                            interactionSource = remember { MutableInteractionSource() } // This is mandatory
                        ) { onIntent() },
                    Alignment.CenterEnd
                ) {
                    Image(
                        painter = painterResource(R.drawable.ic_back),
                        contentDescription = null,
                        colorFilter = ColorFilter.tint(White),
                        modifier = Modifier
                            .padding(7.dp)
                            .rotate(180F)
                    )
                }
            }

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

@Composable
fun AppBarTitleText(modifier: Modifier, text: String) {
    Text(
        text = text,
        color = Color.Black,
        fontFamily = FontFamily.SansSerif,
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Center,
        maxLines = 1,
        modifier = modifier
            .padding(start = 60.dp, end = 10.dp)
    )
}

@Composable
fun TitleText(text: String) {
    Text(
        text = text,
        modifier = Modifier
            .fillMaxWidth(),
        color = Color.Black,
        fontSize = 18.sp,
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Start,
    )
    Spacer(modifier = Modifier.height(8.dp))
}

@Composable
fun NormalTextDescription(text: String) {
    Text(
        text = text,
        color = Color.Black,
        fontSize = 14.sp,
        fontWeight = FontWeight.Normal,
        textAlign = TextAlign.Start,
    )
}

@Composable
fun SmallTextDescription(text: String) {
    Text(
        text = text,
        color = Color.Gray,
        fontSize = 10.sp,
        fontWeight = FontWeight.Light,
        textAlign = TextAlign.Start,
    )
}

@Composable
fun SpaceLine() {
    Spacer(modifier = Modifier.height(10.dp))
    Divider(color = Divider_Clr, thickness = 1.dp)
    Spacer(modifier = Modifier.height(10.dp))
}