package com.example.matule.navigation

import kotlinx.serialization.Serializable

// Интерфейс для определения маршрутов в приложении
sealed interface Screen {
    @Serializable
    data object Splash : Screen

    @Serializable
    data object OnboardingFirst : Screen

    @Serializable
    data object OnboardingSecond : Screen

    @Serializable
    data object OnboardingThird : Screen

    @Serializable
    data object Log_In : Screen

    @Serializable
    data object Home : Screen

    @Serializable
    data object Popular : Screen

    @Serializable
    data object Catalog : Screen

    @Serializable
    data object Favorite : Screen

    @Serializable
    data object Details : Screen

    @Serializable
    data object Search : Screen

    @Serializable
    data object MyCart : Screen

    @Serializable
    data object Registration : Screen

    @Serializable
    data object ForgotPassword : Screen

    @Serializable
    data object Verification : Screen

    @Serializable
    data object Checkout : Screen

    @Serializable
    data object SideMenu : Screen

    @Serializable
    data object Profile : Screen

    @Serializable
    data object EditProfile : Screen

    @Serializable
    data object Notification : Screen

    @Serializable
    data object Delivery : Screen

    @Serializable
    data object DetailOrder : Screen
}