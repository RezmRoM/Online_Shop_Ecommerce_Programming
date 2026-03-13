package com.example.matule.components

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.AnimationSpec
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.SpringSpec
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.FractionalThreshold
import androidx.compose.material.SwipeableState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.rememberSwipeableState
import androidx.compose.material.swipeable
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.matule.R
import com.example.matule.ui.theme.Accent
import com.example.matule.ui.theme.Background
import com.example.matule.ui.theme.Block
import com.example.matule.ui.theme.fontFamily
import com.example.matule.utils.AppIcons
import kotlinx.coroutines.launch
import kotlin.math.abs
import kotlin.math.roundToInt

// Определение цветов для свайпа по Figma дизайну
private val SwipeBlueColor = Color(0xFF48ABE7)
private val SwipeRedColor = Color(0xFFF87265)

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MyCartProduct(
    modifier: Modifier = Modifier,
    title: String,
    price: String,
    onRemove: () -> Unit = {},
    onQuantityChange: (Int) -> Unit = {},
    initialQuantity: Int = 1
) {
    var quantity by remember { mutableStateOf(initialQuantity) }
    val density = LocalDensity.current
    val coroutineScope = rememberCoroutineScope()
    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp.dp
    
    // Определение размеров свайпа
    val swipeableState = rememberSwipeableState(initialValue = 0)
    val swipeWidth = screenWidth.value * 0.1f // 10% от ширины экрана для адаптивности
    val sizePx = with(density) { swipeWidth.dp.toPx() }
    val anchors = mapOf(
        -sizePx to -1, // Свайп влево (удаление)
        0f to 0,       // Нейтральное положение
        sizePx to 1    // Свайп вправо (изменение количества)
    )
    
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(104.dp)
    ) {
        // Фон для свайпа влево (удаление) - красный с иконкой корзины
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Transparent)
        ) {
            // Красный прямоугольник для удаления
            Box(
                modifier = Modifier
                    .align(Alignment.CenterEnd)
                    .width(58.dp)
                    .height(104.dp)
                    .background(SwipeRedColor, RoundedCornerShape(8.dp))
                    .clickable { 
                        // Удаление происходит при нажатии на красный прямоугольник
                        if (swipeableState.currentValue == -1) {
                            onRemove()
                        }
                    },
                contentAlignment = Alignment.Center
            ) {
                // Используем новую иконку корзины
                Image(
                    painter = AppIcons.Delete(),
                    contentDescription = "Удалить",
                    colorFilter = ColorFilter.tint(Color.White),
                    modifier = Modifier.size(24.dp)
                )
            }
        }
        
        // Фон для свайпа вправо (изменение количества) - голубой с белыми кнопками
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Transparent)
        ) {
            // Голубой прямоугольник для изменения количества
            Box(
                modifier = Modifier
                    .align(Alignment.CenterStart)
                    .width(58.dp)
                    .height(104.dp)
                    .background(SwipeBlueColor, RoundedCornerShape(8.dp)),
                contentAlignment = Alignment.Center
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    // Кнопка плюс
                    IconButton(
                        onClick = {
                                quantity++
                                onQuantityChange(quantity)
                        },
                    ) {
                        Image(
                            painter = AppIcons.Plus(),
                            colorFilter = ColorFilter.tint(Color.White),
                            contentDescription = "Увеличить",
                            modifier = Modifier.size(14.dp)
                        )
                    }

                    // Количество
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = quantity.toString(),
                        fontFamily = fontFamily,
                        fontSize = 14.sp,
                        color = Color.White
                    )
                    // Кнопка минус
                    IconButton(
                        onClick = {
                            if (quantity > 1) {
                                quantity--
                                onQuantityChange(quantity)
                            }
                        },
                    ) {
                        Image(
                            painter = AppIcons.Minus(),
                            colorFilter = ColorFilter.tint(Color.White),
                            contentDescription = "Уменьшить",
                            modifier = Modifier.size(14.dp)
                        )
                    }
                }
            }
        }
        
        // Основной контент (карточка товара)
        Box(
            modifier = Modifier
                .width(
                    // При свайпе устанавливаем ширину 257.dp, иначе fillMaxWidth
                    if (swipeableState.offset.value != 0f) 257.dp
                    else screenWidth - 40.dp // -40.dp для отступов по 20dp с каждой стороны
                )
                .height(104.dp)
                .align(Alignment.Center)
                .offset { IntOffset(swipeableState.offset.value.roundToInt(), 0) }
                .swipeable(
                    state = swipeableState,
                    anchors = anchors,
                    thresholds = { _, _ -> FractionalThreshold(0.3f) },
                    orientation = Orientation.Horizontal
                )
                .background(Block, RoundedCornerShape(8.dp))
                .clickable {
                    // Убираем действие удаления при клике на карточку
                    // При свайпе вправо и клике возвращаем в нейтральное положение
                    if (swipeableState.currentValue != 0) {
                        coroutineScope.launch {
                            swipeableState.animateTo(0)
                        }
                    }
                }
        ) {
            Row(
                modifier = Modifier.fillMaxSize(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
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
                Spacer(modifier = Modifier.width(16.dp))
                Column {
                    Text(
                        text = title,
                        fontFamily = fontFamily,
                        fontSize = 16.sp,
                        lineHeight = 16.sp,
                        letterSpacing = 0.sp,
                        color = com.example.matule.ui.theme.Text,
                    )
                    Text(
                        text = price,
                        fontFamily = fontFamily,
                        fontSize = 14.sp,
                        lineHeight = 16.sp,
                        letterSpacing = 0.sp,
                        color = com.example.matule.ui.theme.Text,
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
 * В ней находится вызов функции MyCartProduct()
 */
@Preview(
    showBackground = true,
    name = "MyCartProduct"
)
@Composable
private fun MyCartProductPreview() {
    MyCartProduct(
        title = "Nike Club Max",
        price = "₽584.95"
    )
}