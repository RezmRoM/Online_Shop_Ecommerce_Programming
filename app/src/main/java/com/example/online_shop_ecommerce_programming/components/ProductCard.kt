package com.example.matule.components

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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
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
fun ProductCard(
    title: String = "Nike Air Max",
    label: String = "BEST SELLER",
    price: String = "₽752.00",
    onDetails: () -> Unit,
    rightIcon: @Composable () -> Unit = {
        Image(
            painter = AppIcons.Plus(),
            contentDescription = null,
            colorFilter = ColorFilter.tint(Block)
        )
    },
    heartIcon: @Composable () -> Unit = {
        Image(
            painter = AppIcons.HeartOutline(),
            contentDescription = null,
            modifier = Modifier.size(16.dp),
        )
    }
) {
    Box(
        modifier = Modifier
            .size(160.dp, 182.dp)
            .background(Block, RoundedCornerShape(16.dp))
            .clip(RoundedCornerShape(16.dp))
            .clickable { onDetails() }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 9.dp)
        ) {
            Image(
                painter = AppIcons.BlueNike2(),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.height(70.dp).padding(horizontal = 12.dp)
            )
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                text = label,
                color = Accent,
                fontFamily = fontFamily,
                fontSize = 12.sp,
                lineHeight = 16.sp,
                letterSpacing = 0.sp
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = title,
                color = Hint,
                fontFamily = fontFamily,
                fontSize = 16.sp,
                lineHeight = 20.sp,
                letterSpacing = 0.sp
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 9.dp)
                .align(Alignment.BottomCenter),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = price,
                color = com.example.matule.ui.theme.Text,
                fontFamily = fontFamily,
                fontSize = 14.sp,
                lineHeight = 16.sp,
                letterSpacing = 0.sp
            )
            Box(
                modifier = Modifier
                    .size(34.dp)
                    .background(Accent, RoundedCornerShape(topStart = 16.dp)),
                contentAlignment = Alignment.Center
            ) {
               rightIcon()
            }
        }
        Box(
            modifier = Modifier
                .size(28.dp)
                .padding(start = 9.dp, top = 9.dp)
                .background(Background, CircleShape),
            contentAlignment = Alignment.Center
        ) {
            heartIcon()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProductCardPreview() {
    ProductCard(
        onDetails = {}
    )
}