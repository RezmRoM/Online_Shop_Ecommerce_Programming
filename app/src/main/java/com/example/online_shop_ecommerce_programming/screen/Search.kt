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
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
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
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.matule.components.ProductCard
import com.example.matule.ui.theme.Background
import com.example.matule.ui.theme.Block
import com.example.matule.ui.theme.Hint
import com.example.matule.ui.theme.Red
import com.example.matule.ui.theme.fontFamily
import com.example.matule.utils.AppIcons
import com.example.matule.utils.StringResources

/** Автор: Шадрин Роман Алексеевич
 *
 * Дата создания: 27.02.2025
 *
 * Функция отвечает за отрисовку активности Search
 * **/
@Composable
fun Search(
    modifier: Modifier = Modifier,
) {
    var search by rememberSaveable { mutableStateOf("") }
    var showSneakers by rememberSaveable { mutableStateOf(true) }

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
                            .clickable { }
                            .align(Alignment.CenterStart),
                        contentAlignment = Alignment.Center
                    ) {
                        Image(
                            painter = AppIcons.ChevronLeft(),
                            contentDescription = null
                        )
                    }
                    Text(
                        text = "Nike Air Max",
                        fontFamily = fontFamily,
                        modifier = modifier.align(Alignment.Center),
                        fontSize = 16.sp,
                        lineHeight = 20.sp,
                        letterSpacing = 0.sp,
                        color = com.example.matule.ui.theme.Text,
                        textAlign = TextAlign.Center,
                    )
                }
                Spacer(modifier = modifier.height(26.dp))
                OutlinedTextField(
                    keyboardActions = KeyboardActions {
                        showSneakers = false
                    },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {
                            showSneakers = false
                        },
                    shape = RoundedCornerShape(14.dp),
                    onValueChange = {
                        search = it
                    },
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
                    trailingIcon = {
                        Image(
                            painter = AppIcons.Microphone(),
                            contentDescription = null,
                            modifier = modifier.size(15.dp)
                        )
                    },
                )
                Spacer(modifier = modifier.height(28.dp))
                if (showSneakers) {
                    Column(
                        modifier.fillMaxWidth(),
                        verticalArrangement = Arrangement.spacedBy(15.dp),
                    ) {
                        Row(
                            modifier = modifier.fillMaxWidth(),
                        ) {
                            Image(
                                painter = AppIcons.Clock(),
                                contentDescription = null,
                            )
                            Spacer(modifier = modifier.width(12.dp))
                            Text(
                                text = "New Shoes",
                                fontFamily = fontFamily,
                                letterSpacing = 0.sp,
                                lineHeight = 16.sp,
                                fontSize = 14.sp,
                                color = com.example.matule.ui.theme.Text,
                            )
                        }
                        Row(
                            modifier = modifier.fillMaxWidth(),
                        ) {
                            Image(
                                painter = AppIcons.Clock(),
                                contentDescription = null,
                            )
                            Spacer(modifier = modifier.width(12.dp))
                            Text(
                                text = "Nike Top Shoes",
                                fontFamily = fontFamily,
                                letterSpacing = 0.sp,
                                lineHeight = 16.sp,
                                fontSize = 14.sp,
                                color = com.example.matule.ui.theme.Text,
                            )
                        }
                        Row(
                            modifier = modifier.fillMaxWidth(),
                        ) {
                            Image(
                                painter = AppIcons.Clock(),
                                contentDescription = null,
                            )
                            Spacer(modifier = modifier.width(12.dp))
                            Text(
                                text = "Nike Air Force",
                                fontFamily = fontFamily,
                                letterSpacing = 0.sp,
                                lineHeight = 16.sp,
                                fontSize = 14.sp,
                                color = com.example.matule.ui.theme.Text,
                            )
                        }
                        Row(
                            modifier = modifier.fillMaxWidth(),
                        ) {
                            Image(
                                painter = AppIcons.Clock(),
                                contentDescription = null,
                            )
                            Spacer(modifier = modifier.width(12.dp))
                            Text(
                                text = "Shoes",
                                fontFamily = fontFamily,
                                letterSpacing = 0.sp,
                                lineHeight = 16.sp,
                                fontSize = 14.sp,
                                color = com.example.matule.ui.theme.Text,
                            )
                        }
                        Row(
                            modifier = modifier.fillMaxWidth(),
                        ) {
                            Image(
                                painter = AppIcons.Clock(),
                                contentDescription = null,
                            )
                            Spacer(modifier = modifier.width(12.dp))
                            Text(
                                text = "Snakers Nike Shoes",
                                fontFamily = fontFamily,
                                letterSpacing = 0.sp,
                                lineHeight = 16.sp,
                                fontSize = 14.sp,
                                color = com.example.matule.ui.theme.Text,
                            )
                        }
                        Row(
                            modifier = modifier.fillMaxWidth(),
                        ) {
                            Image(
                                painter = AppIcons.Clock(),
                                contentDescription = null,
                            )
                            Spacer(modifier = modifier.width(12.dp))
                            Text(
                                text = "Regular Shoes",
                                fontFamily = fontFamily,
                                letterSpacing = 0.sp,
                                lineHeight = 16.sp,
                                fontSize = 14.sp,
                                color = com.example.matule.ui.theme.Text,
                            )
                        }
                    }
                } else {
                    LazyVerticalGrid(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.spacedBy(15.dp),
                        horizontalArrangement = Arrangement.spacedBy(15.dp),
                        columns = GridCells.Fixed(2),
                    ) {
                        items(7) {
                            ProductCard(
                                onDetails = { },
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
            }
        }
    }
}


/**
 * Автор: Шадрин Роман Алексеевич
 *
 * Дата создания: 27.02.2025
 *
 * Функция отвечает за отображение активности Search на превью
 */
@Preview(
    showBackground = true,
    name = "Search"
)
@Composable
private fun SearchPreview() {
    Search()
}