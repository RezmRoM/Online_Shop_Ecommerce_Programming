package com.example.matule.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.matule.ui.theme.Accent
import com.example.matule.ui.theme.Background
import com.example.matule.ui.theme.Block
import com.example.matule.ui.theme.Hint
import com.example.matule.ui.theme.Red
import com.example.matule.ui.theme.SubTextDark
import com.example.matule.ui.theme.Text
import com.example.matule.ui.theme.fontFamily
import com.example.matule.utils.AppIcons
import com.example.matule.utils.StringResources

/**
 * Автор: Шадрин Роман Алексеевич
 *
 * Функция Log_In принимает параметр, которые передаются при вызове метода в методе NavGraph
 * @param onLogInClick
 * @param onResetClick
 * @param onNewUserClick
 * В ней находится всё основное содержимое активити
 * 1. Вызов функции TopText
 * 2. Поля для ввода: email, пароль
 * 3. Текстовая кнопка "Восстановить" для дальнейшего перехода на другую активити для восстановления пароля
 * 4. Кнопка "Войти" - при клике, если поля email и пароль не пустые, то происходит переход на активити Home
 * 5. Вызов функции BottomBlock
 */
@Composable
fun Log_In(
    onLogInClick: () -> Unit,
    onResetClick: () -> Unit,
    onNewUserClick: () -> Unit,
    onPrev: () -> Unit,
) {
    var passwordVisibility by rememberSaveable { mutableStateOf(false) }
    var password by rememberSaveable { mutableStateOf("") }

    var email by rememberSaveable { mutableStateOf("") }
    var emailError by rememberSaveable { mutableStateOf(false) }

    var passwordError by rememberSaveable { mutableStateOf(false) }

    Scaffold { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Block)
                .padding(horizontal = 20.dp)
                .padding(paddingValues)
                .verticalScroll(rememberScrollState()),
        ) {
            Spacer(modifier = Modifier.height(23.dp))
            Box(
                modifier = Modifier
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
            Spacer(modifier = Modifier.height(11.dp))
            /** @author Шадрин Роман Алексеевич
             * Дата создания: 26.02.2025
             * Вызов функции TopText() без параметров
             * **/
            TopText()
            // Отступ по вертикали вниз 35 dp
            Spacer(modifier = Modifier.height(35.dp))
            Text(
                text = StringResources.Email,
                fontFamily = fontFamily,
                letterSpacing = 0.sp,
                lineHeight = 20.sp,
                fontSize = 16.sp,
                color = Text
            )
            // Отступ по вертикали вниз 12 dp
            Spacer(modifier = Modifier.height(12.dp))
            OutlinedTextField(
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(15.dp),
                onValueChange = { email = it },
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedContainerColor = Background,
                    focusedContainerColor = Background,
                    unfocusedBorderColor = if (emailError) Red else Background,
                    focusedBorderColor = if (emailError) Red else Background
                ),
                placeholder = {
                    Text(
                        text = StringResources.PromptEmail,
                        fontFamily = fontFamily,
                        letterSpacing = 0.sp,
                        lineHeight = 16.sp,
                        fontSize = 14.sp,
                        color = Hint,
                    )
                },
                singleLine = true,
                value = email
            )
            // Отступ по вертикали вниз 26 dp
            Spacer(modifier = Modifier.height(26.dp))
            Text(
                text = StringResources.Password,
                fontFamily = fontFamily,
                letterSpacing = 0.sp,
                lineHeight = 20.sp,
                fontSize = 16.sp,
                color = Text
            )
            // Отступ по вертикали вниз 12 dp
            Spacer(modifier = Modifier.height(12.dp))
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(14.dp),
                onValueChange = { password = it },
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedContainerColor = Background,
                    focusedContainerColor = Background,
                    unfocusedBorderColor = if (passwordError) Red else Background,
                    focusedBorderColor = if (passwordError) Red else Background
                ),
                visualTransformation = if (passwordVisibility) PasswordVisualTransformation() else VisualTransformation.None,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                trailingIcon = {
                    IconButton(
                        onClick = { passwordVisibility = !passwordVisibility }
                    ) {
                        Image(
                            painter = if (passwordVisibility) AppIcons.VisibleOn() else AppIcons.VisibleOff(),
                            contentDescription = null
                        )
                    }
                },
                placeholder = {
                    Text(
                        text = StringResources.PromptPasswod,
                        fontFamily = fontFamily,
                        fontSize = 14.sp,
                        lineHeight = 16.sp,
                        letterSpacing = 0.sp,
                        color = Hint,
                    )
                },
                singleLine = true,
                value = password,
            )
            // Отступ по вертикали вниз 16 dp
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = StringResources.Vosstanovit,
                modifier = Modifier
                    .align(Alignment.End)
                    .clickable { onResetClick() },
                fontFamily = fontFamily,
                letterSpacing = 0.sp,
                color = SubTextDark,
                lineHeight = 16.sp,
                fontSize = 12.sp,
            )
//            }
            // Отступ по вертикали вниз 24 dp
            Spacer(modifier = Modifier.height(24.dp))
            Button(
                onClick = {
                    if (email.isEmpty()) {
                        emailError = true
                    } else if (password.isEmpty()) {
                        passwordError = true
                    } else if (email.isNotEmpty() and password.isNotEmpty()) {
                        passwordError = false
                        emailError = false
                        onLogInClick()
                    }
                },
                shape = RoundedCornerShape(14.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                colors = ButtonColors(
                    disabledContainerColor = Accent,
                    disabledContentColor = Accent,
                    containerColor = Accent,
                    contentColor = Accent,
                )
            ) {
                Text(
                    text = StringResources.LogIn,
                    fontFamily = fontFamily,
                    letterSpacing = 0.sp,
                    lineHeight = 22.sp,
                    color = Background,
                    fontSize = 14.sp
                )
            }
            // Отступ по вертикали вниз до следующего контента
            Spacer(modifier = Modifier.weight(1f))
            /** @author Шадрин Роман Алексеевич
             * Дата создания: 26.02.2025
             * Вызов функции BottomBlock() с переданным параметром
             * @param onNewUserClick
             * **/
            BottomBlock(onNewUserClick = onNewUserClick)
        }
    }
}

/** Автор: Шадрин Роман Алексеевич
 *
 * Дата создания: 26.02.2025
 *
 * Функция TopText() без параметров
 *
 * В ней находится два текстовых поля:
 * 1. Приветственное слово
 * 2. Подсказка для пользователя
 * **/
@Composable
private fun ColumnScope.TopText() {
    Text(
        modifier = Modifier.align(Alignment.CenterHorizontally),
        text = buildAnnotatedString {
            append(StringResources.HI)
            withStyle(
                SpanStyle(
                    fontStyle = FontStyle.Italic,
                )
            ) {
                append(StringResources.Voscl)
            }
        },
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
        text = StringResources.Prompt,
        fontFamily = fontFamily,
        color = SubTextDark,
        letterSpacing = 0.sp,
        lineHeight = 24.sp,
        fontSize = 16.sp
    )
}

/** Автор: Шадрин Роман Алексеевич
 *
 * Дата создания: 26.02.2025
 *
 * Функция BottomBlock() с параметром, который пробрасывается наверх в функцию LogIn
 * @param onNewUserClick
 *
 * В ней находится 2 текста в ряд по горизонтали:
 * 1. Текст с вопросом к пользователю
 * 2. Текст кнопка для создания нового пользователя (не активна)
 * **/
@Composable
private fun BottomBlock(
    onNewUserClick: () -> Unit,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 50.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = StringResources.Vperviye,
            fontFamily = fontFamily,
            letterSpacing = 0.sp,
            lineHeight = 16.sp,
            fontSize = 16.sp,
            color = Hint
        )
        Spacer(modifier = Modifier.width(4.dp))
        TextButton(
            contentPadding = PaddingValues(0.dp),
            modifier = Modifier.height(16.dp),
            onClick = { onNewUserClick() }
        ) {
            Text(
                text = StringResources.Sozdat_Polzovatelya,
                fontFamily = fontFamily,
                letterSpacing = 0.sp,
                lineHeight = 16.sp,
                fontSize = 16.sp,
                color = Text,
            )
        }
    }
}

/**
 * Автор: Шадрин Роман Алексеевич
 *
 * Функция Log_InPreview() не принимает параметров и предназначена для просмотра предварительного просмотрав Android Studio
 *
 * В ней находится вызов функции Home()
 */
@Preview(
    showBackground = true,
    name = "LogIn"
)
@Composable
private fun Log_InPreview() {
    Log_In(
        onLogInClick = {},
        onResetClick = {},
        onNewUserClick = {},
        onPrev = {},
    )
}