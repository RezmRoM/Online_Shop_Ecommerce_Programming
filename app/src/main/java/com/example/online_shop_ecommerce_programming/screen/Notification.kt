package com.example.matule.screen

import BottomBar
import android.widget.ImageButton
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.PlatformSpanStyle
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.matule.components.NotificationCard
import com.example.matule.ui.theme.Accent
import com.example.matule.ui.theme.Background
import com.example.matule.ui.theme.Block
import com.example.matule.ui.theme.Hint
import com.example.matule.ui.theme.Red
import com.example.matule.ui.theme.Text
import com.example.matule.ui.theme.fontFamily
import com.example.matule.utils.AppIcons
import com.example.matule.utils.StringResources

/** Автор: Шадрин Роман Алексеевич
 *
 * Дата создания: 28.02.2025
 *
 * Функция отвечает за отрисовку активности Notification
 * **/
@Composable
fun Notification(
    modifier: Modifier = Modifier,
    onSideMenu: () -> Unit,
    onHome: () -> Unit,
    onFavorite: () -> Unit,
    onNotification: () -> Unit,
    onProfile: () -> Unit,
    onMyCart: () -> Unit,
) {
    Scaffold { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Block)
                .padding(paddingValues)
        ) {
            Column(
                modifier
                    .fillMaxSize()
                    .padding(horizontal = 20.dp),
            ) {
                Spacer(modifier = modifier.height(8.dp))
                Box(
                    modifier = modifier
                        .fillMaxWidth(),
                ) {
                    IconButton(
                        onClick = { onSideMenu() },
                        modifier = modifier.align(Alignment.CenterStart)
                    ) {
                        Image(
                            painter = AppIcons.Menu(),
                            contentDescription = null
                        )
                    }
                    Text(
                        text = "Уведомления",
                        fontFamily = fontFamily,
                        fontSize = 16.sp,
                        lineHeight = 20.sp,
                        letterSpacing = 0.sp,
                        color = Text,
                        textAlign = TextAlign.Center,
                        modifier = modifier.align(Alignment.Center)
                    )
                }
                Spacer(modifier = modifier.height(8.dp))
                LazyColumn(
                    modifier = modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(12.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    items(6) {
                        NotificationCard()
                    }
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
 * Функция NotificationPreview() не принимает параметров и предназначена для просмотра предварительного просмотрав Android Studio
 *
 * В ней находится вызов функции Notification()
 */
@Preview(
    showBackground = true,
    name = "Notification"
)
@Composable
private fun NotificationPreview() {
    Notification(
        onSideMenu = {},
        onHome = {},
        onFavorite = {},
        onNotification = {},
        onProfile = {},
        onMyCart = {},
    )
}