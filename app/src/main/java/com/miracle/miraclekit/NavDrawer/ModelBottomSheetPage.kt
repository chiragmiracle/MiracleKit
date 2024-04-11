package com.miracle.miraclekit.NavDrawer

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.ListItem
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetState
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.miracle.miraclekit.BottomAppBarNav.userList
import com.miracle.miraclekit.R
import com.miracle.miraclekit.theme.L_Clr1
import com.miracle.miraclekit.theme.MiracleTheme
import kotlinx.coroutines.launch

class ModelBottomSheetPage : ComponentActivity() {
    @OptIn(ExperimentalMaterialApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MiracleTheme {
                ModelBottomSheetPageUI()
            }
        }
    }

    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterialApi::class)
    @Preview(showBackground = true)
    @Composable
    private fun ModelBottomSheetPageUI(initialModalBottomSheetValue: ModalBottomSheetValue = ModalBottomSheetValue.HalfExpanded) {
        val modalBottomSheetState = rememberModalBottomSheetState(
            initialValue = initialModalBottomSheetValue,
            skipHalfExpanded = false,
            confirmValueChange = { _: ModalBottomSheetValue ->
                true
            }
        )
        val coroutineScope = rememberCoroutineScope()

        Scaffold(topBar = {
            TopAppBar(
                backgroundColor = Color.White,
                elevation = 8.dp, title = {
                    Text("Modal BottomSheet")
                },
                actions = {
                    IconButton(onClick = {
                        if (modalBottomSheetState.isVisible) {
                            coroutineScope.launch { modalBottomSheetState.hide() }
                        } else {
                            coroutineScope.launch { modalBottomSheetState.show() }
                        }
                    }) {
                        Icon(imageVector = Icons.Filled.Refresh, contentDescription = null)
                    }
                })
        }) {
            ModalBottomSheetLayout(sheetState = modalBottomSheetState,
                sheetElevation = 8.dp,
                scrimColor = L_Clr1,
                sheetContent = {
                    SheetContent()
                },
                content = {
                    MainContent(modalBottomSheetState)
                }
            )
        }
    }

}

@ExperimentalMaterialApi
@Composable
private fun MainContent(
    modalBottomSheetState: ModalBottomSheetState, color: Color = Color.Black
) {
    val currentValue: ModalBottomSheetValue = modalBottomSheetState.currentValue
    val targetValue: ModalBottomSheetValue = modalBottomSheetState.targetValue

    modalBottomSheetState.isVisible
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color)
            .padding(top = 16.dp)
    ) {
        Text(
            text = "currentValue: ${currentValue}\n" + "targetValue: ${targetValue}\n"
                    + "isExpanded: ${modalBottomSheetState.isVisible}",
            color = Color.Black,
        )
    }
}

@ExperimentalMaterialApi
@Composable
private fun SheetContent() {
    Column {
        LazyColumn {
            items(userList) { item: String ->
                ListItem(icon = {
                    Image(
                        modifier = Modifier
                            .size(40.dp)
                            .clip(CircleShape),
                        painter = painterResource(id = R.drawable.avtar),
                        contentDescription = null
                    )
                }, secondaryText = {
                    Text(text = "Secondary text")
                }) {
                    Text(text = item, fontSize = 18.sp)
                }
            }
        }
    }
}
