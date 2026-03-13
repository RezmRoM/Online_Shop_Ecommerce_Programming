package com.example.matule.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.matule.ui.theme.Block
import com.example.matule.ui.theme.Disable
import com.example.matule.ui.theme.SubTextLight
import com.example.matule.ui.theme.fontFamily
import com.example.matule.utils.AppIcons

/** Автор: Шадрин Роман Алексеевич
 *
 * Дата создания: 26.02.2025
 *
 * Функция отвечает за отрисовку активности OnboardingSecond
 * **/
@Composable
fun OnboardingSecond(
    modifier: Modifier = Modifier,
    onNextClick: () -> Unit
) {
    Scaffold { paddingValues ->
        Column(
            modifier = modifier
                .fillMaxSize()
                .background(
                    brush = Brush.linearGradient(
                        colors = listOf(
                            Color(0xFF48B2E7),
                            Color(0xFF44A9DC),
                            Color(0xFF2B6B8B),
                        )
                    )
                )
                .padding(paddingValues)
        ) {
            Spacer(modifier = modifier.height(37.dp))
            Image(
                painter = AppIcons.RedWhiteNike(),
                contentDescription = null,
                contentScale = ContentScale.Fit,
                modifier = modifier
                    .fillMaxWidth()
                    .width(302.dp)
            )
            Spacer(modifier = modifier.height(60.dp))
            Text(
                text = "Начнем\nпутешествие",
                fontFamily = fontFamily,
                fontSize = 34.sp,
                lineHeight = 44.sp,
                letterSpacing = 0.sp,
                color = Block,
                textAlign = TextAlign.Center,
                modifier = modifier
                    .padding(horizontal = 30.dp)
                    .align(Alignment.CenterHorizontally),
            )
            Spacer(modifier = modifier.height(12.dp))
            Text(
                text = "Умная, великолепная и модная коллекция\nИзучите сейчас",
                fontFamily = fontFamily,
                fontSize = 16.sp,
                lineHeight = 24.sp,
                letterSpacing = 0.sp,
                color = SubTextLight,
                textAlign = TextAlign.Center,
                modifier = modifier
                    .padding(horizontal = 30.dp)
                    .align(Alignment.CenterHorizontally),
            )
            Spacer(modifier = modifier.height(40.dp))
            Row(
                modifier = modifier.padding(horizontal = 126.dp)
            ) {
                Box(
                    modifier
                        .size(28.dp, 4.dp)
                        .background(Disable)
                        .clip(RoundedCornerShape(30.dp))
                ) {

                }
                Spacer(modifier = modifier.width(12.dp))
                Box(
                    modifier
                        .size(43.dp, 4.dp)
                        .background(Block)
                        .clip(RoundedCornerShape(30.dp))
                )
                Spacer(modifier = modifier.width(12.dp))
                Box(
                    modifier
                        .size(28.dp, 4.dp)
                        .background(Disable)
                        .clip(RoundedCornerShape(30.dp))
                )
            }
            Spacer(modifier = modifier.weight(1f))
            Button(
                onClick = { onNextClick() },
                shape = RoundedCornerShape(13.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(86.dp)
                    .padding(horizontal = 20.dp)
                    .padding(bottom = 36.dp),
                colors = ButtonColors(
                    disabledContainerColor = Block,
                    disabledContentColor = Block,
                    containerColor = Block,
                    contentColor = Block,
                )
            ) {
                Text(
                    text = "Далее",
                    fontFamily = fontFamily,
                    letterSpacing = 0.sp,
                    lineHeight = 22.sp,
                    color = com.example.matule.ui.theme.Text,
                    fontSize = 14.sp
                )
            }
        }
    }
}

/** Автор: Шадрин Роман Алексеевич
 *
 * Дата создания: 26.02.2025
 *
 * Функция отвечает за отображение активности OnboardSecond на превью
 * **/
@Preview(
    showBackground = true,
    name = "OnboardSecond"
)
@Composable
private fun OnboardSecondPreview() {
    OnboardingSecond(
        onNextClick = {}
    )
}