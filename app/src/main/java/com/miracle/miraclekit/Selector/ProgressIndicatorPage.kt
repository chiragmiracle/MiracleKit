package com.miracle.miraclekit.Selector

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
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
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.OutlinedButton
import androidx.compose.material.ProgressIndicatorDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.drawText
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.rememberTextMeasurer
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.miracle.miraclekit.AppBarTitleText
import com.miracle.miraclekit.NormalTextDescription
import com.miracle.miraclekit.R
import com.miracle.miraclekit.SpaceLine
import com.miracle.miraclekit.theme.MiracleTheme

class ProgressIndicatorPage : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MiracleTheme {
                ProgressIndicatorPageUI()
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun ProgressIndicatorPageUI() {
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
                        AppBarTitleText(Mpadding, text = "Progress Indicator")
                    }

                    Column(
                        modifier = Modifier
                            .verticalScroll(rememberScrollState())
                            .fillMaxWidth()
                            .fillMaxHeight()
                            .padding(10.dp),
                    ) {

                        NormalTextDescription("Simple Linear Progress : ")
                        Spacer(modifier = Modifier.height(10.dp))
                        LinearProgressIndicator()
                        Spacer(modifier = Modifier.height(10.dp))
                        LinearProgressIndicator(progress = 0.7f) //70% progress
                        SpaceLine()

                        NormalTextDescription("Custom Linear Progress : ")
                        Spacer(modifier = Modifier.height(10.dp))
                        CustomLinearProgressBar()
                        SpaceLine()

                        NormalTextDescription("Simple Circular Progress : ")
                        Spacer(modifier = Modifier.height(10.dp))
                        CircularProgressIndicator()
                        Spacer(modifier = Modifier.height(10.dp))
                        CircularProgressIndicator(progress = 0.75f) //75% progress
                        SpaceLine()

                        NormalTextDescription("Animated Circular Progress : ")
                        Spacer(modifier = Modifier.height(10.dp))
                        CircularProgressAnimated()
                        SpaceLine()

                        NormalTextDescription("Custom Circular Progress : ")
                        Spacer(modifier = Modifier.height(10.dp))
                        CustomCircularProgressBar()
                        SpaceLine()

                        NormalTextDescription("Animated Linear Progress : ")
                        Spacer(modifier = Modifier.height(10.dp))
                        AnimatedProgressBar(80)
                        SpaceLine()

                        NormalTextDescription("Steps ProgressBar : ")
                        Spacer(modifier = Modifier.height(10.dp))
                        val currentStep = remember { mutableStateOf(1) }
                        StepsProgressBar(
                            modifier = Modifier.fillMaxWidth(),
                            numberOfSteps = 5,
                            currentStep = currentStep.value
                        )
                        SpaceLine()

                        NormalTextDescription("Animated ProgressBar : ")
                        Spacer(modifier = Modifier.height(10.dp))
                        AnimatedProgress()
                        SpaceLine()

                    }
                }
            }
        }
    }

    @Composable
    fun AnimatedProgress() {
        var progressAnimated by remember { mutableStateOf(0.1f) }
        val animatedProgress by animateFloatAsState(
            targetValue = progressAnimated,
            animationSpec = ProgressIndicatorDefaults.ProgressAnimationSpec
        )
        Row(verticalAlignment = Alignment.CenterVertically) {
            OutlinedButton(
                onClick = {
                    if (progressAnimated < 1f) progressAnimated += 0.1f
                }
            ) {
                androidx.compose.material.Text("Increase")
            }
            Spacer(Modifier.requiredWidth(30.dp))
            androidx.compose.material.LinearProgressIndicator(progress = animatedProgress)
        }
    }

    @Composable
    fun StepsProgressBar(modifier: Modifier = Modifier, numberOfSteps: Int, currentStep: Int) {
        Row(
            modifier = modifier.padding(horizontal = 15.dp, vertical = 5.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            for (step in 0..numberOfSteps) {
                Step(
                    modifier = Modifier.weight(1F),
                    isCompete = step < currentStep,
                    isCurrent = step == currentStep
                )
            }
        }
    }

    @Composable
    fun Step(modifier: Modifier = Modifier, isCompete: Boolean, isCurrent: Boolean) {
        val color = if (isCompete || isCurrent) Color.Red else Color.LightGray
        val innerCircleColor = if (isCompete) Color.Red else Color.LightGray

        Box(modifier = modifier) {
            //Line
            Divider(
                modifier = Modifier.align(Alignment.CenterStart), color = color, thickness = 2.dp
            )

            //Circle
            Canvas(modifier = Modifier
                .size(15.dp)
                .align(Alignment.CenterEnd)
                .border(
                    shape = CircleShape, width = 2.dp, color = color
                ), onDraw = {
                drawCircle(color = innerCircleColor)
            })
        }
    }

    @Composable
    private fun CustomLinearProgressBar() {
        Column(modifier = Modifier.fillMaxWidth()) {
            LinearProgressIndicator(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(20.dp)
                    .padding(horizontal = 15.dp, vertical = 5.dp),
                trackColor = Color.LightGray,
                color = Color.Red
            )
        }
    }

    @Composable
    private fun CircularProgressAnimated() {
        val progressValue = 0.75f
        val infiniteTransition = rememberInfiniteTransition()

        val progressAnimationValue by infiniteTransition.animateFloat(
            initialValue = 0.0f,
            targetValue = progressValue,
            animationSpec = infiniteRepeatable(animation = tween(900))
        )

        CircularProgressIndicator(
            progress = progressAnimationValue,
            trackColor = Color.LightGray,
        )
    }

    @Composable
    private fun CustomCircularProgressBar() {
        CircularProgressIndicator(
            modifier = Modifier.size(80.dp),
            color = Color.Red,
            trackColor = Color.LightGray,
            strokeWidth = 10.dp
        )
    }


    @Composable
    fun AnimatedProgressBar(indicatorProgress: Int) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(40.dp)
                .padding(horizontal = 15.dp, vertical = 5.dp),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Center
        ) {
            Spacer(modifier = Modifier.height(8.dp))
            ACustomProgressBar(indicatorNumber = indicatorProgress)
        }
    }

    @Composable
    fun ACustomProgressBar(
        indicatorNumber: Int,
        backgroundIndicatorColor: Color = MaterialTheme.colorScheme.primary.copy(alpha = 0.3f),
        indicatorPadding: Dp = 8.dp,
        gradientColors: List<Color> = listOf(
            MaterialTheme.colorScheme.primary,
            MaterialTheme.colorScheme.secondary,
        ),
        animationDuration: Int = 1000,
        animationDelay: Int = 0
    ) {
        // Remember the text measurer to optimize text measurement performance.
        val textMeasurer = rememberTextMeasurer()

        // State to animate the progress indicator.
        var percentage by remember {
            mutableFloatStateOf(-1f)
        }

        // Animate the progress number.
        val animateNumber = animateFloatAsState(
            targetValue = percentage, animationSpec = tween(
                durationMillis = animationDuration, delayMillis = animationDelay
            ), label = ""
        )

        // Trigger the LaunchedEffect to start the animation when the composable is first launched.
        LaunchedEffect(Unit) {
            percentage = indicatorNumber.toFloat()
        }

        // Composable Box to contain the Canvas drawing and text.
        Box(
            modifier = Modifier
                .height(300.dp)
                .fillMaxWidth()
        ) {
            // Canvas drawing for the progress indicator.
            Canvas(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp)
                    .padding(start = indicatorPadding, end = indicatorPadding)
            ) {
                // Draw the background indicator.
                drawLine(
                    color = backgroundIndicatorColor,
                    cap = StrokeCap.Round,
                    strokeWidth = size.height,
                    start = Offset(x = 0f, y = 0f),
                    end = Offset(x = size.width, y = 0f)
                )

                // Calculate and draw the progress indicator.
                val progress = (animateNumber.value / 100) * size.width
                drawLine(
                    brush = Brush.linearGradient(colors = gradientColors),
                    cap = StrokeCap.Round,
                    strokeWidth = size.height,
                    start = Offset(x = 0f, y = 0f),
                    end = Offset(x = progress, y = 0f)
                )

                // Draw the progress number in the middle.
                val text = "$indicatorNumber%"
                val textSize = textMeasurer.measure(text = AnnotatedString(text))
                val textWidth = textSize.size.width
                val xOffSet = ((size.width - textWidth) / 2)
                val yOffSet = size.height / 10 - (textSize.size.height / 2)
                drawText(
                    textMeasurer = textMeasurer, text = text, style = TextStyle(
                        color = Color.White,
                        fontSize = (size.height / 2).toSp(),
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Bold
                    ), topLeft = Offset(x = xOffSet, y = yOffSet)
                )
            }
        }
    }

    @Composable
    private fun createStripeBrush(
        stripeColor: Color, stripeBg: Color, stripeWidth: Dp
    ): Brush {
        val stripeWidthPx = with(LocalDensity.current) { stripeWidth.toPx() }
        val brushSizePx = 2 * stripeWidthPx
        val stripeStart = stripeWidthPx / brushSizePx

        return Brush.linearGradient(
            stripeStart to stripeBg,
            stripeStart to stripeColor,
            start = Offset(0f, 0f),
            end = Offset(brushSizePx, brushSizePx),
            tileMode = TileMode.Repeated
        )
    }


}