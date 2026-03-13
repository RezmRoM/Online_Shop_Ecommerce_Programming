package com.example.matule.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.matule.ui.theme.Background
import com.example.matule.ui.theme.Block
import com.example.matule.ui.theme.Red
import com.example.matule.ui.theme.SubTextDark
import com.example.matule.ui.theme.Text
import com.example.matule.ui.theme.fontFamily
import com.example.matule.utils.AppIcons

/** Автор: Шадрин Роман Алексеевич
 *
 * Дата создания: 27.02.2025
 *
 * Функция отвечает за отрисовку активности Verification
 * **/
@Composable
fun Verification(
    modifier: Modifier = Modifier,
    onPrev: () -> Unit,
    onHome: () -> Unit,
) {
    var first by rememberSaveable { mutableStateOf("") }
    var firstError by rememberSaveable { mutableStateOf(false) }

    var second by rememberSaveable { mutableStateOf("") }
    var secondError by rememberSaveable { mutableStateOf(false) }

    var third by rememberSaveable { mutableStateOf("") }
    var thirdError by rememberSaveable { mutableStateOf(false) }

    var fourth by rememberSaveable { mutableStateOf("") }
    var fourthError by rememberSaveable { mutableStateOf(false) }

    var fiveth by rememberSaveable { mutableStateOf("") }
    var fivethError by rememberSaveable { mutableStateOf(false) }

    var sixth by rememberSaveable { mutableStateOf("") }
    var sixthError by rememberSaveable { mutableStateOf(false) }

    Scaffold { paddingValues ->
        if (first.isNotEmpty() and
            second.isNotEmpty() and
            third.isNotEmpty() and
            fourth.isNotEmpty() and
            fiveth.isNotEmpty() and
            sixth.isNotEmpty()
        ) {
            onHome()
        }
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            Column(
                modifier = modifier
                    .fillMaxSize()
                    .background(Block)
                    .padding(horizontal = 20.dp)
                    .padding(paddingValues)
                    .verticalScroll(rememberScrollState()),
            ) {
                Spacer(modifier = modifier.height(16.dp))
                Box(
                    modifier = modifier
                        .size(44.dp)
                        .background(Background, CircleShape)
                        .clip(CircleShape)
                        .clickable { onPrev() },
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = AppIcons.ChevronLeft(),
                        contentDescription = null
                    )
                }
                Spacer(modifier = modifier.height(16.dp))
                Text(
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    text = "OTP Проверка",
                    textAlign = TextAlign.Center,
                    fontFamily = fontFamily,
                    lineHeight = 32.sp,
                    fontSize = 32.sp,
                    color = Text
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    textAlign = TextAlign.Center,
                    text = "Пожалуйста, Проверьте Свою\n" +
                            "Электронную Почту, Чтобы Увидеть Код\n" +
                            "Подтверждения",
                    fontFamily = fontFamily,
                    color = SubTextDark,
                    letterSpacing = 0.sp,
                    lineHeight = 24.sp,
                    fontSize = 16.sp
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    modifier = Modifier.align(Alignment.Start),
                    textAlign = TextAlign.Center,
                    text = "OTP Код",
                    fontFamily = fontFamily,
                    color = Text,
                    letterSpacing = 0.sp,
                    lineHeight = 21.sp,
                    fontSize = 21.sp
                )
                Spacer(modifier = Modifier.height(20.dp))
                Row(
                    modifier = modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    OutlinedTextField(
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                        modifier = Modifier.size(46.dp, 99.dp),
                        shape = RoundedCornerShape(15.dp),
                        onValueChange = { first = it },
                        colors = OutlinedTextFieldDefaults.colors(
                            unfocusedContainerColor = Background,
                            focusedContainerColor = Background,
                            unfocusedBorderColor = if (firstError) Red else Background,
                            focusedBorderColor = if (firstError) Red else Background
                        ),
                        singleLine = true,
                        value = first
                    )
                    OutlinedTextField(
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                        modifier = Modifier.size(46.dp, 99.dp),
                        shape = RoundedCornerShape(15.dp),
                        onValueChange = { second = it },
                        colors = OutlinedTextFieldDefaults.colors(
                            unfocusedContainerColor = Background,
                            focusedContainerColor = Background,
                            unfocusedBorderColor = if (secondError) Red else Background,
                            focusedBorderColor = if (secondError) Red else Background
                        ),
                        singleLine = true,
                        value = second
                    )
                    OutlinedTextField(
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                        modifier = Modifier.size(46.dp, 99.dp),
                        shape = RoundedCornerShape(15.dp),
                        onValueChange = { third = it },
                        colors = OutlinedTextFieldDefaults.colors(
                            unfocusedContainerColor = Background,
                            focusedContainerColor = Background,
                            unfocusedBorderColor = if (thirdError) Red else Background,
                            focusedBorderColor = if (thirdError) Red else Background
                        ),
                        singleLine = true,
                        value = third
                    )
                    OutlinedTextField(
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                        modifier = Modifier.size(46.dp, 99.dp),
                        shape = RoundedCornerShape(15.dp),
                        onValueChange = { fourth = it },
                        colors = OutlinedTextFieldDefaults.colors(
                            unfocusedContainerColor = Background,
                            focusedContainerColor = Background,
                            unfocusedBorderColor = if (fourthError) Red else Background,
                            focusedBorderColor = if (fourthError) Red else Background
                        ),
                        singleLine = true,
                        value = fourth
                    )
                    OutlinedTextField(
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                        modifier = Modifier.size(46.dp, 99.dp),
                        shape = RoundedCornerShape(15.dp),
                        onValueChange = { fiveth = it },
                        colors = OutlinedTextFieldDefaults.colors(
                            unfocusedContainerColor = Background,
                            focusedContainerColor = Background,
                            unfocusedBorderColor = if (fivethError) Red else Background,
                            focusedBorderColor = if (fivethError) Red else Background
                        ),
                        singleLine = true,
                        value = fiveth
                    )
                    OutlinedTextField(
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                        modifier = Modifier.size(46.dp, 99.dp),
                        shape = RoundedCornerShape(15.dp),
                        onValueChange = { sixth = it },
                        colors = OutlinedTextFieldDefaults.colors(
                            unfocusedContainerColor = Background,
                            focusedContainerColor = Background,
                            unfocusedBorderColor = if (sixthError) Red else Background,
                            focusedBorderColor = if (sixthError) Red else Background
                        ),
                        singleLine = true,
                        value = sixth
                    )
                }
                Spacer(modifier = Modifier.height(20.dp))
                Row(
                    modifier = modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        textAlign = TextAlign.Center,
                        text = "Отправить заново",
                        fontFamily = fontFamily,
                        color = SubTextDark,
                        letterSpacing = 0.sp,
                        lineHeight = 12.sp,
                        fontSize = 12.sp
                    )
                    Text(
                        textAlign = TextAlign.Center,
                        text = "00:30",
                        fontFamily = fontFamily,
                        color = Text,
                        letterSpacing = 0.sp,
                        lineHeight = 12.sp,
                        fontSize = 12.sp
                    )
                }
            }
        }
    }
}

/**
 * Автор: Шадрин Роман Алексеевич
 *
 * Дата создания: 26.02.2025
 *
 * Функция отвечает за отображение активности Verification на превью
 */
@Preview(
    showBackground = true,
    name = "Verification"
)
@Composable
private fun VerificationPreview() {
    Verification(
        onPrev = {},
        onHome = {},
    )
}