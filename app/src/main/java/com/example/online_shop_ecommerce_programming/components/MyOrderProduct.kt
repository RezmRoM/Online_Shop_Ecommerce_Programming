package com.example.matule.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.matule.ui.theme.Accent
import com.example.matule.ui.theme.Background
import com.example.matule.ui.theme.Block
import com.example.matule.ui.theme.Hint
import com.example.matule.ui.theme.fontFamily
import com.example.matule.utils.AppIcons

@Composable
fun MyOrderProduct(
    modifier: Modifier = Modifier,
    numberDelivery: String = "№ 325556516",
    title: String = "Nike Air Max 270\nEssential",
    priceFirst: String = "$364.95",
    priceSecond: String = "$260.00",
    time: String = "7 мин назад",
    onMyOrderProductClick: ()-> Unit,
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(104.dp)
            .background(Block, RoundedCornerShape(8.dp))
            .clip(RoundedCornerShape(8.dp))
            .clickable { onMyOrderProductClick() }
    ) {
        Row(
            modifier = modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = modifier
                    .padding(start = 10.dp)
                    .size(87.dp, 85.dp)
                    .background(Background, RoundedCornerShape(16.dp))
                    .clip(RoundedCornerShape(16.dp)),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = AppIcons.BlueBlueNike(),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                )
            }
            Spacer(modifier = modifier.width(31.dp))
            Column {
                Text(
                    text = numberDelivery,
                    fontFamily = fontFamily,
                    fontSize = 14.sp,
                    lineHeight = 14.sp,
                    letterSpacing = 0.sp,
                    color = Accent,
                )
                Spacer(modifier = modifier.height(9.dp))
                Text(
                    text = title,
                    fontFamily = fontFamily,
                    fontSize = 14.sp,
                    lineHeight = 14.sp,
                    letterSpacing = 0.sp,
                    color = com.example.matule.ui.theme.Text,
                )
                Spacer(modifier = modifier.height(9.dp))
                Row {
                    Text(
                        text = priceFirst,
                        fontFamily = fontFamily,
                        fontSize = 14.sp,
                        lineHeight = 20.sp,
                        letterSpacing = 0.sp,
                        color = com.example.matule.ui.theme.Text,
                    )
                    Spacer(modifier = modifier.width(39.dp))
                    Text(
                        text = priceSecond,
                        fontFamily = fontFamily,
                        fontSize = 14.sp,
                        lineHeight = 20.sp,
                        letterSpacing = 0.sp,
                        color = Hint,
                    )
                }

            }
        }
        Text(
            text = time,
            fontFamily = fontFamily,
            fontSize = 14.sp,
            lineHeight = 20.sp,
            letterSpacing = 0.sp,
            color = Hint,
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(all = 10.dp)
        )
    }
}

/**
 * Автор: Шадрин Роман Алексеевич
 *
 *  Дата создания: 28.02.2025
 * Функция NotificationPreview() не принимает параметров и предназначена для просмотра предварительного просмотрав Android Studio
 *
 * В ней находится вызов функции MyOrderProduct()
 */
@Preview(
    showBackground = true,
    name = "MyOrderProduct"
)
@Composable
private fun MyOrderProductPreview() {
    MyOrderProduct(
        onMyOrderProductClick = {}
    )
}