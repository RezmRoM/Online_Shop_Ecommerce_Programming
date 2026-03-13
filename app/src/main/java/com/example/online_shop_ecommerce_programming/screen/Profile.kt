package com.example.matule.screen

import BottomBar
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
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
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
 * Функция отвечает за отрисовку активности Profile
 * **/
@Composable
fun Profile(
    modifier: Modifier = Modifier,
    onSideMenu: () -> Unit,
    onHome: () -> Unit,
    onFavorite: () -> Unit,
    onNotification: () -> Unit,
    onProfile: () -> Unit,
    onEditProfile: () -> Unit,
    onMyCart: () -> Unit,
) {
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
                Spacer(modifier = modifier.height(12.dp))
                Row(
                    modifier = modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    IconButton(
                        onClick = { onSideMenu() }
                    ) {
                        Image(
                            painter = AppIcons.Menu(),
                            contentDescription = null
                        )
                    }
                    Text(
                        text = "Профиль",
                        fontFamily = fontFamily,
                        fontSize = 16.sp,
                        lineHeight = 20.sp,
                        letterSpacing = 0.sp,
                        color = Text,
                        textAlign = TextAlign.Center,
                    )
                    Box(
                        modifier = modifier
                            .size(25.dp)
                            .background(Accent, CircleShape)
                            .clickable { },
                        contentAlignment = Alignment.Center
                    ) {
                        IconButton(
                            onClick = { onEditProfile() }
                        ) {
                            Image(
                                painter = AppIcons.EditProfile(),
                                contentDescription = null,
                                colorFilter = ColorFilter.tint(Block)
                            )
                        }
                    }
                }
                Spacer(modifier = modifier.height(48.dp))
                Column(
                    modifier
                        .fillMaxWidth()
                        .padding(horizontal = 2.dp)
                ) {
                    Image(
                        painter = AppIcons.ProfileImage(),
                        contentDescription = null,
                        contentScale = ContentScale.Fit,
                        modifier = Modifier
                            .size(96.dp)
                            .align(Alignment.CenterHorizontally)
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
                            modifier = modifier.rotate(-90f),
                            lineHeight = 20.sp,
                            letterSpacing = 0.sp,
                            color = Text,
                            textAlign = TextAlign.Center,
//                            style = TextStyle(SpanStyle(
//                                platformStyle = PlatformSpanStyle(
//
//                                )
//                            ))
                        )
                        Image(
                            painter = AppIcons.QrBar(),
                            contentDescription = null,
                            modifier = modifier
                                .fillMaxWidth()
                                .clip(RoundedCornerShape(8.dp))
                                .padding(vertical = 8.dp)
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
                    Spacer(modifier = Modifier.height(19.dp))
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(48.dp)
                            .background(Background, RoundedCornerShape(14.dp)),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            modifier = Modifier.padding(start = 16.dp),
                            text = "Emmanuel",
                            fontFamily = fontFamily,
                            letterSpacing = 0.sp,
                            lineHeight = 16.sp,
                            fontSize = 14.sp,
                            color = Hint,
                        )
                    }
                    Spacer(modifier = Modifier.height(17.dp))
                    Text(
                        text = "Фамилия",
                        fontFamily = fontFamily,
                        letterSpacing = 0.sp,
                        lineHeight = 20.sp,
                        fontSize = 16.sp,
                        color = Text
                    )
                    Spacer(modifier = Modifier.height(19.dp))
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(48.dp)
                            .background(Background, RoundedCornerShape(14.dp)),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            modifier = Modifier.padding(start = 16.dp),
                            text = "Emmanuel",
                            fontFamily = fontFamily,
                            letterSpacing = 0.sp,
                            lineHeight = 16.sp,
                            fontSize = 14.sp,
                            color = Hint,
                        )
                    }
                    Spacer(modifier = Modifier.height(17.dp))
                    Text(
                        text = "Адрес",
                        fontFamily = fontFamily,
                        letterSpacing = 0.sp,
                        lineHeight = 20.sp,
                        fontSize = 16.sp,
                        color = Text
                    )
                    Spacer(modifier = Modifier.height(19.dp))
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(48.dp)
                            .background(Background, RoundedCornerShape(14.dp)),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            modifier = Modifier.padding(start = 16.dp),
                            text = "Oyiboke",
                            fontFamily = fontFamily,
                            letterSpacing = 0.sp,
                            lineHeight = 16.sp,
                            fontSize = 14.sp,
                            color = Hint,
                        )
                    }
                    Spacer(modifier = Modifier.height(17.dp))
                    Text(
                        text = "Телефон",
                        fontFamily = fontFamily,
                        letterSpacing = 0.sp,
                        lineHeight = 20.sp,
                        fontSize = 16.sp,
                        color = Text
                    )
                    Spacer(modifier = Modifier.height(19.dp))
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(48.dp)
                            .background(Background, RoundedCornerShape(14.dp)),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            modifier = Modifier.padding(start = 16.dp),
                            text = "+7 811-732-5298",
                            fontFamily = fontFamily,
                            letterSpacing = 0.sp,
                            lineHeight = 16.sp,
                            fontSize = 14.sp,
                            color = Hint,
                        )
                    }
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
                    onMyCart = { onMyCart() },
                )
            }
        }
    }
}


/**
 * Автор: Шадрин Роман Алексеевич
 *
 *  Дата создания: 28.02.2025
 * Функция ProfilePreview() не принимает параметров и предназначена для просмотра предварительного просмотрав Android Studio
 *
 * В ней находится вызов функции Profile()
 */
@Preview(
    showBackground = true,
    name = "Profile"
)
@Composable
private fun ProfilePreview() {
    Profile(
        onSideMenu = {},
        onHome = {},
        onFavorite = {},
        onNotification = {},
        onProfile = {},
        onEditProfile = {},
        onMyCart = {},
    )
}