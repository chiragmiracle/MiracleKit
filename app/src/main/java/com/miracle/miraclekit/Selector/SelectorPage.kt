package com.miracle.miraclekit.Selector

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
import com.miracle.miraclekit.theme.Clr3
import com.miracle.miraclekit.theme.Clr4
import com.miracle.miraclekit.theme.Clr5
import com.miracle.miraclekit.theme.Clr6
import com.miracle.miraclekit.theme.L_Clr1
import com.miracle.miraclekit.theme.L_Clr2
import com.miracle.miraclekit.theme.L_Clr3
import com.miracle.miraclekit.theme.L_Clr4
import com.miracle.miraclekit.theme.L_Clr5
import com.miracle.miraclekit.theme.L_Clr6
import com.miracle.miraclekit.theme.MiracleTheme

class SelectorPage : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MiracleTheme {
                Surface {
                    SelectorPageUI()
                }
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun SelectorPageUI() {
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
                AppBarTitleText(Mpadding, text = "Selector")
            }

            Column(
                modifier = Modifier
                    .verticalScroll(rememberScrollState())
                    .fillMaxWidth()
                    .fillMaxHeight()
            ) {

                selectedButton(R.drawable.ic_button, "SnackBar", Clr1, L_Clr1,
                    tags = listOf(
                        "Simple SnackBar",
                        "Action SnackBar",
                        "Action Button New Line",
                        "SnackBar Style",
                        "Custom SnackBar",
                    ),
                    onIntent = {
                        startActivity(
                            Intent(
                                this@SelectorPage, SnackBarPage::class.java
                            )
                        )
                    })

                selectedButton(R.drawable.ic_button, "Progress Indicator", Clr2, L_Clr2,
                    tags = listOf(
                        "Simple Linear Progress",
                        "Custom Linear Progress",
                        "Simple Circular Progress",
                        "Animated Circular Progress",
                        "Custom Circular Progress",
                        "Animated Linear Progress",
                        "Steps ProgressBar",
                        "Animated ProgressBar",
                    ),
                    onIntent = {
                        startActivity(
                            Intent(
                                this@SelectorPage, ProgressIndicatorPage::class.java
                            )
                        )
                    })

                selectedButton(R.drawable.ic_button, "Check Box", Clr3, L_Clr3,
                    tags = listOf(
                        "Simple CheckBox",
                        "Text + CheckBox",
                        "Text + CheckBox + Ripple",
                        "Square CheckBox",
                        "Round CheckBox",
                        "Custom Animated CheckBox",
                        "Multi Selected CheckBox",
                    ),
                    onIntent = {
                        startActivity(
                            Intent(
                                this@SelectorPage, CheckBoxPage::class.java
                            )
                        )
                    })

                selectedButton(R.drawable.ic_button, "Radio Button", Clr4, L_Clr4,
                    tags = listOf(
                        "Simple RadioButton",
                        "Change Color Style",
                        "Selectable Group RadioButton",
                        "Drawable Shape RadioButton",
                        "Custom RadioButton",
                    ),
                    onIntent = {
                        startActivity(
                            Intent(
                                this@SelectorPage, RadioButtonsPage::class.java
                            )
                        )
                    })

                selectedButton(R.drawable.ic_button, "Switch", Clr5, L_Clr5,
                    tags = listOf(
                        "Simple Switch",
                        "Icon Switch",
                        "Change Color Switch",
                        "Custom Switch (Day - night)",
                    ),
                    onIntent = {
                        startActivity(
                            Intent(
                                this@SelectorPage, SwitchPage::class.java
                            )
                        )
                    })

                selectedButton(R.drawable.ic_button, "Toggle Buttons", Clr6, L_Clr6,
                    tags = listOf(
                        "Filled Icon ToggleButton",
                        "Filled Tonal Button",
                        "Filled Tonal Icon Button",
                        "Filled Tonal Icon Toggle Button",
                        "Custom Toggle Button",
                        "Multi Toggle Button",
                        "Like & DisLike Toggle Button",
                    ),
                    onIntent = {
                        startActivity(
                            Intent(
                                this@SelectorPage, ToggleButtonsPage::class.java
                            )
                        )
                    })

            }
        }
    }
}