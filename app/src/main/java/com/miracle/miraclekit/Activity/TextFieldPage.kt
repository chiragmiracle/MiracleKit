package com.miracle.miraclekit.Activity

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
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
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.OffsetMapping
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.TransformedText
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.miracle.miraclekit.NormalTextDescription
import com.miracle.miraclekit.R
import com.miracle.miraclekit.SmallTextDescription
import com.miracle.miraclekit.theme.Clr1
import com.miracle.miraclekit.theme.Clr2
import com.miracle.miraclekit.theme.Clr3
import com.miracle.miraclekit.theme.Clr4
import com.miracle.miraclekit.theme.Clr5
import com.miracle.miraclekit.theme.Clr6
import com.miracle.miraclekit.theme.MiracleTheme

class TextFieldPage : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MiracleTheme {
                Surface(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(),
                ) {
                    TextFieldPageUI()
                }
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun TextFieldPageUI() {
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
                Text(
                    text = "Text Field",
                    color = Color.Black,
                    fontFamily = FontFamily.SansSerif,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.align(alignment = Alignment.Center)
                )
            }

            Column(
                modifier = Modifier
                    .verticalScroll(rememberScrollState())
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .padding(10.dp)
            ) {
                val fullWidthModifier =
                    Modifier
                        .fillMaxWidth()
                        .padding(8.dp)

                NormalTextDescription("➼ TextField let users enter and edit text. remember is used with MutableState to store state of text or TextFieldValue : ")
                Spacer(modifier = Modifier.height(5.dp))
                SmallTextDescription("① Simple TextField : ")
                val textField = remember { mutableStateOf(TextFieldValue("")) }
                TextField(
                    modifier = fullWidthModifier,
                    label = { Text(text = "Label") },
                    placeholder = { Text(text = "Placeholder") },
                    value = textField.value,
                    onValueChange = { newValue ->
                        textField.value = newValue
                    }
                )

                SmallTextDescription("② Error TextField : ")
                val errorText = remember { mutableStateOf(TextFieldValue("Don't blank")) }
                TextField(
                    modifier = fullWidthModifier,
                    label = { Text(text = "Error TextField") },
                    placeholder = { Text(text = "placeholder") },
                    value = errorText.value,
                    onValueChange = { newValue ->
                        errorText.value = newValue
                    },
                    isError = errorText.value.text.isEmpty(),
                )

                SmallTextDescription("③ Background Colors Change : ")
                androidx.compose.material.TextField(
                    modifier = fullWidthModifier,
                    label = { Text(text = "Label") },
                    placeholder = { Text(text = "Placeholder") },
                    value = textField.value,
                    onValueChange = { newValue ->
                        textField.value = newValue
                    },
                    colors = TextFieldDefaults.textFieldColors(
                        backgroundColor = Clr4
                    )
                )

                SmallTextDescription("④ Background Colors & Text Style Change : ")
                androidx.compose.material.TextField(
                    modifier = fullWidthModifier,
                    label = { Text(text = "Label") },
                    placeholder = { Text(text = "Placeholder") },
                    value = textField.value,
                    onValueChange = { newValue ->
                        textField.value = newValue
                    },
                    colors = TextFieldDefaults.textFieldColors(
                        backgroundColor = Clr3,
                        disabledTextColor = Clr3,
                        errorLabelColor = Color.Red,
                        focusedLabelColor = Color.Black,
                        placeholderColor = Color.Black,
                    ),
                    textStyle = TextStyle(
                        color = Color.White,
                        fontStyle = FontStyle.Italic,
                        fontWeight = FontWeight.Bold
                    )
                )

                SmallTextDescription("⑤ TextField Change Background Shape : ")
                androidx.compose.material.Surface(
                    // This sets text color for Text if not set in textFieldColors
                    contentColor = Color.White,
                    color = Clr1,
                    modifier = fullWidthModifier,
                    shape = RoundedCornerShape(topStart = 16.dp, bottomEnd = 16.dp)
                ) {
                    androidx.compose.material.TextField(
                        value = textField.value,
                        onValueChange = { newValue ->
                            textField.value = newValue
                        },
                        placeholder = { androidx.compose.material.Text("Search") },
                        colors = TextFieldDefaults.textFieldColors(
                            // 🔥 Removes bottom indicator line
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent,
                            disabledIndicatorColor = Color.Transparent
                        )
                    )
                }

                androidx.compose.material.TextField(
                    modifier = fullWidthModifier.clip(CutCornerShape(8.dp)),
                    value = textField.value,
                    label = { androidx.compose.material.Text("Label") },
                    placeholder = { androidx.compose.material.Text("No Bottom Line") },
                    onValueChange = { newValue ->
                        textField.value = newValue
                    },
                    colors = TextFieldDefaults.textFieldColors(
                        backgroundColor = Clr5,
                        placeholderColor = Color.Red,
                        unfocusedLabelColor = Color.Yellow,
                        focusedLabelColor = Color.Black,
                        cursorColor = Color.White,
                        // 🔥 Removes bottom indicator line
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        disabledIndicatorColor = Color.Transparent,
                    ),
                    textStyle = TextStyle(
                        color = Color.White
                    )
                )

                SmallTextDescription(text = "⑥ Outlined : ")

                OutlinedTextField(
                    modifier = fullWidthModifier,
                    value = textField.value,
                    label = { androidx.compose.material.Text("Label") },
                    placeholder = { androidx.compose.material.Text("Placeholder") },
                    onValueChange = { newValue ->
                        textField.value = newValue
                    }
                )

                SmallTextDescription(text = "⑦ Remove Label : ")

                OutlinedTextField(
                    modifier = fullWidthModifier,
                    value = textField.value,
                    placeholder = { androidx.compose.material.Text("Placeholder") },
                    onValueChange = { newValue ->
                        textField.value = newValue
                    }
                )

                SmallTextDescription(text = "⑧ Background Color Change : ")

                OutlinedTextField(
                    modifier = fullWidthModifier,
                    value = textField.value,
                    onValueChange = { newValue ->
                        textField.value = newValue
                    },
                    label = { androidx.compose.material.Text("Label") },
                    placeholder = { androidx.compose.material.Text("Placeholder") },

                    colors = TextFieldDefaults.textFieldColors(
                        textColor = Color.Blue,
                        backgroundColor = Color.Yellow,
                        placeholderColor = Clr1,
                        unfocusedLabelColor = Clr2,
                        focusedLabelColor = Clr3,
                        errorLabelColor = Clr4,
                        unfocusedIndicatorColor = Clr5,
                        focusedIndicatorColor = Clr6
                    )
                )

                SmallTextDescription(text = "⑨ Single Line and Line Height : ")

                OutlinedTextField(
                    modifier = fullWidthModifier,
                    value = textField.value,
                    label = { androidx.compose.material.Text("Single Line") },
                    placeholder = { androidx.compose.material.Text("Placeholder") },
                    onValueChange = { newValue ->
                        textField.value = newValue
                    },
                    singleLine = true
                )

                OutlinedTextField(
                    modifier = fullWidthModifier,
                    value = textField.value,
                    label = { androidx.compose.material.Text("Max Lines 2") },
                    placeholder = { androidx.compose.material.Text("Placeholder") },
                    onValueChange = { newValue ->
                        textField.value = newValue
                    },
                    maxLines = 2
                )

                NormalTextDescription("➼ Keyboard options change the type of TextField. For instance PasswordVisual Transformation transforms that TextField to password input area")

                SmallTextDescription("Password Keyboard Options : ")
                OutlinedTextField(
                    modifier = fullWidthModifier,
                    value = textField.value,
                    label = { androidx.compose.material.Text("KeyboardType.Password") },
                    placeholder = { androidx.compose.material.Text(text = "123456789") },
                    onValueChange = { newValue ->
                        textField.value = newValue
                    },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                    visualTransformation = PasswordVisualTransformation()
                )

                SmallTextDescription("Phone Number Keyboard Options : ")
                val phoneNumberText = remember { mutableStateOf(TextFieldValue("")) }
                OutlinedTextField(
                    modifier = fullWidthModifier,
                    value = phoneNumberText.value,
                    label = { androidx.compose.material.Text("KeyboardType.Phone") },
                    placeholder = { androidx.compose.material.Text(text = "555-555-5555") },
                    onValueChange = { newValue ->
                        phoneNumberText.value = newValue
                    },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone)
                )

                NormalTextDescription("➼ TextField can have leading and trailing icons.")
                SmallTextDescription("Leading and Trailing Icons : ")
                val emailText = remember { mutableStateOf(TextFieldValue("")) }
                OutlinedTextField(
                    modifier = fullWidthModifier,
                    value = emailText.value,
                    label = { androidx.compose.material.Text("Email") },
                    placeholder = { androidx.compose.material.Text(text = "") },
                    onValueChange = { newValue ->
                        emailText.value = newValue
                    },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Email,
                            contentDescription = null
                        )
                    }
                )

                var searchQuery by remember { mutableStateOf("") }
                androidx.compose.material.Surface(
                    modifier = fullWidthModifier,
                    shape = RoundedCornerShape(percent = 40),
                    border = BorderStroke(1.dp, Color(0xff90A4AE)),
                ) {
                    androidx.compose.material.TextField(
                        value = searchQuery,
                        placeholder = { androidx.compose.material.Text("Search") },
                        leadingIcon = {
                            if (searchQuery.isEmpty()) {
                                Icon(
                                    imageVector = Icons.Default.Search,
                                    contentDescription = null
                                )
                            }
                        },
                        onValueChange = { newValue ->
                            searchQuery = newValue
                        },
                        colors = TextFieldDefaults.textFieldColors(
                            backgroundColor = Color(0xffF5F5F5),
                            // 🔥 Removes bottom indicator line
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent,
                            disabledIndicatorColor = Color.Transparent,
                        ),
                        singleLine = true,
                    )
                }

                val emailText2 = remember { mutableStateOf(TextFieldValue("")) }

                OutlinedTextField(
                    modifier = fullWidthModifier,
                    value = emailText2.value,
                    label = { androidx.compose.material.Text("Email") },
                    placeholder = { androidx.compose.material.Text(text = "") },
                    onValueChange = { newValue ->
                        emailText2.value = newValue
                    },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Email,
                            contentDescription = null
                        )
                    },
                    trailingIcon = {
                        Icon(
                            imageVector = Icons.Default.Edit,
                            contentDescription = null
                        )
                    }
                )

                NormalTextDescription("➼ Changing IME action changes icon/text at bottom right, action to be performed when that button is clicked")
                SmallTextDescription(text = "IME Icons and Actions :")

                val searchText = remember { mutableStateOf(TextFieldValue("")) }
                OutlinedTextField(
                    modifier = fullWidthModifier,
                    value = searchText.value,
                    label = { androidx.compose.material.Text("Search") },
                    placeholder = { androidx.compose.material.Text(text = "") },
                    onValueChange = { newValue ->
                        searchText.value = newValue
                    },
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(
                        capitalization = KeyboardCapitalization.Words,
                        autoCorrect = true,
                        imeAction = ImeAction.Search
                    )
                )

                val context = LocalContext.current

                val keyboardController = LocalSoftwareKeyboardController.current

                OutlinedTextField(
                    modifier = fullWidthModifier,
                    value = searchText.value,
                    onValueChange = { newValue ->
                        searchText.value = newValue
                    },
                    label = { androidx.compose.material.Text("Search onImeActionPerformed") },
                    placeholder = { androidx.compose.material.Text(text = "") },

                    singleLine = true,
                    keyboardOptions = KeyboardOptions(
                        capitalization = KeyboardCapitalization.Characters,
                        imeAction = ImeAction.Go,
                    ),

                    keyboardActions = KeyboardActions(onGo = {
                        keyboardController?.hide()
                        Toast.makeText(
                            context,
                            "ImeAction performed onGo " +
                                    ", and keyboardController?.hide()",
                            Toast.LENGTH_SHORT
                        ).show()
                    })
                )

                NormalTextDescription("➼ With VisualTransformation and Regex it's possible to transform text based on a format such as masked chars, phone , currency or credit card.")

                val maskText = remember { mutableStateOf(TextFieldValue("")) }
                OutlinedTextField(
                    modifier = fullWidthModifier,
                    value = maskText.value,
                    label = { androidx.compose.material.Text("Mask Chars") },
                    placeholder = { androidx.compose.material.Text(text = "") },
                    onValueChange = { newValue ->
                        maskText.value = newValue
                    },
                    singleLine = true,
                    visualTransformation = PasswordMaskTransformation()
                )


                val phoneText = remember { mutableStateOf(TextFieldValue("")) }
                val maxChar = 10

                OutlinedTextField(
                    modifier = fullWidthModifier,
                    value = phoneText.value,
                    label = { androidx.compose.material.Text("Phone") },
                    placeholder = { androidx.compose.material.Text(text = "") },
                    onValueChange = { newValue ->
                        if (newValue.text.length <= maxChar) phoneText.value = newValue
                    },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
                    maxLines = 1,
                    visualTransformation = PhoneVisualTransformation()
                )

                val creditCardText = remember { mutableStateOf(TextFieldValue("")) }
                val maxCharCreditCard = 16
                // this for entering number only
                val numberRegex = "^[0-9]+\$".toRegex()

                OutlinedTextField(
                    modifier = fullWidthModifier,
                    value = creditCardText.value,
                    label = { androidx.compose.material.Text("Credit Card") },
                    placeholder = { androidx.compose.material.Text(text = "") },
                    onValueChange = { newValue ->
                        val text = newValue.text
                        if (text.length <= maxCharCreditCard && numberRegex.matches(text)) {
                            creditCardText.value = newValue
                        }
                    },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    maxLines = 1,
                    visualTransformation = CreditCardVisualTransformation()
                )

                NormalTextDescription(
                    "➼ Basic composable that enables users to edit text via hardware " +
                            "or software keyboard, but provides no decorations like hint or placeholder."
                )

                androidx.compose.material.Surface(
                    modifier = fullWidthModifier.padding(8.dp),
                    shape = MaterialTheme.shapes.small,
                    color = Color(0xff90A4AE)
                ) {
                    var basicText by remember { mutableStateOf("BasicTextField") }
                    BasicTextField(
                        modifier = Modifier.padding(8.dp),
                        value = basicText,
                        onValueChange = { newValue ->
                            basicText = newValue
                        })

                }
                Spacer(modifier = Modifier.padding(bottom = 32.dp))

            }
        }
    }

}

class PasswordMaskTransformation : VisualTransformation {
    override fun filter(text: AnnotatedString): TransformedText {
        return TransformedText(
            AnnotatedString(text.text.replace(".".toRegex(), "!")),
            maskOffsetMap
        )
    }

    private val maskOffsetMap = object : OffsetMapping {
        override fun originalToTransformed(offset: Int) = offset
        override fun transformedToOriginal(offset: Int) = offset
    }
}

class PhoneVisualTransformation : VisualTransformation {

    override fun filter(text: AnnotatedString): TransformedText {
        val trimmed = if (text.text.length >= 10) text.text.substring(0..9) else text.text

        var output = ""
        for (i in trimmed.indices) {
            output += trimmed[i]
            if (i % 3 == 2 && i != 8) output += "-"
        }

        println("PhoneVisualTransformation text: $text, trimmed: $trimmed, output: $output")


        return TransformedText(AnnotatedString(output), phoneOffsetMap)
    }

    private val phoneOffsetMap = object : OffsetMapping {

        override fun originalToTransformed(offset: Int): Int {

            // XXX
            if (offset <= 2) return offset
            // XXXXXX(5th) is transformed to XXX-XXX
            if (offset <= 5) return offset + 1
            // XXXXXXXXXX(5th to 9th) is transformed to XXX-XXX
            if (offset <= 9) return offset + 2

            // Number of chars in XXX-XXX-XXXX
            return 12
        }

        override fun transformedToOriginal(offset: Int): Int {

            println("🔥 transformedToOriginal() offset: $offset")
            // indexes of -
            // XXX
            if (offset <= 2) return offset
            // XXX-XXX
            if (offset <= 6) return offset - 1
            // XXX-XXX-XXXX
            if (offset <= 11) return offset - 2
            return 10
        }

    }
}

class CreditCardVisualTransformation : VisualTransformation {
    override fun filter(text: AnnotatedString): TransformedText {
        return creditCardFilter(text)
    }
}

fun creditCardFilter(text: AnnotatedString): TransformedText {

    // Making XXXX-XXXX-XXXX-XXXX string.
    val trimmed = if (text.text.length >= 16) text.text.substring(0..15) else text.text
    var out = ""
    for (i in trimmed.indices) {
        out += trimmed[i]
        if (i % 4 == 3 && i < 15) out += "-"
    }

    val creditCardOffsetTranslator = object : OffsetMapping {
        override fun originalToTransformed(offset: Int): Int {
            if (offset <= 3) return offset
            if (offset <= 7) return offset + 1
            if (offset <= 11) return offset + 2
            if (offset <= 16) return offset + 3
            return 19
        }

        override fun transformedToOriginal(offset: Int): Int {
            if (offset <= 4) return offset
            if (offset <= 9) return offset - 1
            if (offset <= 14) return offset - 2
            if (offset <= 19) return offset - 3
            return 16
        }
    }
    return TransformedText(AnnotatedString(out), creditCardOffsetTranslator)
}