package com.example.matule.screen

import BottomBar
import android.widget.ImageButton
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
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
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.matule.components.ProductCard
import com.example.matule.ui.theme.Accent
import com.example.matule.ui.theme.Background
import com.example.matule.ui.theme.Block
import com.example.matule.ui.theme.Hint
import com.example.matule.ui.theme.Red
import com.example.matule.ui.theme.fontFamily
import com.example.matule.utils.AppIcons
import com.example.matule.utils.StringResources

/** Автор: Шадрин Роман Алексеевич
 *
 * Дата создания: 26.02.2025
 *
 * Функция отвечает за отрисовку активности Home
 * **/
@Composable
fun Home(
    modifier: Modifier = Modifier,
    onPopular: () -> Unit,
    onCatalog: () -> Unit,
    onHome: () -> Unit,
    onFavorite: () -> Unit,
    onNotification: () -> Unit,
    onProfile: () -> Unit,
    onDetails: () -> Unit,
    onSearch: () -> Unit,
    onMyCart: () -> Unit,
    onSideMenu: () -> Unit,
) {
    var search by rememberSaveable { mutableStateOf("") }
    val categories = listOf("Все", "Outdoor", "Tennis", "Running")

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
                Row(
                    modifier = modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    IconButton (
                        onClick = { onSideMenu() }
                    ) {
                        Image(
                            painter = AppIcons.Menu(),
                            contentDescription = null
                        )
                    }

                    Text(
                        text = "Главная",
                        fontFamily = fontFamily,
                        fontSize = 32.sp,
                        lineHeight = 32.sp,
                        letterSpacing = 0.sp,
                        color = com.example.matule.ui.theme.Text,
                        textAlign = TextAlign.Center,
                    )
                    Box(
                        modifier = modifier
                            .size(44.dp)
                            .background(Block, CircleShape)
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
                Spacer(modifier = modifier.height(21.dp))
                Row(
                    modifier = modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    OutlinedTextField(
                        keyboardActions = KeyboardActions {
                            onSearch()
                        },
                        keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Text),
                        modifier = Modifier
                            .size(269.dp, 52.dp)
                            .clickable {
                                onSearch()
                            },
                        shape = RoundedCornerShape(14.dp),
                        onValueChange = { search = it },
                        colors = OutlinedTextFieldDefaults.colors(
                            unfocusedContainerColor = Block,
                            focusedContainerColor = Block,
                            unfocusedBorderColor = Block,
                            focusedBorderColor = Block
                        ),
                        placeholder = {
                            Text(
                                text = StringResources.PromptSearch,
                                fontFamily = fontFamily,
                                letterSpacing = 0.sp,
                                lineHeight = 16.sp,
                                fontSize = 14.sp,
                                color = Hint,
                            )
                        },
                        singleLine = true,
                        value = search,
                        leadingIcon = {
                            Image(
                                painter = AppIcons.Search(),
                                contentDescription = null,
                                modifier = modifier.size(15.dp)
                            )
                        },
                    )
                    Box(
                        modifier = modifier
                            .size(52.dp)
                            .background(Accent, CircleShape),
                        contentAlignment = Alignment.Center
                    ) {
                        Image(
                            painter = AppIcons.Shuffle(),
                            contentDescription = null,
                            colorFilter = ColorFilter.tint(Block)
                        )
                    }
                }
                Spacer(modifier = modifier.height(22.dp))
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
                                .clip(RoundedCornerShape(8.dp))
                                .clickable {
                                    onCatalog()
                                },
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
                Spacer(modifier = modifier.height(24.dp))
                Row(
                    modifier = modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Популярное",
                        fontSize = 16.sp,
                        lineHeight = 24.sp,
                        fontFamily = fontFamily,
                        letterSpacing = 0.sp,
                        color = com.example.matule.ui.theme.Text
                    )
                    Text(
                        text = "Все",
                        fontSize = 12.sp,
                        lineHeight = 16.sp,
                        fontFamily = fontFamily,
                        letterSpacing = 0.sp,
                        color = Accent,
                        modifier = modifier.clickable {
                            onPopular()
                        }
                    )
                }
                Spacer(modifier = modifier.height(30.dp))
                LazyRow(
                    modifier = modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                ) {
                    item {
                        ProductCard(onDetails = onDetails)
                    }
                    item {
                        ProductCard(
                            onDetails = onDetails,
                            rightIcon = {
                                Image(
                                    painter = AppIcons.Cart(),
                                    modifier = Modifier.size(12.dp),
                                    contentDescription = null,
                                    colorFilter = ColorFilter.tint(Block)
                                )
                            },
                        )
                    }
                }
                Spacer(modifier = modifier.height(29.dp))
                Row(
                    modifier = modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Акции",
                        fontSize = 16.sp,
                        lineHeight = 24.sp,
                        fontFamily = fontFamily,
                        letterSpacing = 0.sp,
                        color = com.example.matule.ui.theme.Text
                    )
                    Text(
                        text = "Все",
                        fontSize = 12.sp,
                        lineHeight = 16.sp,
                        fontFamily = fontFamily,
                        letterSpacing = 0.sp,
                        color = Accent,
                        modifier = modifier.clickable {

                        }
                    )
                }
                Spacer(modifier = modifier.height(20.dp))
                Image(
                    painter = AppIcons.Sale(),
                    contentDescription = null,
                    modifier = modifier.fillMaxWidth(),
                    contentScale = ContentScale.Crop
                )
                Spacer(modifier = modifier.height(108.dp))
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

/**
 * Автор: Шадрин Роман Алексеевич
 *
 *  Дата создания: 26.02.2025
 * Функция HomePreview() не принимает параметров и предназначена для просмотра предварительного просмотрав Android Studio
 *
 * В ней находится вызов функции Home()
 */
@Preview(
    showBackground = true,
    name = "Home"
)
@Composable
private fun HomePreview() {
    Home(
        onPopular = {},
        onCatalog = {},
        onHome = {},
        onFavorite = {},
        onNotification = {},
        onProfile = {},
        onDetails = {},
        onSearch = {},
        onMyCart = {},
        onSideMenu = {},
    )
}