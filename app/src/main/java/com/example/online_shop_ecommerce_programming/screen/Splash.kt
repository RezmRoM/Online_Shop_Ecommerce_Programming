package com.example.matule.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.matule.ui.theme.Accent
import com.example.matule.ui.theme.Block
import com.example.matule.utils.AppIcons
import kotlinx.coroutines.delay

/** Автор: Шадрин Роман Алексеевич
 *
 * Дата создания: 26.02.2025
 *
 * Функция отвечает за отрисовку активности Splash
 * **/
@Composable
fun Splash(
    modifier: Modifier = Modifier,
    onNext: () -> Unit
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(Accent),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = modifier
                .size(129.dp)
                .clip(CircleShape)
                .background(Block, CircleShape),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = AppIcons.Bag(),
                contentDescription = null,
            )
        }
    }
    LaunchedEffect(
        Unit
    ) {
        delay(1000L)
        onNext()
    }
}

/**
 * Автор: Шадрин Роман Алексеевич
 *
 * Дата создания: 26.02.2025
 *
 * Функция отвечает за отображение активности Splash на превью
 */
@Preview(
    showBackground = true,
    name = "Splash"
)
@Composable
private fun SplashPreview() {
    Splash(
        onNext = {}
    )
}