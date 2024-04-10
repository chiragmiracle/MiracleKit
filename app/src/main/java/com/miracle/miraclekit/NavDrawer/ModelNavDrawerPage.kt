package com.miracle.miraclekit.NavDrawer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.DrawerValue
import androidx.compose.runtime.Composable
import com.miracle.miraclekit.theme.MiracleTheme

class ModelNavDrawerPage : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MiracleTheme {
                ModelNavDrawerPageUI()
            }
        }
    }

    @Composable
    private fun ModelNavDrawerPageUI(drawerValue: DrawerValue = DrawerValue.Closed) {

    }

}