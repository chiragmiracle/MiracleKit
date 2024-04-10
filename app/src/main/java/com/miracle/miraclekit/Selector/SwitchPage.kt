package com.miracle.miraclekit.Selector

import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.FractionalThreshold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.rememberSwipeableState
import androidx.compose.material.swipeable
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.miracle.miraclekit.AppBarTitleText
import com.miracle.miraclekit.NormalTextDescription
import com.miracle.miraclekit.R
import com.miracle.miraclekit.SpaceLine
import com.miracle.miraclekit.theme.ColorAccent
import com.miracle.miraclekit.theme.MiracleTheme
import kotlinx.coroutines.launch
import kotlin.math.roundToInt

class SwitchPage : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MiracleTheme {
                EditTextFieldPageUI()
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun EditTextFieldPageUI() {
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
                        AppBarTitleText(Mpadding, text = "Switch")
                    }
                    Column(
                        modifier = Modifier
                            .verticalScroll(rememberScrollState())
                            .fillMaxWidth()
                            .fillMaxHeight()
                            .padding(10.dp),
                    ) {

                        NormalTextDescription("Simple Switch :")
                        SimpleSwitch()
                        SpaceLine()

                        NormalTextDescription("Icon Switch :")
                        IconSwitch()
                        SpaceLine()

                        NormalTextDescription("Change Color Switch :")
                        ChangeColorSwitch()
                        SpaceLine()

                        NormalTextDescription("Custom Switch :")
                        Spacer(modifier = Modifier.height(10.dp))
                        CustomSwitch(
                            height = 40.dp,
                            width = 80.dp,
                            circleButtonPadding = 4.dp,
                            outerBackgroundOnResource = R.drawable.switch_body_night,
                            outerBackgroundOffResource = R.drawable.switch_body_day,
                            circleBackgroundOnResource = R.drawable.switch_btn_moon,
                            circleBackgroundOffResource = R.drawable.switch_btn_sun,
                            stateOn = 1,
                            stateOff = 0,
                            initialValue = 0,
                            onCheckedChanged = {}
                        )
                        SpaceLine()

                    }
                }
            }
        }
    }

    @Composable
    fun SimpleSwitch() {
        var checked by remember { mutableStateOf(true) }
        Switch(
            checked = checked,
            onCheckedChange = {
                checked = it
            }
        )
    }

    @Composable
    fun IconSwitch() {
        var checked by remember { mutableStateOf(true) }
        Switch(
            checked = checked,
            onCheckedChange = {
                checked = it
            },
            thumbContent = if (checked) {
                {
                    Icon(
                        imageVector = Icons.Filled.Check,
                        contentDescription = null,
                        modifier = Modifier.size(SwitchDefaults.IconSize),
                    )
                }
            } else {
                {
                    Icon(
                        imageVector = Icons.Filled.Close,
                        contentDescription = null,
                        modifier = Modifier.size(SwitchDefaults.IconSize),
                    )
                }
            }
        )
    }

    @Composable
    fun ChangeColorSwitch() {
        var checked by remember { mutableStateOf(true) }
        Switch(
            checked = checked,
            onCheckedChange = {
                checked = it
            },
            colors = SwitchDefaults.colors(
                checkedThumbColor = Color.hsl(154f, 0.64f, 0.5f),
                checkedTrackColor = Color.hsl(139f, 0.25f, 0.24f),
                uncheckedThumbColor = Color.hsl(360f, 1.00f, 0.6f),
                uncheckedTrackColor = Color.hsl(360f, 0.25f, 0.3f),
            )
        )
    }

    @OptIn(ExperimentalMaterialApi::class)
    @Composable
    fun CustomSwitch(
        height: Dp,
        width: Dp,
        circleButtonPadding: Dp,
        outerBackgroundOnResource: Int,
        outerBackgroundOffResource: Int,
        circleBackgroundOnResource: Int,
        circleBackgroundOffResource: Int,
        stateOn: Int,
        stateOff: Int,
        initialValue: Int,
        onCheckedChanged: (checked: Boolean) -> Unit
    ) {

        val swipeableState = rememberSwipeableState(
            initialValue = initialValue,
            confirmStateChange = { newState ->
                if (newState == stateOff) {
                    onCheckedChanged(false)
                } else {
                    onCheckedChanged(true)
                }
                true
            }
        )

        val sizePx = with(LocalDensity.current) { (width - height).toPx() }
        val anchors = mapOf(0f to stateOff, sizePx to stateOn) // Maps anchor points (in px) to states

        val scope = rememberCoroutineScope()

        Row(
            modifier = Modifier
                .height(height)
                .width(width)
                .clip(RoundedCornerShape(height))
                .border(1.dp, Color.DarkGray, CircleShape)
                .background(Color.Transparent)
                .then(
                    if (swipeableState.currentValue == stateOff) Modifier.paint(
                        painterResource(id = outerBackgroundOffResource),
                        contentScale = ContentScale.FillBounds
                    ) else Modifier.paint(
                        painterResource(id = outerBackgroundOnResource),
                        contentScale = ContentScale.FillBounds
                    )
                ),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                Modifier
                    .offset { IntOffset(swipeableState.offset.value.roundToInt(), 0) }
                    .swipeable(
                        state = swipeableState,
                        anchors = anchors,
                        thresholds = { _, _ -> FractionalThreshold(0.3f) },
                        orientation = Orientation.Horizontal
                    )
                    .size(height)
                    .padding(circleButtonPadding)
                    .clip(RoundedCornerShape(50))
                    .then(
                        if (swipeableState.currentValue == stateOff) Modifier.paint(
                            painterResource(id = circleBackgroundOffResource),
                            contentScale = ContentScale.FillBounds
                        ) else Modifier.paint(
                            painterResource(id = circleBackgroundOnResource),
                            contentScale = ContentScale.FillBounds
                        )
                    )
                    .clickable {
                        scope.launch {
                            if (swipeableState.currentValue == stateOff) {
                                swipeableState.animateTo(stateOn)
                            } else {
                                swipeableState.animateTo(stateOff)
                            }
                        }
                    }
            )
        }


    }
}