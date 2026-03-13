package com.example.matule.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
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
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
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

/** Автор: Шадрин Роман Алексеевич
 *
 * Дата создания: 27.02.2025
 *
 * Функция отвечает за отрисовку активности ForgotPassword
 * **/
@Composable
fun ForgotPassword(
    onPrev: () -> Unit,
    onVerification: () -> Unit,
) {
    var showDialog by rememberSaveable { mutableStateOf(false) }

    var email by rememberSaveable { mutableStateOf("") }
    var emailError by rememberSaveable { mutableStateOf(false) }

    Scaffold { paddingValues ->
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
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
                Text(
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    text = "Забыл Пароль",
                    textAlign = TextAlign.Center,
                    fontFamily = fontFamily,
                    lineHeight = 32.sp,
                    fontSize = 32.sp,
                    color = Text
                )
                Spacer(modifier = Modifier.height(13.dp))
                Text(
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    textAlign = TextAlign.Center,
                    text = "Введите Свою Учетную Запись\n" +
                            "Для Сброса",
                    fontFamily = fontFamily,
                    color = SubTextDark,
                    letterSpacing = 0.sp,
                    lineHeight = 24.sp,
                    fontSize = 16.sp
                )
                Spacer(modifier = Modifier.height(40.dp))
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
                Spacer(modifier = Modifier.height(40.dp))
                Button(
                    onClick = {
                        if (email.isNotEmpty()) {
                            emailError = false
                            showDialog = true
                        } else {
                            emailError = true
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
                        text = "Отправить",
                        fontFamily = fontFamily,
                        letterSpacing = 0.sp,
                        lineHeight = 22.sp,
                        color = Background,
                        fontSize = 14.sp
                    )
                }
            }
            if (showDialog) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.Black.copy(alpha = 0.4f))
                        .align(Alignment.Center)
                        .clickable { onVerification() },
                    contentAlignment = Alignment.Center
                ) {
                    Surface(
                        modifier = Modifier
                            .size(335.dp, 196.dp)
                            .background(Block, RoundedCornerShape(16.dp))
                            .clip(RoundedCornerShape(16.dp))
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(horizontal = 10.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Spacer(modifier = Modifier.height(30.dp))
                            Box(
                                modifier = Modifier
                                    .size(44.dp)
                                    .background(Accent, CircleShape)
                                    .clip(CircleShape),
                                contentAlignment = Alignment.Center
                            ) {
                                Image(
                                    painter = AppIcons.EmailOtp(),
                                    contentDescription = null,
                                    colorFilter = ColorFilter.tint(Block)
                                )
                            }
                            Spacer(modifier = Modifier.height(34.dp))
                            Text(
                                modifier = Modifier.align(Alignment.CenterHorizontally),
                                textAlign = TextAlign.Center,
                                text = "Проверьте Ваш Email",
                                fontFamily = fontFamily,
                                color = Text,
                                letterSpacing = 0.sp,
                                lineHeight = 20.sp,
                                fontSize = 16.sp
                            )
                            Spacer(modifier = Modifier.height(8.dp))
                            Text(
                                modifier = Modifier.align(Alignment.CenterHorizontally),
                                textAlign = TextAlign.Center,
                                text = "Мы Отправили Код Восстановления\nПароля На Вашу Электронную Почту.",
                                fontFamily = fontFamily,
                                color = SubTextDark,
                                letterSpacing = 0.sp,
                                lineHeight = 20.sp,
                                fontSize = 16.sp
                            )
                        }
                    }
                }
            }
        }
    }
}

/** Автор: Шадрин Роман Алексеевич
 *
 * Дата создания: 27.02.2025
 *
 * Функция отвечает за отображение активности ForgotPassword на превью
 * **/
@Preview(
    showBackground = true,
    name = "ForgotPassword"
)
@Composable
private fun ForgotPasswordPreview() {
    ForgotPassword(
        onPrev = {},
        onVerification = {}
    )
}