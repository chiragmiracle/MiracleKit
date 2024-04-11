package com.miracle.miraclekit.BottomAppBarNav

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.miracle.miraclekit.AppBarTitleText
import com.miracle.miraclekit.R
import com.miracle.miraclekit.selectedButton
import com.miracle.miraclekit.theme.Clr1
import com.miracle.miraclekit.theme.Clr2
import com.miracle.miraclekit.theme.L_Clr1
import com.miracle.miraclekit.theme.L_Clr2
import com.miracle.miraclekit.theme.MiracleTheme

class BottomAppBarNavPage : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MiracleTheme {
                Surface(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(),
                ) {
                    BottomAppBarNavPageUI()
                }
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun BottomAppBarNavPageUI() {
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
                        .fillMaxHeight()
                        .width(55.dp)
                        .padding(15.dp)
                        .clipToBounds()
                        .clickable(indication = null,
                            interactionSource = remember { MutableInteractionSource() }
                        ) {
                            finish()
                        },
                )
                val Mpadding = Modifier.align(Alignment.CenterStart)
                AppBarTitleText(Mpadding, text = "Bottom AppBar & Navigation")
            }

            Column(
                modifier = Modifier
                    .verticalScroll(rememberScrollState())
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .padding(10.dp)
            ) {

                selectedButton(R.drawable.ic_layout, "Bottom AppBar", Clr1, L_Clr1,
                    tags = listOf(
                        "Compose",
                        "Bottom AppBar",
                        "Lazy Column",
                        "Icon Button",
                        "Floating Action Button",
                    ),
                    onIntent = {
                        startActivity(
                            Intent(
                                this@BottomAppBarNavPage, BottomAppBarPage::class.java
                            )
                        )
                    })

                selectedButton(R.drawable.ic_layout, "Bottom Navigation", Clr2, L_Clr2,
                    tags = listOf(
                        "Compose",
                        "Bottom Navigation",
                        "Text Bottom Navigation",
                        "Icon Bottom Navigation",
                        "Text + Icon Bottom Navigation",
                        "Material 3 Bottom Navigation",
                    ),
                    onIntent = {
                        startActivity(
                            Intent(
                                this@BottomAppBarNavPage, BottomNavigationPage::class.java
                            )
                        )
                    })

            }
        }
    }
}