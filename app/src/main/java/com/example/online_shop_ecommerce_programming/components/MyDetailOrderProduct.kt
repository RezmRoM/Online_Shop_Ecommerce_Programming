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
fun MyDetailOrderProduct(
    modifier: Modifier = Modifier,
    title: String = "Nike Air Max 270\nEssential",
    priceFirst: String = "₽814.15",
    priceSecond: String = "1 шт",
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(104.dp)
            .background(Block, RoundedCornerShape(8.dp))
            .clip(RoundedCornerShape(8.dp))
            .clickable { }
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
                Spacer(modifier = modifier.height(9.dp))
                Text(
                    text = title,
                    fontFamily = fontFamily,
                    fontSize = 14.sp,
                    lineHeight = 14.sp,
                    letterSpacing = 0.sp,
                    color = com.example.matule.ui.theme.Text,
                )
                Spacer(modifier = modifier.height(34.dp))
                Row {
                    Text(
                        text = priceFirst,
                        fontFamily = fontFamily,
                        fontSize = 16.sp,
                        lineHeight = 16.sp,
                        letterSpacing = 0.sp,
                        color = com.example.matule.ui.theme.Text,
                    )
                    Spacer(modifier = modifier.width(31.dp))
                    Text(
                        text = priceSecond,
                        fontFamily = fontFamily,
                        fontSize = 16.sp,
                        lineHeight = 16.sp,
                        letterSpacing = 0.sp,
                        color = Hint,
                    )
                }

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
 * В ней находится вызов функции MyDetailOrderProduct()
 */
@Preview(
    showBackground = true,
    name = "MyDetailOrderProduct"
)
@Composable
private fun MyDetailOrderProductPreview() {
    MyDetailOrderProduct()
}