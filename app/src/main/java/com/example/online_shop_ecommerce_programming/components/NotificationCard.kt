package com.example.matule.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.matule.screen.Notification
import com.example.matule.ui.theme.Background
import com.example.matule.ui.theme.SubTextDark
import com.example.matule.ui.theme.fontFamily

/** Автор: Шадрин Роман Алексеевич
 *
 * Дата создания: 28.02.2025
 *
 * Функция отвечает за отрисовку активности NotificationCard
 * **/
@Composable
fun NotificationCard(
   modifier: Modifier = Modifier,
    title: String = "Заголовок",
    description: String = "Lorem ipsum dolor sit amet consectetur. Venenatis\n" +
            "pulvinar lobortis risus consectetur morbi egestas id in\n" +
            "bibendum. Volutpat nulla urna sit sed diam nulla.",
    time: String = "27.01.2024, 15:42",
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .height(128.dp)
            .background(Background, RoundedCornerShape(16.dp))
            .clip(RoundedCornerShape(16.dp))
            .padding(all = 16.dp)
    ) {
        Text(
            text = title,
            fontFamily = fontFamily,
            fontSize = 16.sp,
            lineHeight = 16.sp,
            letterSpacing = 0.sp,
            color = com.example.matule.ui.theme.Text,
            textAlign = TextAlign.Center,
        )
        Spacer(modifier = modifier.height(8.dp))
        Text(
            text = description,
            fontFamily = fontFamily,
            fontSize = 12.sp,
            lineHeight = 14.sp,
            letterSpacing = 0.sp,
            color = com.example.matule.ui.theme.Text
        )
        Spacer(modifier = modifier.height(16.dp))
        Text(
            text = time,
            fontFamily = fontFamily,
            fontSize = 12.sp,
            lineHeight = 14.sp,
            letterSpacing = 0.sp,
            color = SubTextDark,
            textAlign = TextAlign.Center,
        )
    }
}

/**
 * Автор: Шадрин Роман Алексеевич
 *
 *  Дата создания: 28.02.2025
 * Функция NotificationPreview() не принимает параметров и предназначена для просмотра предварительного просмотрав Android Studio
 *
 * В ней находится вызов функции NotificationCard()
 */
@Preview(
    showBackground = true,
    name = "NotificationCard"
)
@Composable
private fun NotificationCardPreview() {
    NotificationCard()
}