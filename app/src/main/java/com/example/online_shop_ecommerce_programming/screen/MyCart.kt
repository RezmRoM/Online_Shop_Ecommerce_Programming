package com.example.matule.screen

import androidx.compose.foundation.Canvas
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.matule.components.MyCartProduct
import com.example.matule.components.NotificationCard
import com.example.matule.ui.theme.Accent
import com.example.matule.ui.theme.Background
import com.example.matule.ui.theme.Block
import com.example.matule.ui.theme.SubTextDark
import com.example.matule.ui.theme.fontFamily
import com.example.matule.utils.AppIcons

/** Автор: Шадрин Роман Алексеевич
 *
 * Дата создания: 27.02.2025
 *
 * Функция отвечает за отрисовку активности MyCart
 * **/

// Создаем класс для хранения данных о товаре в корзине
data class CartItem(
    val id: Int,
    val title: String,
    val price: String,
    val quantity: Int = 1,
    val image: @Composable () -> Unit
)

@Composable
fun MyCart(
    modifier: Modifier = Modifier,
    onPrev: () -> Unit,
    onCheckout: () -> Unit,
) {
    // Создаем список товаров в корзине
    val cartItems = remember {
        mutableStateListOf(
            CartItem(
                id = 1,
                title = "Nike Club Max",
                price = "₽584.95",
                quantity = 1,
                image = { AppIcons.BlueBlueNike() }
            ),
            CartItem(
                id = 2,
                title = "Nike Air Max 200",
                price = "₽94.05",
                quantity = 1,
                image = { AppIcons.RedNike() }
            ),
            CartItem(
                id = 3,
                title = "Nike Air Max 270 Essential",
                price = "₽74.95",
                quantity = 1,
                image = { AppIcons.BlackNike() }
            )
        )
    }
    
    // Общая сумма без доставки
    val subtotal = remember(cartItems) {
        mutableStateOf(cartItems.sumOf { item -> 
            val priceWithoutCurrency = item.price.replace("₽", "").toDouble()
            priceWithoutCurrency * item.quantity
        })
    }
    
    // Стоимость доставки
    val shippingCost = 60.20
    
    // Общая сумма с доставкой
    val total = remember(subtotal.value) {
        mutableStateOf(subtotal.value + shippingCost)
    }

    // Получаем ширину экрана
    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp.dp - 40.dp // учитываем отступы по 20dp с каждой стороны

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
                        text = "Корзина",
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
                    text = "${cartItems.size} товара",
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
                    items(cartItems) { item ->
                        MyCartProduct(
                            title = item.title,
                            price = item.price,
                            initialQuantity = item.quantity,
                            onRemove = {
                                cartItems.remove(item)
                                subtotal.value = cartItems.sumOf { 
                                    val priceWithoutCurrency = it.price.replace("₽", "").toDouble()
                                    priceWithoutCurrency * it.quantity
                                }
                                total.value = subtotal.value + shippingCost
                            },
                            onQuantityChange = { newQuantity ->
                                val index = cartItems.indexOf(item)
                                if (index != -1) {
                                    cartItems[index] = item.copy(quantity = newQuantity)
                                    subtotal.value = cartItems.sumOf { 
                                        val priceWithoutCurrency = it.price.replace("₽", "").toDouble()
                                        priceWithoutCurrency * it.quantity
                                    }
                                    total.value = subtotal.value + shippingCost
                                }
                            }
                        )
                    }
                }
            }
            Box(
                modifier = modifier
                    .fillMaxWidth()
                    .height(258.dp)
                    .background(Block)
                    .align(Alignment.BottomCenter)
            ) {
                Column(
                    modifier = modifier
                        .fillMaxSize()
                        .padding(horizontal = 20.dp)
                        .padding(top = 36.dp)
                ) {
                    Row(
                        modifier = modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Сумма",
                            fontFamily = fontFamily,
                            fontSize = 16.sp,
                            lineHeight = 16.sp,
                            letterSpacing = 0.sp,
                            color = SubTextDark,
                        )
                        Text(
                            text = "₽${String.format("%.2f", subtotal.value)}",
                            fontFamily = fontFamily,
                            fontSize = 16.sp,
                            lineHeight = 16.sp,
                            letterSpacing = 0.sp,
                            color = com.example.matule.ui.theme.Text,
                        )
                    }
                    Spacer(modifier = modifier.height(10.dp))
                    Row(
                        modifier = modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Доставка",
                            fontFamily = fontFamily,
                            fontSize = 16.sp,
                            lineHeight = 20.sp,
                            letterSpacing = 0.sp,
                            color = SubTextDark,
                        )
                        Text(
                            text = "₽${String.format("%.2f", shippingCost)}",
                            fontFamily = fontFamily,
                            fontSize = 16.sp,
                            lineHeight = 16.sp,
                            letterSpacing = 0.sp,
                            color = com.example.matule.ui.theme.Text,
                        )
                    }
                    
                    // Адаптивная пунктирная линия
                    Spacer(modifier = modifier.height(18.dp))
                    Canvas(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(6.dp)
                    ) {
                        val pathEffect = PathEffect.dashPathEffect(
                            floatArrayOf(18f, 18f), // длина черты и длина пробела
                            0f // смещение
                        )
                        drawLine(
                            color = SubTextDark,
                            start = Offset(0f, 0f),
                            end = Offset(size.width, 0f),
                            strokeWidth = 6f,
                            pathEffect = pathEffect
                        )
                    }
                    
                    Spacer(modifier = modifier.height(14.dp))
                    Row(
                        modifier = modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Итого",
                            fontFamily = fontFamily,
                            fontSize = 16.sp,
                            lineHeight = 20.sp,
                            letterSpacing = 0.sp,
                            color = com.example.matule.ui.theme.Text,
                        )
                        Text(
                            text = "₽${String.format("%.2f", total.value)}",
                            fontFamily = fontFamily,
                            fontSize = 16.sp,
                            lineHeight = 16.sp,
                            letterSpacing = 0.sp,
                            color = Accent,
                        )
                    }
                    Spacer(modifier = modifier.weight(1f))
                    Button(
                        onClick = { onCheckout() },
                        shape = RoundedCornerShape(13.dp),
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(82.dp)
                            .padding(bottom = 32.dp),
                        colors = ButtonColors(
                            disabledContainerColor = Accent,
                            disabledContentColor = Accent,
                            containerColor = Accent,
                            contentColor = Accent,
                        )
                    ) {
                        Text(
                            text = "Оформить заказ",
                            fontFamily = fontFamily,
                            letterSpacing = 0.sp,
                            lineHeight = 22.sp,
                            fontSize = 14.sp,
                            color = Block
                        )
                    }
                }
            }
        }
    }
}

/** Автор: Шадрин Роман Алексеевич
 *
 * Дата создания: 27.02.2025
 *
 * Функция отвечает за отображение активности MyCart на превью
 * **/
@Preview(
    showBackground = true,
    name = "MyCart"
)
@Composable
private fun MyCartPreview() {
    MyCart(
        onPrev = {},
        onCheckout = {},
    )
}