package com.miracle.miraclekit.Selector

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
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.RadioButtonDefaults
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.miracle.miraclekit.AppBarTitleText
import com.miracle.miraclekit.NormalTextDescription
import com.miracle.miraclekit.R
import com.miracle.miraclekit.SpaceLine
import com.miracle.miraclekit.theme.Clr1
import com.miracle.miraclekit.theme.Clr10
import com.miracle.miraclekit.theme.Clr7
import com.miracle.miraclekit.theme.ColorAccent
import com.miracle.miraclekit.theme.MiracleTheme

class RadioButtonsPage : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MiracleTheme {
                Surface {
                    EditTextFieldPageUI()
                }
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun EditTextFieldPageUI() {
        MiracleTheme {
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
                    AppBarTitleText(Mpadding, text = "Radio Button")
                }

                Column(
                    modifier = Modifier
                        .verticalScroll(rememberScrollState())
                        .fillMaxWidth()
                        .fillMaxHeight()
                        .padding(10.dp),
                ) {

                    NormalTextDescription("Simple RadioButton :")
                    SimpleRadioButton()
                    SpaceLine()

                    NormalTextDescription("RadioButton Change Color :")
                    RadioButtonColor()
                    SpaceLine()

                    NormalTextDescription("Group RadioButton :")
                    GroupRadioButton()
                    SpaceLine()

                    NormalTextDescription("Drawable Shape RadioButton :")
                    DrawebleRadioButton()
                    SpaceLine()

                    NormalTextDescription("Custom RadioButton :")
                    CustomRadioGroup()
                    SpaceLine()

                }
            }
        }
    }

    @Composable
    fun SimpleRadioButton() {
        var isRadioSelected by remember { mutableStateOf(true) }
        RadioButton(
            selected = isRadioSelected,
            onClick = { isRadioSelected = !isRadioSelected })
    }

    @Composable
    fun RadioButtonColor() {
        var isRadioSelected by remember { mutableStateOf(true) }
        androidx.compose.material.RadioButton(
            selected = isRadioSelected,
            onClick = { isRadioSelected = !isRadioSelected },
            colors = RadioButtonDefaults.colors(
                selectedColor = Clr1,
                unselectedColor = Clr7,
                disabledColor = Clr7,
            )
        )
    }

    @Composable
    fun GroupRadioButton() {
        val radioOptions = listOf("DSA", "Java", "C++")
        val (selectedOption, onOptionSelected) = remember { mutableStateOf(radioOptions[2]) }
        Column(
            modifier = Modifier
                .fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Column {
                radioOptions.forEach { text ->
                    Row(
                        Modifier
                            .fillMaxWidth()
                            .selectable(
                                selected = (text == selectedOption),
                                onClick = { onOptionSelected(text) }
                            ),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        RadioButton(
                            selected = (text == selectedOption),
                            onClick = {
                                onOptionSelected(text)
                            }
                        )
                        Text(
                            text = text,
                            color = Color.Black
                        )
                    }
                }
            }
        }
    }


    @Composable
    fun DrawebleRadioButton() {
        val radioOptions = listOf("Option 1", "Option 2", "Option 3")
        var selectedOption by remember { mutableStateOf(radioOptions[0]) }

        Column {
            radioOptions.forEach { option ->
                Row(
                    Modifier
                        .clickable { selectedOption = option }
                        .padding(5.dp)
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    if (option == selectedOption) {
                        Image(
                            painter = painterResource(id = R.drawable.ic_circle_checked),
                            contentDescription = "Selected option",
                            modifier = Modifier.size(40.dp),
                        )
                    } else {
                        Image(
                            painter = painterResource(id = R.drawable.ic_circle_outline),
                            contentDescription = "Unselected option",
                            modifier = Modifier.size(40.dp),
                        )
                    }
                    Text(
                        text = option,
                        color = Color.Black,
                        modifier = Modifier.padding(start = 8.dp)
                    )
                }
            }
        }
    }

    @Composable
    fun CustomRadioGroup() {
        val options = listOf(
            "Option 1",
            "Option 2",
            "Option 3",
            "Option 4",
        )
        var selectedOption by remember {
            mutableStateOf("")
        }
        val onSelectionChange = { text: String ->
            selectedOption = text
        }

        Column(
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize(),
        ) {
            options.forEach { text ->
                Row(
                    modifier = Modifier
                        .padding(
                            all = 8.dp,
                        ),
                ) {
                    Text(
                        text = text,
                        style = typography.bodyMedium.merge(),
                        color = Color.White,
                        modifier = Modifier
                            .clip(
                                shape = RoundedCornerShape(
                                    size = 12.dp,
                                ),
                            )
                            .clickable {
                                onSelectionChange(text)
                            }
                            .background(
                                if (text == selectedOption) {
                                    ColorAccent
                                } else {
                                    Color.LightGray
                                }
                            )
                            .padding(
                                vertical = 12.dp,
                                horizontal = 16.dp,
                            ),
                    )
                }
            }
        }
    }

}
