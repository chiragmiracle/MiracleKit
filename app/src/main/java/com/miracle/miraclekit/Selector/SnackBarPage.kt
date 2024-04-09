package com.miracle.miraclekit.Selector

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.material3.Button
import androidx.compose.material3.Snackbar
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.miracle.miraclekit.AppBarTitleText
import com.miracle.miraclekit.NormalTextDescription
import com.miracle.miraclekit.R
import com.miracle.miraclekit.SpaceLine
import com.miracle.miraclekit.theme.Clr1
import com.miracle.miraclekit.theme.Clr2
import com.miracle.miraclekit.theme.MiracleTheme

class SnackBarPage : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MiracleTheme {
                Surface(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(),
                ) {
                    AppBarTabPageUI()
                }
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun AppBarTabPageUI() {
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
                AppBarTitleText(Mpadding, text = "SnackBar")
            }

            Column(
                modifier = Modifier
                    .verticalScroll(rememberScrollState())
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .padding(10.dp)
            ) {
                val context = LocalContext.current
                NormalTextDescription("Simple SnackBar : ")
                Spacer(modifier = Modifier.height(7.dp))
                Snackbar(modifier = Modifier.padding(4.dp)) {
                    Text("Simple SnackBar", color = Color.White)
                }
                SpaceLine()

                NormalTextDescription("Action SnackBar : ")
                Spacer(modifier = Modifier.height(7.dp))
                val isInPreview = isInPreview
                Snackbar(modifier = Modifier.padding(4.dp), action = {
                    Text(text = "Action", color = Color.White, modifier = Modifier.clickable {
                        if (!isInPreview) {
                            Toast.makeText(context, "Action is clicked", Toast.LENGTH_SHORT).show()
                        }
                    })
                }) {
                    Text("Action Snackbar", color = Color.White)
                }
                SpaceLine()

                NormalTextDescription("actionOnNewLine SnackBar : ")
                Spacer(modifier = Modifier.height(7.dp))
                Snackbar(modifier = Modifier.padding(4.dp), actionOnNewLine = true, action = {
                    Text(text = "Action",
                        color = Color.Red,
                        modifier = Modifier.clickable {
                            if (!isInPreview) {
                                Toast.makeText(context, "Action is clicked", Toast.LENGTH_SHORT)
                                    .show()
                            }
                        })
                }) {
                    Text("Action on new line Snackbar", color = Color.White)
                }
                SpaceLine()


                NormalTextDescription("SnackBar Style : ")
                Spacer(modifier = Modifier.height(7.dp))
                Snackbar(modifier = Modifier.padding(4.dp),
                    shape = CutCornerShape(topStart = 8.dp),
                    containerColor = Clr1,
                    contentColor = Color.White,
                    action = {
                        Text(text = "Action", modifier = Modifier.clickable {
                            if (!isInPreview) {
                                Toast.makeText(context, "Action is clicked", Toast.LENGTH_SHORT)
                                    .show()
                            }
                        })
                    }) {
                    Text("Snackbar with custom shape and colors")
                }
                Snackbar(modifier = Modifier.padding(4.dp),
                    shape = RoundedCornerShape(topStart = 12.dp, topEnd = 12.dp),
                    containerColor = Clr2,
                    contentColor = Color.White,
                    action = {
                        Text(text = "Action",
                            color = Color.Black,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.clickable {
                                if (!isInPreview) {
                                    Toast.makeText(context, "Action is clicked", Toast.LENGTH_SHORT)
                                        .show()
                                }
                            })
                    }) {
                    Text("SnackBar with custom shape and colors")
                }
                SpaceLine()

                NormalTextDescription("Custom SnackBar : ")
                Spacer(modifier = Modifier.height(7.dp))
                SnackbarDemo()
                SpaceLine()
            }
        }
    }

}

@Composable
fun SnackbarDemo() {
    Column {
        val (snackbarVisibleState, setSnackBarState) = remember { mutableStateOf(false) }
        Button(onClick = { setSnackBarState(!snackbarVisibleState) }) {
            if (snackbarVisibleState) {
                Text("Hide Snackbar", color = Color.White)
            } else {
                Text("Show Snackbar", color = Color.White)
            }
        }
        if (snackbarVisibleState) {
            Snackbar(
                shape = RoundedCornerShape(50.dp),
                containerColor = Clr1,
                contentColor = Color.White,
                action = {
                    Button(onClick = {}) {
                        Text("MyAction", color = Color.White)
                    }
                },
                modifier = Modifier.padding(8.dp)
            ) { Text(text = "This is a snackbar!", color = Color.White) }
        }
    }
}

@Stable
val isInPreview @Composable get() = LocalInspectionMode.current