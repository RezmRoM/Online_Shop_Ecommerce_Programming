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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
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
import com.example.matule.ui.theme.fontFamily
import com.example.matule.utils.AppIcons

/** Автор: Шадрин Роман Алексеевич
 *
 * Дата создания: 26.02.2025
 *
 * Функция отвечает за отрисовку активности Catalog
 * **/
@Composable
fun Catalog(
    modifier: Modifier = Modifier,
    onPrev: () -> Unit,
    onFavorite: () -> Unit,
    onDetails: () -> Unit,
) {
    val categories = listOf("Все", "Outdoor", "Tennis", "Running")

    Scaffold { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Background)
                .padding(paddingValues)
                .padding(horizontal = 20.dp)
        ) {
            Column(
                modifier.fillMaxSize()
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
                        text = "Outdoor",
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
                            painter = AppIcons.HeartOutline(),
                            modifier = modifier.size(24.dp),
                            contentDescription = null,
                            colorFilter = ColorFilter.tint(com.example.matule.ui.theme.Text)
                        )
                    }
                }
                Spacer(modifier = modifier.height(16.dp))
                Text(
                    text = "Категории",
                    fontFamily = fontFamily,
                    color = com.example.matule.ui.theme.Text,
                    fontSize = 16.sp,
                    lineHeight = 16.sp,
                    letterSpacing = 0.sp

                )
                Spacer(modifier = modifier.height(19.dp))
                LazyRow(
                    modifier = modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(16.dp),
                ) {
                    items(categories.size) { category ->
                        Box(
                            modifier = modifier
                                .size(108.dp, 40.dp)
                                .background(Block, RoundedCornerShape(8.dp))
                                .clip(RoundedCornerShape(8.dp)),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = categories[category],
                                fontFamily = fontFamily,
                                fontSize = 12.sp,
                                lineHeight = 12.sp,
                                letterSpacing = 1.sp
                            )
                        }
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
                            onDetails = { onDetails() }
                        )
                    }
                }
            }
        }
    }
}

/** Автор: Шадрин Роман Алексеевич
 *
 * Дата создания: 26.02.2025
 *
 * Функция отвечает за отображение активности Catalog на превью
 * **/
@Preview(
    showBackground = true,
    name = "Catalog"
)
@Composable
private fun CatalogPreview() {
    Catalog(
        onPrev = {},
        onFavorite = {},
        onDetails = {}
    )
}