package com.example.matule.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.matule.ui.theme.Accent
import com.example.matule.ui.theme.Background
import com.example.matule.ui.theme.Block
import com.example.matule.ui.theme.Hint
import com.example.matule.ui.theme.Red
import com.example.matule.ui.theme.fontFamily
import com.example.matule.utils.AppIcons


/** Автор: Шадрин Роман Алексеевич
 *
 * Дата создания: 27.02.2025
 *
 * Функция отвечает за отрисовку активности Details
 * **/
@Composable
fun Details(
    modifier: Modifier = Modifier,
    onPrev: () -> Unit,
    onMyCart: () -> Unit,
) {
    val sneakers = listOf(
        AppIcons.OrangeNike(),
        AppIcons.RedNike(),
        AppIcons.WhiteBlueNike(),
        AppIcons.BlueNike2(),
        AppIcons.BlackNike(),
        AppIcons.OrangeNike()
    )
    var buttonText by rememberSaveable { mutableStateOf("В корзину") }
    var sneakersSelect by rememberSaveable { mutableStateOf(3) }

    Scaffold { paddingValues ->
        Column(
            modifier = modifier
                .fillMaxSize()
                .background(Background)
                .padding(paddingValues)
        ) {
            Column(
                modifier = modifier
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
                        text = "Sneaker Shop",
                        fontFamily = fontFamily,
                        fontSize = 16.sp,
                        lineHeight = 20.sp,
                        letterSpacing = 0.sp,
                        color = com.example.matule.ui.theme.Text,
                        textAlign = TextAlign.Center,
                    )
                    Box(
                        modifier = modifier
                            .size(44.dp)
                            .background(Block, CircleShape)
                            .clip(CircleShape)
                            .clickable { onMyCart() },
                        contentAlignment = Alignment.Center
                    ) {
                        Image(
                            painter = AppIcons.Bag(),
                            modifier = modifier.size(24.dp),
                            contentDescription = null,
                            colorFilter = ColorFilter.tint(com.example.matule.ui.theme.Text)
                        )
                        Box(
                            modifier = modifier
                                .size(8.dp)
                                .clip(CircleShape)
                                .background(Red, CircleShape)
                                .align(Alignment.TopEnd)
                        )
                    }
                }
                Spacer(modifier = modifier.height(26.dp))
                Text(
                    text = "Nike Air Max 270\nEssential",
                    fontFamily = fontFamily,
                    fontSize = 26.sp,
                    lineHeight = 26.sp,
                    letterSpacing = 0.sp,
                    color = com.example.matule.ui.theme.Text,
                    textAlign = TextAlign.Start,
                )
                Spacer(modifier = modifier.height(13.dp))
                Text(
                    text = "Men’s Shoes",
                    fontFamily = fontFamily,
                    fontSize = 16.sp,
                    lineHeight = 16.sp,
                    letterSpacing = 0.sp,
                    color = Hint,
                    textAlign = TextAlign.Start,
                )
                Spacer(modifier = modifier.height(14.dp))
                Text(
                    text = "₽179.39",
                    fontFamily = fontFamily,
                    fontSize = 24.sp,
                    lineHeight = 24.sp,
                    letterSpacing = 0.sp,
                    color = com.example.matule.ui.theme.Text,
                    textAlign = TextAlign.Start,
                )
                Spacer(modifier = modifier.height(25.dp))
                Box(
                    modifier = modifier.fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = sneakers[sneakersSelect],
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = modifier
                            .height(125.dp)
                            .align(Alignment.Center)
                    )
                    Image(
                        painter = AppIcons.BackgroundSneaker(),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = modifier
                            .height(110.dp)
                            .offset(y = 30.dp)
                            .align(Alignment.Center)
                    )
                }
                Spacer(modifier = modifier.height(79.dp))
                LazyRow(
                    modifier = modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(14.dp),
                ) {
                    itemsIndexed(sneakers) { index, category ->
                        Box(
                            modifier = modifier
                                .size(56.dp)
                                .background(Block, RoundedCornerShape(16.dp))
                                .border(
                                    width = if (sneakersSelect == index) 3.dp else 0.dp,
                                    color = if (sneakersSelect == index) Accent else Color.Transparent,
                                    shape = if (sneakersSelect == index) RoundedCornerShape(16.dp) else RoundedCornerShape(
                                        0.dp
                                    )
                                )
                                .clip(RoundedCornerShape(16.dp))
                                .clickable { sneakersSelect = index },
                            contentAlignment = Alignment.Center
                        ) {
                            Image(
                                painter = sneakers[index],
                                contentDescription = null
                            )
                        }
                    }
                }
                Spacer(modifier = modifier.height(33.dp))
                Text(
                    text = "Вставка Max Air 270 Обеспечивает\nНепревзойденный Комфорт В Течение Всего\nДня. Изящный Дизайн ........",
                    fontFamily = fontFamily,
                    fontSize = 14.sp,
                    lineHeight = 24.sp,
                    letterSpacing = 0.sp,
                    color = Hint,
                    textAlign = TextAlign.Start,
                )
                Spacer(modifier = modifier.height(5.dp))
                Text(
                    text = "Подробнее",
                    fontFamily = fontFamily,
                    fontSize = 14.sp,
                    lineHeight = 21.sp,
                    letterSpacing = 0.sp,
                    color = Accent,
                    modifier = Modifier.align(Alignment.End),
                    textAlign = TextAlign.Start,
                )
                Spacer(modifier = modifier.weight(1f))
                Row(
                    modifier = modifier
                        .fillMaxWidth()
                        .padding(bottom = 36.dp)
                        .padding(horizontal = 20.dp),

                    ) {
                    Box(
                        modifier = modifier
                            .size(52.dp)
                            .background(Color(0xFFD9D9D9).copy(alpha = 0.4f), CircleShape)
                            .clip(CircleShape),
                        contentAlignment = Alignment.Center
                    ) {
                        Image(
                            painter = AppIcons.HeartOutline(),
                            contentDescription = null,
                            colorFilter = ColorFilter.tint(
                                com.example.matule.ui.theme.Text
                            )
                        )
                    }
                    Spacer(modifier = modifier.width(18.dp))
                    Button(
                        onClick = { buttonText = "Добавлено" },
                        shape = RoundedCornerShape(12.dp),
                        modifier = Modifier
                            .fillMaxWidth()
                            .size(265.dp, 52.dp),
                        colors = ButtonColors(
                            disabledContainerColor = Accent,
                            disabledContentColor = Accent,
                            containerColor = Accent,
                            contentColor = Accent,
                        )
                    ) {
                        Row(
                            modifier = modifier.fillMaxSize(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Center
                        ) {
                            Text(
                                text = buttonText,
                                fontFamily = fontFamily,
                                letterSpacing = 0.sp,
                                lineHeight = 22.sp,
                                color = Block,
                                fontSize = 14.sp,
                            )
//                            Icon(
//                                painter = AppIcons.Bag(),
//                                contentDescription = null,
//                            )
                        }
                    }
                }
            }
            Image(
                painter = AppIcons.BlueNike(),
                contentDescription = null,
                contentScale = ContentScale.Crop
            )
        }
    }
}


/** Автор: Шадрин Роман Алексеевич
 *
 * Дата создания: 26.02.2025
 *
 * Функция отвечает за отображение активности Details на превью
 * **/
@Preview(
    showBackground = true,
    name = "Details"
)
@Composable
private fun DetailsPreview() {
    Details(
        onPrev = {},
        onMyCart = {}
    )
}