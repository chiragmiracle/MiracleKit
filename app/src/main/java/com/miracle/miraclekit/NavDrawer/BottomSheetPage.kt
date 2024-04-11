package com.miracle.miraclekit.NavDrawer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomSheetScaffold
import androidx.compose.material.BottomSheetState
import androidx.compose.material.BottomSheetValue
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.FabPosition
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
import androidx.compose.material.rememberBottomSheetScaffoldState
import androidx.compose.material.rememberBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.miracle.miraclekit.Model.places
import com.miracle.miraclekit.Selector.isInPreview
import com.miracle.miraclekit.theme.Clr1
import com.miracle.miraclekit.theme.L_Clr1
import com.miracle.miraclekit.theme.MiracleTheme
import com.miracle.miraclekit.ui.PlacesToBookVerticalComponent
import kotlinx.coroutines.launch

class BottomSheetPage : ComponentActivity() {
    @OptIn(ExperimentalMaterialApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MiracleTheme {
                BottomSheetPageUI()
            }
        }
    }

    @OptIn(ExperimentalMaterialApi::class)
    @Preview(showBackground = true)
    @Composable
    private fun BottomSheetPageUI(initialState: BottomSheetValue = BottomSheetValue.Collapsed) {
        val context = LocalContext.current
        val isInPreview = isInPreview

        val bottomSheetScaffoldState = rememberBottomSheetScaffoldState(
            bottomSheetState = rememberBottomSheetState(
                initialValue = initialState,
                confirmStateChange = { bottomSheetValue: BottomSheetValue ->
                    // This callback gets called twice in Jetpack Compose version 1.5.4
                    println("State changed to $bottomSheetValue")
//                    if (!isInPreview) {
//                        Toast.makeText(
//                            context,
//                            "State changed to $bottomSheetValue",
//                            Toast.LENGTH_SHORT
//                        ).show()
//                    }
                    true
                }
            )
        )

        BottomSheetScaffold(
            scaffoldState = bottomSheetScaffoldState,
            sheetElevation = 8.dp,
            sheetShape = RoundedCornerShape(
                bottomStart = 0.dp,
                bottomEnd = 0.dp,
                topStart = 12.dp,
                topEnd = 12.dp
            ),
            sheetGesturesEnabled = true,
            sheetContent = {
                SheetContent()
            },
            // This is the height in collapsed state
            sheetPeekHeight = 70.dp,
            floatingActionButton = {
                FloatingActionButtonComponent(bottomSheetScaffoldState.bottomSheetState)
            },
            floatingActionButtonPosition = FabPosition.End
        ) {
            MainContent(bottomSheetScaffoldState.bottomSheetState)
        }
    }

}

@ExperimentalMaterialApi
@Composable
private fun MainContent(bottomSheetState: BottomSheetState) {
    val currentValue: BottomSheetValue = bottomSheetState.currentValue
    val offset = try {
        bottomSheetState.requireOffset()
    } catch (e: Exception) {
        Offset.Zero
    }

    val progress = bottomSheetState.progress

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(L_Clr1)
            .padding(top = 30.dp, start = 15.dp)
    ) {
        Text(
            color = Color.Black,
            text = "isExpanded: ${bottomSheetState.isExpanded}\n" +
                    "isCollapsed: ${bottomSheetState.isCollapsed}"
        )

        Text(
            color = Color.Black,
            text = "currentValue: ${currentValue}\n" +
                    "offset: $offset"
        )

        Text(
            color = Color.Black,
            text = "progress: $progress"
        )
    }
}

@ExperimentalMaterialApi
@Composable
private fun FloatingActionButtonComponent(
    bottomSheetState: BottomSheetState
) {
    val coroutineScope = rememberCoroutineScope()
    val iconRotation by animateFloatAsState(
        targetValue = if (bottomSheetState.isCollapsed) -90f else 90f,
        label = "Icon Rotation Anim",
        animationSpec = tween()
    )

    FloatingActionButton(
        onClick = {
            coroutineScope.launch {
                if (bottomSheetState.isCollapsed) {
                    bottomSheetState.expand()
                } else {
                    bottomSheetState.collapse()
                }
            }
        },
        backgroundColor = Clr1
    ) {
        Icon(
            imageVector = Icons.Default.Send,
            tint = Color.White,
            contentDescription = "Icon Rotation",
            modifier = Modifier.graphicsLayer { this.rotationZ = iconRotation }
        )
    }
}

@Composable
private fun SheetContent() {
    Column(
        modifier = Modifier
            .heightIn(min = 300.dp, max = 500.dp)
    ) {
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Places to Visit",
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
            color = Clr1,
            fontSize = 24.sp,
            modifier = Modifier.padding(8.dp)
        )
        LazyColumn(
            contentPadding = PaddingValues(10.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            items(places) { place ->
                PlacesToBookVerticalComponent(place = place)
            }
        }
    }
}