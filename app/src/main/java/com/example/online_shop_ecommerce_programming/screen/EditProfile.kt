package com.example.matule.screen


import BottomBar
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
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
import androidx.compose.ui.graphics.TransformOrigin
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.matule.ui.theme.Accent
import com.example.matule.ui.theme.Background
import com.example.matule.ui.theme.Block
import com.example.matule.ui.theme.Hint
import com.example.matule.ui.theme.Text
import com.example.matule.ui.theme.fontFamily
import com.example.matule.utils.AppIcons

/** Автор: Шадрин Роман Алексеевич
 *
 * Дата создания: 28.02.2025
 *
 * Функция отвечает за отрисовку активности EditProfile
 * **/
@Composable
fun EditProfile(
    modifier: Modifier = Modifier,
    onHome: () -> Unit,
    onFavorite: () -> Unit,
    onNotification: () -> Unit,
    onProfile: () -> Unit,
    onMyCart: () -> Unit,
) {

    var name by rememberSaveable { mutableStateOf("") }
    var surname by rememberSaveable { mutableStateOf("") }
    var adress by rememberSaveable { mutableStateOf("") }
    var phoneNumber by rememberSaveable { mutableStateOf("") }

    Scaffold { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Block)
                .padding(paddingValues)
                .verticalScroll(rememberScrollState())
        ) {
            Column(
                modifier
                    .fillMaxSize()
                    .padding(horizontal = 22.dp)
            ) {
                Spacer(modifier = modifier.height(7.dp))
                Row(
                    modifier = modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Button(
                        onClick = { onProfile() },
                        shape = RoundedCornerShape(13.dp),
                        modifier = Modifier
                            .size(212.dp, 32.dp),
                        colors = ButtonColors(
                            disabledContainerColor = Accent,
                            disabledContentColor = Accent,
                            containerColor = Accent,
                            contentColor = Accent,
                        )
                    ) {
                        Text(
                            text = "Сохранить",
                            fontFamily = fontFamily,
                            letterSpacing = 0.sp,
                            lineHeight = 22.sp,
                            fontSize = 14.sp,
                            color = Block
                        )
                    }
                }
                Column(
                    modifier
                        .fillMaxWidth()
                        .padding(horizontal = 2.dp)
                ) {
                    Spacer(modifier = modifier.height(48.dp))
                    Image(
                        painter = AppIcons.ProfileImage(),
                        contentDescription = null,
                        contentScale = ContentScale.Fit,
                        modifier = Modifier
                            .size(96.dp)
                            .align(Alignment.CenterHorizontally)
                    )
                    Spacer(modifier = modifier.height(11.dp))
                    Text(
                        text = "Изменить фото профиля",
                        fontFamily = fontFamily,
                        fontSize = 12.sp,
                        lineHeight = 16.sp,
                        letterSpacing = 0.sp,
                        color = Accent,
                        textAlign = TextAlign.Center,
                        modifier = modifier.align(Alignment.CenterHorizontally)
                    )
                    Spacer(modifier = modifier.height(8.dp))
                    Text(
                        text = "Emmanuel Oyiboke",
                        fontFamily = fontFamily,
                        fontSize = 20.sp,
                        lineHeight = 20.sp,
                        letterSpacing = 0.sp,
                        color = Text,
                        textAlign = TextAlign.Center,
                        modifier = modifier.align(Alignment.CenterHorizontally)
                    )
                    Spacer(modifier = modifier.height(38.dp))
                    Row(
                        modifier = modifier
                            .fillMaxWidth()
                            .padding(horizontal = 8.dp)
                            .background(Background, RoundedCornerShape(16.dp))
                    ) {
                        Text(
                            text = "Открыть",
                            fontFamily = fontFamily,
                            fontSize = 12.sp,
                            modifier = modifier
                                .graphicsLayer(
                                ) {
                                    rotationZ = -90f
                                    transformOrigin = TransformOrigin(0.5f, 0.5f)
                                },
                            lineHeight = 20.sp,
                            letterSpacing = 0.sp,
                            color = Text,
                            textAlign = TextAlign.Center,
                        )
                        Image(
                            painter = AppIcons.QrBar(),
                            contentDescription = null,
                            modifier = modifier
                                .fillMaxWidth()
                                .clip(RoundedCornerShape(8.dp))
                                .padding(vertical = 8.dp)
                                .padding(end = 8.dp)
                        )
                    }
                    Spacer(modifier = Modifier.height(19.dp))
                    Text(
                        text = "Имя",
                        fontFamily = fontFamily,
                        letterSpacing = 0.sp,
                        lineHeight = 20.sp,
                        fontSize = 16.sp,
                        color = Text
                    )
                    OutlinedTextField(
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(15.dp),
                        onValueChange = { name = it },
                        colors = OutlinedTextFieldDefaults.colors(
                            unfocusedContainerColor = Background,
                            focusedContainerColor = Background,
                            focusedBorderColor = Background,
                            unfocusedBorderColor = Background,
                        ),
                        placeholder = {
                            Text(
                                text = "Emmanuel",
                                fontFamily = fontFamily,
                                letterSpacing = 0.sp,
                                lineHeight = 16.sp,
                                fontSize = 14.sp,
                                color = Hint,
                            )
                        },
                        trailingIcon = {
                            Image(
                                painter = AppIcons.Done(),
                                contentDescription = null
                            )
                        },
                        singleLine = true,
                        value = name
                    )
                    Spacer(modifier = Modifier.height(12.dp))
                    Text(
                        text = "Фамилия",
                        fontFamily = fontFamily,
                        letterSpacing = 0.sp,
                        lineHeight = 20.sp,
                        fontSize = 16.sp,
                        color = Text
                    )
                    Spacer(modifier = Modifier.height(12.dp))
                    OutlinedTextField(
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(15.dp),
                        onValueChange = { surname = it },
                        colors = OutlinedTextFieldDefaults.colors(
                            unfocusedContainerColor = Background,
                            focusedContainerColor = Background,
                            focusedBorderColor = Background,
                            unfocusedBorderColor = Background,
                        ),
                        placeholder = {
                            Text(
                                text = "Oyiboke",
                                fontFamily = fontFamily,
                                letterSpacing = 0.sp,
                                lineHeight = 16.sp,
                                fontSize = 14.sp,
                                color = Hint,
                            )
                        },
                        trailingIcon = {
                            Image(
                                painter = AppIcons.Done(),
                                contentDescription = null
                            )
                        },
                        singleLine = true,
                        value = surname
                    )
                    Spacer(modifier = Modifier.height(12.dp))
                    Text(
                        text = "Адрес",
                        fontFamily = fontFamily,
                        letterSpacing = 0.sp,
                        lineHeight = 20.sp,
                        fontSize = 16.sp,
                        color = Text
                    )
                    Spacer(modifier = Modifier.height(12.dp))
                    OutlinedTextField(
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(15.dp),
                        onValueChange = { adress = it },
                        colors = OutlinedTextFieldDefaults.colors(
                            unfocusedContainerColor = Background,
                            focusedContainerColor = Background,
                            focusedBorderColor = Background,
                            unfocusedBorderColor = Background,
                        ),
                        trailingIcon = {
                            Image(
                                painter = AppIcons.Done(),
                                contentDescription = null
                            )
                        },
                        placeholder = {
                            Text(
                                text = "Nigeria",
                                fontFamily = fontFamily,
                                letterSpacing = 0.sp,
                                lineHeight = 16.sp,
                                fontSize = 14.sp,
                                color = Hint,
                            )
                        },
                        singleLine = true,
                        value = adress
                    )
                    Spacer(modifier = Modifier.height(12.dp))
                    Text(
                        text = "Телефон",
                        fontFamily = fontFamily,
                        letterSpacing = 0.sp,
                        lineHeight = 20.sp,
                        fontSize = 16.sp,
                        color = Text
                    )
                    Spacer(modifier = Modifier.height(12.dp))
                    OutlinedTextField(
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(15.dp),
                        onValueChange = { phoneNumber = it },
                        colors = OutlinedTextFieldDefaults.colors(
                            unfocusedContainerColor = Background,
                            focusedContainerColor = Background,
                            focusedBorderColor = Background,
                            unfocusedBorderColor = Background,
                        ),
                        trailingIcon = {
                            Image(
                                painter = AppIcons.Done(),
                                contentDescription = null
                            )
                        },
                        placeholder = {
                            Text(
                                text = "+7 811-732-5298",
                                fontFamily = fontFamily,
                                letterSpacing = 0.sp,
                                lineHeight = 16.sp,
                                fontSize = 14.sp,
                                color = Hint,
                            )
                        },
                        singleLine = true,
                        value = phoneNumber
                    )
                    Spacer(modifier = Modifier.height(17.dp))
                }
            }
            Box(
                modifier = modifier
                    .fillMaxWidth()
                    .align(Alignment.BottomCenter)
            ) {
                BottomBar(
                    onHome = { onHome() },
                    onFavorite = { onFavorite() },
                    onNotification = { onNotification() },
                    onProfile = { onProfile() },
                    onMyCart = { onMyCart() }
                )
            }
        }
    }
}


/**
 * Автор: Шадрин Роман Алексеевич
 *
 *  Дата создания: 28.02.2025
 * Функция EditProfilePreview() не принимает параметров и предназначена для просмотра предварительного просмотрав Android Studio
 *
 * В ней находится вызов функции EditProfile()
 */
@Preview(
    showBackground = true,
    name = "EditProfile"
)
@Composable
private fun EditProfilePreview() {
    EditProfile(
        onHome = {},
        onFavorite = {},
        onNotification = {},
        onProfile = {},
        onMyCart = {},
    )
}
