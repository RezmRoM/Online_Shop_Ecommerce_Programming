package com.example.matule.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.matule.components.MyCartProduct
import com.example.matule.components.MyOrderProduct
import com.example.matule.ui.theme.Background
import com.example.matule.ui.theme.Block
import com.example.matule.ui.theme.fontFamily
import com.example.matule.utils.AppIcons

/** Автор: Шадрин Роман Алексеевич
 *
 * Дата создания: 28.02.2025
 *
 * Функция отвечает за отрисовку активности Delivery
 * **/
@Composable
fun Delivery(
    modifier: Modifier = Modifier,
    onPrev: () -> Unit,
    onMyOrderProductClick: () -> Unit,
) {

    Scaffold { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Background)
                .padding(paddingValues)
        ) {
            Column(
                modifier
                    .fillMaxSize()
                    .padding(horizontal = 20.dp)
            ) {
                Box(
                    modifier = modifier
                        .fillMaxWidth(),
                ) {
                    Box(
                        modifier = modifier
                            .size(44.dp)
                            .background(Block, CircleShape)
                            .clip(CircleShape)
                            .clickable { onPrev() }
                            .align(Alignment.CenterStart),
                        contentAlignment = Alignment.Center
                    ) {
                        Image(
                            painter = AppIcons.ChevronLeft(),
                            contentDescription = null
                        )
                    }
                    Text(
                        text = "Заказы",
                        fontFamily = fontFamily,
                        modifier = modifier.align(Alignment.Center),
                        fontSize = 16.sp,
                        lineHeight = 20.sp,
                        letterSpacing = 0.sp,
                        color = com.example.matule.ui.theme.Text,
                        textAlign = TextAlign.Center,
                    )
                }
                Spacer(modifier = modifier.height(16.dp))
                Text(
                    text = "Недавний",
                    fontFamily = fontFamily,
                    fontSize = 16.sp,
                    lineHeight = 16.sp,
                    letterSpacing = 0.sp,
                    color = com.example.matule.ui.theme.Text,
                )
                Spacer(modifier = modifier.height(16.dp))
                LazyColumn(
                    modifier = modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(14.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    items(2) {
                        MyOrderProduct(
                            onMyOrderProductClick = onMyOrderProductClick
                        )
                    }
                }
                Spacer(modifier = modifier.height(24.dp))
                Text(
                    text = "Вчера",
                    fontFamily = fontFamily,
                    fontSize = 16.sp,
                    lineHeight = 16.sp,
                    letterSpacing = 0.sp,
                    color = com.example.matule.ui.theme.Text,
                )
                Spacer(modifier = modifier.height(28.dp))
                LazyColumn(
                    modifier = modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(14.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    items(3) {
                        MyOrderProduct(
                            time = "10:23",
                            onMyOrderProductClick = onMyOrderProductClick
                        )
                    }
                }
            }
        }
    }
}

/** Автор: Шадрин Роман Алексеевич
 *
 * Дата создания: 28.02.2025
 *
 * Функция отвечает за отображение активности Delivery на превью
 * **/
@Preview(
    showBackground = true,
    name = "Delivery"
)
@Composable
private fun DeliveryPreview() {
    Delivery(
        onPrev = {},
        onMyOrderProductClick = {},
    )
}