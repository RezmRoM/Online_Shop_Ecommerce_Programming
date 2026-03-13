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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.matule.ui.theme.Accent
import com.example.matule.ui.theme.Background
import com.example.matule.ui.theme.Block
import com.example.matule.ui.theme.Hint
import com.example.matule.ui.theme.SubTextDark
import com.example.matule.ui.theme.fontFamily
import com.example.matule.utils.AppIcons

/** Автор: Шадрин Роман Алексеевич
 *
 * Дата создания: 27.02.2025
 *
 * Функция отвечает за отрисовку активности Checkout
 * **/
@Composable
fun Checkout(
    modifier: Modifier = Modifier,
    onPrev: () -> Unit,
) {
    var showDialog by rememberSaveable { mutableStateOf(false) }

    Scaffold { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Background)
                .padding(paddingValues)
                .verticalScroll(rememberScrollState())
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
                Spacer(modifier = modifier.height(46.dp))
                Column(
                    modifier
                        .fillMaxWidth()
                        .background(Block, RoundedCornerShape(16.dp))
                        .padding(horizontal = 20.dp)
                        .padding(vertical = 16.dp)
                ) {
                    Spacer(modifier = modifier.height(16.dp))
                    Text(
                        text = "Контактная информация",
                        fontFamily = fontFamily,
                        fontSize = 14.sp,
                        lineHeight = 20.sp,
                        letterSpacing = 0.sp,
                        color = com.example.matule.ui.theme.Text,
                        textAlign = TextAlign.Center,
                    )
                    Spacer(modifier = modifier.height(16.dp))
                    Row(
                        modifier = modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Box(
                            modifier = modifier
                                .size(40.dp)
                                .background(Background, RoundedCornerShape(12.dp))
                                .clip(RoundedCornerShape(12.dp)),
                            contentAlignment = Alignment.Center
                        ) {
                            Image(
                                painter = AppIcons.Email(),
                                contentDescription = null
                            )
                        }
                        Spacer(modifier = modifier.width(12.dp))
                        Column {
                            Text(
                                text = "emmanuel@gmail.com",
                                fontFamily = fontFamily,
                                fontSize = 14.sp,
                                lineHeight = 20.sp,
                                letterSpacing = 0.sp,
                                color = com.example.matule.ui.theme.Text,
                                textAlign = TextAlign.Center,
                            )
                            Spacer(modifier = modifier.height(4.dp))
                            Text(
                                text = "Email",
                                fontFamily = fontFamily,
                                fontSize = 12.sp,
                                lineHeight = 16.sp,
                                letterSpacing = 0.sp,
                                color = Hint,
                                textAlign = TextAlign.Center,
                            )
                        }
                        Spacer(modifier = modifier.weight(1f))
                        Image(
                            painter = AppIcons.Edit(),
                            contentDescription = null,
                        )
                    }
                    Spacer(modifier = modifier.height(16.dp))
                    Row(
                        modifier = modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Box(
                            modifier = modifier
                                .size(40.dp)
                                .background(Background, RoundedCornerShape(12.dp))
                                .clip(RoundedCornerShape(12.dp)),
                            contentAlignment = Alignment.Center
                        ) {
                            Image(
                                painter = AppIcons.Phone(),
                                contentDescription = null
                            )
                        }
                        Spacer(modifier = modifier.width(12.dp))
                        Column {
                            Text(
                                text = "+234-811-732-5298",
                                fontFamily = fontFamily,
                                fontSize = 14.sp,
                                lineHeight = 20.sp,
                                letterSpacing = 0.sp,
                                color = com.example.matule.ui.theme.Text,
                                textAlign = TextAlign.Center,
                            )
                            Spacer(modifier = modifier.height(4.dp))
                            Text(
                                text = "Телефон",
                                fontFamily = fontFamily,
                                fontSize = 12.sp,
                                lineHeight = 16.sp,
                                letterSpacing = 0.sp,
                                color = Hint,
                                textAlign = TextAlign.Center,
                            )
                        }
                        Spacer(modifier = modifier.weight(1f))
                        Image(
                            painter = AppIcons.Edit(),
                            contentDescription = null,
                        )
                    }
                    Spacer(modifier = modifier.height(12.dp))
                    Column(
                        modifier = modifier.fillMaxWidth()
                    ) {
                        Text(
                            text = "Адрес",
                            fontFamily = fontFamily,
                            fontSize = 14.sp,
                            lineHeight = 20.sp,
                            letterSpacing = 0.sp,
                            color = com.example.matule.ui.theme.Text,
                            textAlign = TextAlign.Center,
                        )
                        Spacer(modifier = modifier.height(12.dp))
                        Row(
                            modifier = modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                text = "1082 Аэропорт, Нигерии",
                                fontFamily = fontFamily,
                                fontSize = 14.sp,
                                lineHeight = 20.sp,
                                letterSpacing = 0.sp,
                                color = com.example.matule.ui.theme.Text,
                                textAlign = TextAlign.Center,
                            )
                            Image(
                                painter = AppIcons.Edit(),
                                contentDescription = null,
                            )
                        }
                    }
                    Spacer(modifier = modifier.height(16.dp))
                    Box(
                        modifier = modifier.fillMaxWidth()
                    ) {
                        Image(
                            painter = AppIcons.Map(),
                            contentDescription = null,
                            modifier = modifier.fillMaxWidth()
                        )
                        Column(
                            modifier = modifier.fillMaxSize(),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Spacer(modifier = modifier.height(19.dp))
                            Text(
                                text = "Посмотреть на карте",
                                fontFamily = fontFamily,
                                fontSize = 20.sp,
                                lineHeight = 23.sp,
                                letterSpacing = 0.sp,
                                fontWeight = FontWeight.W700,
                                color = Block,
                                textAlign = TextAlign.Center,
                            )
                            Spacer(modifier = modifier.height(6.dp))
                            Box(
                                modifier = modifier
                                    .size(36.dp)
                                    .background(Accent, CircleShape)
                                    .clip(CircleShape),
                                contentAlignment = Alignment.Center
                            ) {
                                Image(
                                    painter = AppIcons.Location(),
                                    contentDescription = null
                                )
                            }
                        }
                    }
                    Spacer(modifier = modifier.height(12.dp))
                    Text(
                        text = "Способ оплаты",
                        fontFamily = fontFamily,
                        fontSize = 14.sp,
                        lineHeight = 12.sp,
                        letterSpacing = 0.sp,
                        color = com.example.matule.ui.theme.Text,
                        textAlign = TextAlign.Center,
                    )
                    Spacer(modifier = modifier.height(12.dp))
                    Row(
                        modifier = modifier.fillMaxWidth(),
                    ) {
                        Box(
                            modifier = modifier
                                .size(40.dp)
                                .background(Background, RoundedCornerShape(12.dp))
                                .clip(RoundedCornerShape(12.dp)),
                            contentAlignment = Alignment.Center
                        ) {
                            Image(
                                painter = AppIcons.Bank(),
                                contentDescription = null
                            )
                        }
                        Spacer(modifier = modifier.width(12.dp))
                        Column(
                            modifier = modifier.fillMaxWidth()
                        ) {
                            Text(
                                text = "DbL Card",
                                fontFamily = fontFamily,
                                fontSize = 14.sp,
                                lineHeight = 20.sp,
                                letterSpacing = 0.sp,
                                color = com.example.matule.ui.theme.Text,
                                textAlign = TextAlign.Center,
                            )
                            Spacer(modifier = modifier.height(4.dp))
                            Text(
                                text = "**** **** 0696 4629",
                                fontFamily = fontFamily,
                                fontSize = 12.sp,
                                lineHeight = 16.sp,
                                letterSpacing = 0.sp,
                                color = Hint,
                                textAlign = TextAlign.Center,
                            )
                        }
                        Image(
                            painter = AppIcons.ChevronDown(),
                            contentDescription = null,
                            colorFilter = ColorFilter.tint(Hint)
                        )
                    }
                }
                Spacer(modifier = modifier.height(25.dp))
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
                        lineHeight = 20.sp,
                        letterSpacing = 0.sp,
                        color = SubTextDark,
                    )
                    Text(
                        text = "₽753.95",
                        fontFamily = fontFamily,
                        fontSize = 16.sp,
                        lineHeight = 16.sp,
                        letterSpacing = 0.sp,
                        color = com.example.matule.ui.theme.Text,
                    )
                }
                Spacer(modifier = modifier.height(7.dp))
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
                        text = "₽60.20",
                        fontFamily = fontFamily,
                        fontSize = 16.sp,
                        lineHeight = 16.sp,
                        letterSpacing = 0.sp,
                        color = com.example.matule.ui.theme.Text,
                    )
                }
                Spacer(modifier = modifier.height(25.dp))
                Text(
                    text = "- - - - - - - - - - - - - - - - - - - -",
                    fontFamily = fontFamily,
                    fontSize = 32.sp,
                    lineHeight = 16.sp,
                    letterSpacing = 0.sp,
                    color = SubTextDark
                )
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
                        text = "₽814.15",
                        fontFamily = fontFamily,
                        fontSize = 16.sp,
                        lineHeight = 16.sp,
                        letterSpacing = 0.sp,
                        color = Accent,
                    )
                }
            }
            Button(
                onClick = { showDialog = true },
                shape = RoundedCornerShape(13.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(82.dp)
                    .align(Alignment.BottomCenter)
                    .padding(bottom = 32.dp)
                    .padding(horizontal = 20.dp),
                colors = ButtonColors(
                    disabledContainerColor = Accent,
                    disabledContentColor = Accent,
                    containerColor = Accent,
                    contentColor = Accent,
                )
            ) {
                Text(
                    text = "Подтвердить",
                    fontFamily = fontFamily,
                    letterSpacing = 0.sp,
                    lineHeight = 22.sp,
                    fontSize = 14.sp,
                    color = Block
                )
            }
            if (showDialog) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.Black.copy(alpha = 0.4f))
                        .align(Alignment.Center)
                        .clickable { showDialog = false },
                    contentAlignment = Alignment.Center
                ) {
                    Surface(
                        modifier = Modifier
                            .size(335.dp, 400.dp)
                            .background(Block, RoundedCornerShape(20.dp))
                            .clip(RoundedCornerShape(20.dp))
                    ) {
                        Column(
                            modifier = Modifier.fillMaxSize(),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Column(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(horizontal = 88.dp)
                                    .padding(vertical = 40.dp),
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Box(
                                    modifier = Modifier
                                        .size(134.dp)
                                        .background(Color(0xFFDFEFFF), CircleShape)
                                        .clip(CircleShape),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Image(
                                        painter = AppIcons.Happy(),
                                        contentDescription = null,
                                    )
                                }
                                Spacer(modifier = Modifier.height(34.dp))
                                Text(
                                    modifier = Modifier.align(Alignment.CenterHorizontally),
                                    textAlign = TextAlign.Center,
                                    text = "Вы успешно\nоформили\nзаказ",
                                    fontFamily = fontFamily,
                                    color = com.example.matule.ui.theme.Text,
                                    letterSpacing = 0.sp,
                                    lineHeight = 28.sp,
                                    fontSize = 20.sp
                                )
                                Spacer(modifier = Modifier.height(30.dp))
                                Button(
                                    onClick = { showDialog = true },
                                    shape = RoundedCornerShape(16.dp),
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(48.dp),
                                    colors = ButtonColors(
                                        disabledContainerColor = Accent,
                                        disabledContentColor = Accent,
                                        containerColor = Accent,
                                        contentColor = Accent,
                                    )
                                ) {
                                    Text(
                                        text = "Вернуться\nк покупкам",
                                        fontFamily = fontFamily,
                                        letterSpacing = 0.sp,
                                        lineHeight = 22.sp,
                                        fontSize = 14.sp,
                                        color = Block,
                                        textAlign = TextAlign.Center
                                    )
                                }
                            }
                        }
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
 * Функция отвечает за отображение активности Checkout на превью
 * **/
@Preview(
    showBackground = true,
    name = "Checkout"
)
@Composable
private fun CheckoutPreview() {
    Checkout(
        onPrev = {},
    )
}