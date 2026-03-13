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
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.matule.ui.theme.Accent
import com.example.matule.ui.theme.Background
import com.example.matule.ui.theme.Block
import com.example.matule.ui.theme.Text
import com.example.matule.ui.theme.fontFamily
import com.example.matule.utils.AppIcons
import com.example.matule.utils.StringResources

/** Автор: Шадрин Роман Алексеевич
 *
 * Дата создания: 28.02.2025
 *
 * Функция отвечает за отрисовку активности Home
 * **/
@Composable
fun SideMenu(
    modifier: Modifier = Modifier,
    onProfile: () -> Unit,
    onCart: () -> Unit,
    onFavorite: () -> Unit,
    onDelivery: () -> Unit,
    onNotification: () -> Unit,
    onLogOut: () -> Unit,
) {

    Scaffold { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Accent)
                .padding(paddingValues)
                .verticalScroll(rememberScrollState())
        ) {
            Column(
                modifier
                    .fillMaxSize()
                    .padding(horizontal = 20.dp)
            ) {
                Column(
                    modifier
                        .fillMaxWidth()
                        .padding(horizontal = 15.dp)
                ) {
                    Spacer(modifier = modifier.height(30.dp))
                    Image(
                        painter = AppIcons.ProfileImage(),
                        contentDescription = null,
                        contentScale = ContentScale.Fit,
                        modifier = Modifier.size(96.dp)
                    )
                    Spacer(modifier = modifier.height(15.dp))
                    Text(
                        text = "Эмануэль Кверти",
                        fontFamily = fontFamily,
                        letterSpacing = 0.sp,
                        lineHeight = 20.sp,
                        fontSize = 20.sp,
                        color = Block
                    )
                }
                Spacer(modifier = Modifier.height(60.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { onProfile() },
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = AppIcons.Profile(),
                        contentDescription = null,
                        colorFilter = ColorFilter.tint(Block)
                    )
                    Spacer(modifier = Modifier.width(22.dp))
                    Text(
                        text = "Профиль",
                        fontFamily = fontFamily,
                        letterSpacing = 0.sp,
                        lineHeight = 20.sp,
                        fontSize = 16.sp,
                        color = Block
                    )
                }
                Spacer(modifier = Modifier.height(30.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { onCart() },
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = AppIcons.Bag(),
                        contentDescription = null,
                        colorFilter = ColorFilter.tint(Block),
                        modifier = Modifier.size(24.dp)
                    )
                    Spacer(modifier = Modifier.width(22.dp))
                    Text(
                        text = "Корзина",
                        fontFamily = fontFamily,
                        letterSpacing = 0.sp,
                        lineHeight = 20.sp,
                        fontSize = 16.sp,
                        color = Block
                    )
                }
                Spacer(modifier = Modifier.height(30.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { onFavorite() },
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = AppIcons.FavoriteOutline(),
                        contentDescription = null,
                        colorFilter = ColorFilter.tint(Block)
                    )
                    Spacer(modifier = Modifier.width(22.dp))
                    Text(
                        text = "Избранное",
                        fontFamily = fontFamily,
                        letterSpacing = 0.sp,
                        lineHeight = 20.sp,
                        fontSize = 16.sp,
                        color = Block
                    )
                }
                Spacer(modifier = Modifier.height(30.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { onDelivery() },
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = AppIcons.Delivery(),
                        contentDescription = null,
                        colorFilter = ColorFilter.tint(Block)
                    )
                    Spacer(modifier = Modifier.width(22.dp))
                    Text(
                        text = "Заказы",
                        fontFamily = fontFamily,
                        letterSpacing = 0.sp,
                        lineHeight = 20.sp,
                        fontSize = 16.sp,
                        color = Block
                    )
                }
                Spacer(modifier = Modifier.height(30.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { onNotification() },
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = AppIcons.Notificaton(),
                        contentDescription = null,
                        colorFilter = ColorFilter.tint(Block)
                    )
                    Spacer(modifier = Modifier.width(22.dp))
                    Text(
                        text = "Уведомления",
                        fontFamily = fontFamily,
                        letterSpacing = 0.sp,
                        lineHeight = 20.sp,
                        fontSize = 16.sp,
                        color = Block
                    )
                }
                Spacer(modifier = Modifier.height(30.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {},
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = AppIcons.Settings(),
                        contentDescription = null,
                        colorFilter = ColorFilter.tint(Block)
                    )
                    Spacer(modifier = Modifier.width(22.dp))
                    Text(
                        text = "Настройки",
                        fontFamily = fontFamily,
                        letterSpacing = 0.sp,
                        lineHeight = 20.sp,
                        fontSize = 16.sp,
                        color = Block
                    )
                }
                Spacer(modifier = Modifier.height(38.dp))
                HorizontalDivider(
                    modifier = Modifier.fillMaxWidth(),
                    thickness = 1.dp,
                    color = Color(0xFFF7F7F9).copy(alpha = 0.23f),
                )
                Spacer(modifier = Modifier.height(30.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { onLogOut() },
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = AppIcons.LogOut(),
                        contentDescription = null,
                        colorFilter = ColorFilter.tint(Block)
                    )
                    Spacer(modifier = Modifier.width(22.dp))
                    Text(
                        text = "Выйти",
                        fontFamily = fontFamily,
                        letterSpacing = 0.sp,
                        lineHeight = 20.sp,
                        fontSize = 16.sp,
                        color = Block
                    )
                }
                Spacer(modifier = Modifier.height(30.dp))
            }
            Box(
                modifier = modifier
                    .fillMaxSize()
                    .padding(top = 49.dp)
                    .offset(x = 221.dp)
            ) {
                Image(
                    painter = AppIcons.HomeScreen(),
                    contentDescription = null,
                )
            }
        }
    }
}


/**
 * Автор: Шадрин Роман Алексеевич
 *
 *  Дата создания: 28.02.2025
 * Функция HomePreview() не принимает параметров и предназначена для просмотра предварительного просмотрав Android Studio
 *
 * В ней находится вызов функции SideMenu()
 */
@Preview(
    showBackground = true,
    name = "SideMenu"
)
@Composable
private fun SideMenuPreview() {
    SideMenu(
        onProfile = {},
        onCart = {},
        onFavorite = {},
        onDelivery = {},
        onNotification = {},
        onLogOut = {}
    )
}