package com.miracle.miraclekit.ui

import androidx.compose.animation.core.animateDp
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.miracle.miraclekit.theme.Theme_Clr

private enum class Visibility {
    VISIBLE,
    GONE
}

@Composable
fun JumpToTopButton(
    enabled: Boolean,
    onClicked: () -> Unit,
    modifier: Modifier = Modifier
) {
    // Show Jump to Bottom button
    val transition = updateTransition(
        if (enabled) Visibility.VISIBLE else Visibility.GONE,
        label = "jump transition"
    )
    val bottomOffset by transition.animateDp(label = "bottom offset") {
        if (it == Visibility.GONE) {
            (-28).dp
        } else {
            28.dp
        }
    }
    if (bottomOffset > 0.dp) {
        FloatingActionButton(
            elevation = FloatingActionButtonDefaults.elevation(
                defaultElevation = 4.dp,
                pressedElevation = 8.dp
            ),
            containerColor = Theme_Clr,
            modifier = modifier
                .padding(end = 15.dp)
                .size(60.dp)
                .navigationBarsPadding()
                .offset(x = 0.dp, y = -bottomOffset),
            onClick = onClicked
        ) {
            Icon(
                imageVector = Icons.Filled.ArrowBack,
                contentDescription = null,
                tint = Color.White,
                modifier = Modifier.rotate(90F)
            )
        }
    }
}

@Preview
@Composable
fun JumpToBottomPreview() {
    JumpToTopButton(enabled = true, onClicked = {})
}
