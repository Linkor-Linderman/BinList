package com.example.binlistapp.presentation.card_detail_screen.components

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.LocalTextStyle
import androidx.compose.material.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.OffsetMapping
import androidx.compose.ui.text.input.TransformedText
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign

@Composable
fun BinNumbersTextField(
    modifier: Modifier = Modifier,
    binNumber: MutableState<String>
) {
    val maxChar = 6
    OutlinedTextField(
        modifier = modifier,
        value = binNumber.value,
        onValueChange = {it ->
            if (it.length <= maxChar)
                binNumber.value = it},
        keyboardOptions = KeyboardOptions(keyboardType =
        KeyboardType.Number),
        textStyle = LocalTextStyle.current.copy(textAlign = TextAlign.Center)
    )
}
