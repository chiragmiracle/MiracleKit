package com.miracle.miraclekit.Selector

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandHorizontally
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
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
import androidx.compose.foundation.selection.toggleable
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TriStateCheckbox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.miracle.miraclekit.AppBarTitleText
import com.miracle.miraclekit.NormalTextDescription
import com.miracle.miraclekit.R
import com.miracle.miraclekit.SpaceLine
import com.miracle.miraclekit.theme.Clr1
import com.miracle.miraclekit.theme.MiracleTheme

class CheckBoxPage : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MiracleTheme {
                CheckBoxPageUI()
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun CheckBoxPageUI() {
        MiracleTheme {
            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(),
            ) {
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
                        AppBarTitleText(Mpadding, text = "Check Box")
                    }

                    Column(
                        modifier = Modifier
                            .verticalScroll(rememberScrollState())
                            .fillMaxWidth()
                            .fillMaxHeight()
                            .padding(10.dp),
                    ) {

                        NormalTextDescription("Simple CheckBox : ")
                        Spacer(modifier = Modifier.height(10.dp))
                        SimpleCheckbox()
                        SpaceLine()

                        NormalTextDescription("Checkbox with Text : ")
                        Spacer(modifier = Modifier.height(10.dp))
                        var checkBoxState2 by remember { mutableStateOf(false) }
                        TextCheckbox("Text + CheckBox", checkBoxState2) {
                            checkBoxState2 = it
                        }
                        SpaceLine()

                        NormalTextDescription("Checkbox with Text and ripple : ")
                        Spacer(modifier = Modifier.height(10.dp))
                        var checkBoxState3 by remember { mutableStateOf(false) }
                        TextCheckboxRipple("Text + CheckBox + Ripple", checkBoxState3) {
                            checkBoxState3 = it
                        }
                        SpaceLine()

                        NormalTextDescription("Square CheckBox : ")
                        Spacer(modifier = Modifier.height(10.dp))
                        SquareCheckbox()
                        SpaceLine()

                        NormalTextDescription("Round CheckBox : ")
                        Spacer(modifier = Modifier.height(10.dp))
                        RoundedCheckView()
                        SpaceLine()

                        NormalTextDescription("Custom CheckBox : ")
                        Spacer(modifier = Modifier.height(10.dp))
                        var checked by remember { mutableStateOf(false) }
                        CustomCheckbox(
                            checked = checked,
                            onCheckedChange = { checked = it }
                        )
                        SpaceLine()

                        NormalTextDescription("Multi Selected CheckBox : ")
                        Spacer(modifier = Modifier.height(10.dp))
                        MultiCheckboxes()
                        SpaceLine()
                    }
                }
            }
        }
    }

    @Composable
    fun SimpleCheckbox() {
        val checkedState = remember { mutableStateOf(true) }
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Checkbox(
                checked = checkedState.value,
                onCheckedChange = { checkedState.value = it },
            )
            Text(text = "Checkbox Example")
        }
    }

    @Composable
    fun CustomCheckbox(
        checked: Boolean,
        onCheckedChange: (Boolean) -> Unit
    ) {
        IconButton(onClick = { onCheckedChange(!checked) }) {
            Image(
                painter = painterResource(id = R.drawable.checkbox_off_icon),
                contentDescription = "Unchecked",
                modifier = Modifier
                    .size(30.dp)
            )
            AnimatedVisibility(
                visible = checked,
                exit = shrinkOut(shrinkTowards = Alignment.TopStart) + fadeOut()
            ) {
                Image(
                    painter = painterResource(id = R.drawable.checkbox_on_icon),
                    contentDescription = "Checked",
                    modifier = Modifier
                        .size(30.dp)
                )
            }
        }
    }


    @Composable
    fun SquareCheckbox() {
        var isChecked by remember { mutableStateOf(false) }
        val checkboxColor: Color by animateColorAsState(if (isChecked) Color.Blue else Color.White)
        val density = LocalDensity.current
        val duration = 200
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(12.dp)
                .toggleable(
                    value = isChecked,
                    role = Role.Checkbox,
                    onValueChange = { isChecked = it }
                )
        ) {
            Box(
                modifier = Modifier
                    .size(24.dp)
                    .background(color = checkboxColor, shape = RoundedCornerShape(4.dp))
                    .border(width = 1.5.dp, color = Color.Blue, shape = RoundedCornerShape(4.dp)),
                contentAlignment = Alignment.Center
            ) {
                androidx.compose.animation.AnimatedVisibility(
                    visible = isChecked,
                    enter = slideInHorizontally(animationSpec = tween(duration)) {
                        with(density) { (24f * -0.5).dp.roundToPx() }
                    } + expandHorizontally(
                        expandFrom = Alignment.Start,
                        animationSpec = tween(duration)
                    ),
                    exit = fadeOut()
                ) {
                    Icon(
                        Icons.Default.Check,
                        contentDescription = null,
                        tint = Color.White
                    )
                }
            }
            Text(
                modifier = Modifier.padding(start = 8.dp),
                text = "Checkbox label", color = Color.Black,
            )
        }
    }

    @Composable
    fun RoundedCheckView() {
        val isChecked = remember { mutableStateOf(false) }
        val checkedText = remember { mutableStateOf("False") }
        val circleSize = remember { mutableStateOf(25.dp) }
        val circleThickness = remember { mutableStateOf(1.dp) }
        val color = remember { mutableStateOf(Color.Gray) }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(horizontal = 10.dp)
                .toggleable(value = isChecked.value, role = Role.Checkbox) {
                    isChecked.value = it
                    if (isChecked.value) {
                        checkedText.value = "True"
                        circleSize.value = 25.dp
                        circleThickness.value = 1.dp
                        color.value = Clr1
                    } else {
                        checkedText.value = "False"
                        circleSize.value = 25.dp
                        circleThickness.value = 1.dp
                        color.value = Color.Gray
                    }
                }) {
            Box(
                modifier = Modifier
                    .clip(CircleShape)
                    .size(circleSize.value)
                    .background(color.value)
                    .padding(circleThickness.value)
                    .clip(CircleShape)
                    .background(Color.White),
                contentAlignment = Alignment.Center
            ) {
                if (isChecked.value) {
                    Icon(
                        imageVector = Icons.Default.Check,
                        contentDescription = "",
                        tint = Color.White,
                        modifier = Modifier
                            .background(
                                color = if (isChecked.value) Clr1 else Color.Gray,
                                shape = CircleShape
                            )
                    )
                }
            }
            Spacer(modifier = Modifier.width(10.dp))
            Text(
                text = checkedText.value,
                color = color.value,
                fontSize = 20.sp,
                fontWeight = FontWeight.Medium,
                modifier = Modifier.padding(start = 5.dp)
            )
        }
    }


    @Composable
    fun MultiCheckboxes() {
        val checkboxes = remember {
            mutableStateListOf(
                CheckboxInfo(
                    isChecked = false,
                    text = "Checkbox1"
                ),
                CheckboxInfo(
                    isChecked = false,
                    text = "Checkbox2"
                ),
                CheckboxInfo(
                    isChecked = false,
                    text = "Checkbox3"
                )
            )
        }

        var isCheckedCount = 0

        var triState by remember {
            mutableStateOf(ToggleableState.Off)
        }

        val toggleTriState = {
            triState = when (triState) {
                ToggleableState.Indeterminate -> ToggleableState.On
                ToggleableState.On -> ToggleableState.Off
                ToggleableState.Off -> ToggleableState.On
            }

            checkboxes.indices.forEach { index ->
                checkboxes[index] = checkboxes[index].copy(
                    isChecked = triState == ToggleableState.On
                )
            }
        }

        val parentCheckboxInteractionSource = remember {
            MutableInteractionSource()
        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .clickable(
                    indication = null,
                    onClick = toggleTriState,
                    interactionSource = parentCheckboxInteractionSource
                )
        ) {
            TriStateCheckbox(
                state = triState,
                onClick = toggleTriState,
                interactionSource = parentCheckboxInteractionSource
            )

            Text(text = "ParentCheckbox", color = Color.Black)

        }

        checkboxes.forEachIndexed { index, info ->

            val onCheckChangeFun = {
                checkboxes[index] = info.copy(
                    isChecked = !info.isChecked
                )
            }

            if (info.isChecked) {
                isCheckedCount++
            }

            val childCheckboxInteractionSource = remember {
                MutableInteractionSource()
            }

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(start = 32.dp)
                    .clickable(
                        indication = null,
                        onClick = onCheckChangeFun,
                        interactionSource = childCheckboxInteractionSource
                    )
            ) {
                Checkbox(
                    checked = info.isChecked,
                    onCheckedChange = { isChecked ->
                        onCheckChangeFun()
                    },
                    interactionSource = childCheckboxInteractionSource
                )
                Text(text = info.text, color = Color.Black)

            }

        }

        if (checkboxes.all { it.isChecked }) {
            triState = ToggleableState.On
        } else if (checkboxes.all { !it.isChecked }) {
            triState = ToggleableState.Off
        } else if (checkboxes.any { it.isChecked }) {
            triState = ToggleableState.Indeterminate
        }

    }
}

@Composable
fun TextCheckboxRipple(
    label: String,
    state: Boolean,
    onStateChange: (Boolean) -> Unit
) {
    // Checkbox with text on right side
    Row(modifier = Modifier
        .fillMaxWidth()
        .height(40.dp)
        .clickable(
            role = Role.Checkbox,
            onClick = {
                onStateChange(!state)
            }
        )
        .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(
            checked = state,
            onCheckedChange = null
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = label, color = Color.Black)
    }
}

@Composable
fun TextCheckbox(label: String, state: Boolean, onStateChange: (Boolean) -> Unit) {
    // Checkbox with text on right side
    val interactionSource = remember { MutableInteractionSource() }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(40.dp)
            .clickable(
                interactionSource = interactionSource,
                // This is for removing ripple when Row is clicked
                indication = null,
                role = Role.Checkbox,
                onClick = {
                    onStateChange(!state)
                }
            )
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically

    ) {
        Checkbox(
            checked = state,
            onCheckedChange = null
        )
        Spacer(modifier = Modifier.padding(start = 8.dp))
        Text(text = label, color = Color.Black)
    }
}


data class CheckboxInfo(
    val isChecked: Boolean,
    val text: String
)