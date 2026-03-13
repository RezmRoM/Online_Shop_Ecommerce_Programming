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
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.matule.components.ProductCard
import com.example.matule.ui.theme.Background
import com.example.matule.ui.theme.Block
import com.example.matule.ui.theme.Red
import com.example.matule.ui.theme.fontFamily
import com.example.matule.utils.AppIcons

/** Автор: Шадрин Роман Алексеевич
 *
 * Дата создания: 27.02.2025
 *
 * Функция отвечает за отрисовку активности Favorite
 * **/
@Composable
fun Favorite(
    modifier: Modifier = Modifier,
    onFavorite: () -> Unit,
    onPrev: () -> Unit,
    onHome: () -> Unit,
    onNotification: () -> Unit,
    onProfile: () -> Unit,
    onDetails: () -> Unit,
    onMyCart: () -> Unit,
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
                Row(
                    modifier = modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = modifier
                            .size(44.dp)
                            .background(Block, CircleShape)
                            .clip(CircleShape)
                            .clickable { onPrev() },
                        contentAlignment = Alignment.Center
                    ) {
                        Image(
                            painter = AppIcons.ChevronLeft(),
                            contentDescription = null
                        )
                    }

                    Text(
                        text = "Избранное",
                        fontFamily = fontFamily,
                        fontSize = 16.sp,
                        lineHeight = 24.sp,
                        letterSpacing = 0.sp,
                        color = com.example.matule.ui.theme.Text,
                        textAlign = TextAlign.Center,
                    )
                    Box(
                        modifier = modifier
                            .size(44.dp)
                            .background(Block, CircleShape)
                            .clip(CircleShape)
                            .clickable {
                                onFavorite()
                            },
                        contentAlignment = Alignment.Center
                    ) {
                        Image(
                            painter = AppIcons.HeartField(),
                            modifier = modifier.size(24.dp),
                            contentDescription = null,
                            colorFilter = ColorFilter.tint(Red)
                        )
                    }
                }
                Spacer(modifier = modifier.height(20.dp))
                LazyVerticalGrid(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.spacedBy(15.dp),
                    horizontalArrangement = Arrangement.spacedBy(15.dp),
                    columns = GridCells.Fixed(2),
                ) {
                    items(7) {
                        ProductCard(
                            onDetails = { onDetails() },
                            heartIcon = {
                                Image(
                                    painter = AppIcons.HeartField(),
                                    contentDescription = null,
                                    modifier = Modifier.size(16.dp),
                                    colorFilter = ColorFilter.tint(Red)
                                )
                            },
                        )
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
                    onMyCart = { onMyCart() }
                )
            }
        }
    }
}

/** Автор: Шадрин Роман Алексеевич
 *
 * Дата создания: 27.02.2025
 *
 * Функция отвечает за отображение активности Favorite на превью
 * **/
@Preview(
    showBackground = true,
    name = "Favorite"
)
@Composable
private fun FavoritePreview() {
    Favorite(
        onPrev = {},
        onFavorite = {},
        onHome = {},
        onNotification = {},
        onProfile = {},
        onDetails = {},
        onMyCart = {},
    )
}