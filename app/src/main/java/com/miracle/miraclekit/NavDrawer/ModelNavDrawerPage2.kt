package com.miracle.miraclekit.NavDrawer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material.DrawerValue
import androidx.compose.material.ModalDrawer
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.miracle.miraclekit.theme.L_Clr2
import com.miracle.miraclekit.theme.MiracleTheme
import kotlinx.coroutines.launch

class ModelNavDrawerPage2 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MiracleTheme {
                ModelNavDrawerPage1UI()
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    private fun ModelNavDrawerPage1UI(drawerValue: DrawerValue = DrawerValue.Closed) {
        val drawerState = rememberDrawerState(initialValue = drawerValue)
        val coroutineScope = rememberCoroutineScope()
        val openDrawer: () -> Unit = { coroutineScope.launch { drawerState.open() } }
        val closeDrawer: () -> Unit = { coroutineScope.launch { drawerState.close() } }
        var selectedIndex by remember { mutableStateOf(0) }

        ModalDrawer(
            drawerState = drawerState,
            drawerElevation = 24.dp,
            drawerShape = CutCornerShape(topEnd = 30.dp, bottomEnd = 30.dp),
            drawerContent = {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()
                        .background(L_Clr2)
                ) {
                    ModalDrawerContentHeader()
                    ModelDrawerContentBody(
                        selectedIndex, onSelected = {
                            selectedIndex = it
                        }, closeDrawer = closeDrawer
                    )
                }
            }, content = {
                Scaffold(
                    topBar = {
                        ModalDrawerTopAppBar(openDrawer)
                    }
                ) { contentPadding ->
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(contentPadding),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Column(modifier = Modifier.fillMaxSize()) {
                            UserModalListContent(openDrawer)
                        }
                    }
                }
            })
    }

}