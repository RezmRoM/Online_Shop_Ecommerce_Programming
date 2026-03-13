package com.example.matule.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.matule.screen.Catalog
import com.example.matule.screen.Checkout
import com.example.matule.screen.Delivery
import com.example.matule.screen.DetailOrder
import com.example.matule.screen.Details
import com.example.matule.screen.EditProfile
import com.example.matule.screen.Favorite
import com.example.matule.screen.ForgotPassword
import com.example.matule.screen.Home
import com.example.matule.screen.Log_In
import com.example.matule.screen.MyCart
import com.example.matule.screen.Notification
import com.example.matule.screen.OnboardingFirst
import com.example.matule.screen.OnboardingSecond
import com.example.matule.screen.OnboardingThird
import com.example.matule.screen.Popular
import com.example.matule.screen.Profile
import com.example.matule.screen.Registration
import com.example.matule.screen.Search
import com.example.matule.screen.SideMenu
import com.example.matule.screen.Splash
import com.example.matule.screen.Verification

/**
 * Автор: Шадрин Роман Алексеевич
 *
 * Объект NavGraph
 *
 * В нём находится:
 * 1. логика переходов между активностями
 * 2. Обработка параметров вызванных функций
 */
object NavGraph {
    @Composable
    fun SetupNavGraph(navController: NavHostController) {
        NavHost(
            navController = navController,
            startDestination = Screen.Splash,
//            enterTransition = { slideInHorizontally { it } },
//            exitTransition = { slideOutHorizontally { -it } },
//            popEnterTransition = { slideInHorizontally { -it } },
//            popExitTransition = { slideOutHorizontally { it } },
        ) {
            composable<Screen.Splash> {
                Splash(
                    onNext = {
                        navController.navigate(Screen.OnboardingFirst)
                    }
                )
            }
            composable<Screen.OnboardingFirst> {
                OnboardingFirst(
                    onStartClick = { navController.navigate(Screen.OnboardingSecond) }
                )
            }
            composable<Screen.OnboardingSecond> {
                OnboardingSecond(
                    onNextClick = { navController.navigate(Screen.OnboardingThird) }
                )
            }
            composable<Screen.OnboardingThird> {
                OnboardingThird(
                    onNextClick = { navController.navigate(Screen.Log_In) }
                )
            }
            composable<Screen.Log_In> {
                Log_In(
                    onLogInClick = { navController.navigate(Screen.Home) },
                    onResetClick = { navController.navigate(Screen.ForgotPassword) },
                    onNewUserClick = { navController.navigate(Screen.Registration) },
                    onPrev = { navController.navigateUp() },
                )
            }
            composable<Screen.Home> {
                Home(
                    onPopular = { navController.navigate(Screen.Popular) },
                    onCatalog = { navController.navigate(Screen.Catalog) },
                    onHome = { navController.navigate(Screen.Home) },
                    onFavorite = { navController.navigate(Screen.Favorite) },
                    onNotification = { navController.navigate(Screen.Notification) },
                    onProfile = { navController.navigate(Screen.Profile) },
                    onDetails = { navController.navigate(Screen.Details) },
                    onSearch = { navController.navigate(Screen.Search) },
                    onMyCart = { navController.navigate(Screen.MyCart) },
                    onSideMenu = { navController.navigate(Screen.SideMenu) },
                )
            }
            composable<Screen.Popular> {
                Popular(
                    onPrev = { navController.navigateUp() },
                    onDetails = { navController.navigate(Screen.Details) },
                )
            }
            composable<Screen.Catalog> {
                Catalog(
                    onPrev = { navController.navigateUp() },
                    onFavorite = { navController.navigate(Screen.Favorite) },
                    onDetails = { navController.navigate(Screen.Details) }
                )
            }
            composable<Screen.Favorite> {
                Favorite(
                    onPrev = { navController.navigateUp() },
                    onFavorite = { navController.navigate(Screen.Favorite) },
                    onHome = { navController.navigate(Screen.Home) },
                    onDetails = { navController.navigate(Screen.Details) },
                    onNotification = { navController.navigate(Screen.Notification) },
                    onProfile = { navController.navigate(Screen.Profile) },
                    onMyCart = { navController.navigate(Screen.MyCart) },
                )
            }
            composable<Screen.Details> {
                Details(
                    onPrev = { navController.navigateUp() },
                    onMyCart = { navController.navigate(Screen.MyCart) },
                )
            }
            composable<Screen.Search> {
                Search()
            }
            composable<Screen.MyCart> {
                MyCart(
                    onPrev = { navController.navigateUp() },
                    onCheckout = { navController.navigate(Screen.Checkout) },
                )
            }
            composable<Screen.Registration> {
                Registration(
                    onRegisterClick = { navController.navigate(Screen.Home) },
                    onLogIn = { navController.navigate(Screen.Log_In) },
                    onPrev = { navController.navigateUp() },
                )
            }
            composable<Screen.ForgotPassword> {
                ForgotPassword(
                    onPrev = { navController.navigateUp() },
                    onVerification = { navController.navigate(Screen.Verification) }
                )
            }
            composable<Screen.Verification> {
                Verification(
                    onPrev = { navController.navigateUp() },
                    onHome = { navController.navigate(Screen.Home) },
                )
            }
            composable<Screen.Checkout> {
                Checkout(
                    onPrev = { navController.navigateUp() },
                )
            }
            composable<Screen.SideMenu> {
                SideMenu(
                    onProfile = { navController.navigate(Screen.Profile) },
                    onCart = { navController.navigate(Screen.MyCart) },
                    onFavorite = { navController.navigate(Screen.Favorite) },
                    onDelivery = { navController.navigate(Screen.Delivery) },
                    onNotification = { navController.navigate(Screen.Notification) },
                    onLogOut = { navController.navigate(Screen.Log_In) }
                )
            }
            composable<Screen.Profile> {
                Profile(
                    onSideMenu = { navController.navigate(Screen.SideMenu) },
                    onHome = { navController.navigate(Screen.Home) },
                    onFavorite = { navController.navigate(Screen.Favorite) },
                    onNotification = { navController.navigate(Screen.Notification) },
                    onProfile = { navController.navigate(Screen.Profile) },
                    onEditProfile = { navController.navigate(Screen.EditProfile) },
                    onMyCart = { navController.navigate(Screen.MyCart) },
                )
            }
            composable<Screen.EditProfile> {
                EditProfile(
                    onHome = { navController.navigate(Screen.Home) },
                    onFavorite = { navController.navigate(Screen.Favorite) },
                    onNotification = { navController.navigate(Screen.Notification) },
                    onProfile = { navController.navigate(Screen.Profile) },
                    onMyCart = { navController.navigate(Screen.MyCart) },
                )
            }
            composable<Screen.Notification> {
                Notification(
                    onSideMenu = { navController.navigate(Screen.SideMenu) },
                    onHome = { navController.navigate(Screen.Home) },
                    onFavorite = { navController.navigate(Screen.Favorite) },
                    onNotification = { navController.navigate(Screen.Notification) },
                    onProfile = { navController.navigate(Screen.Profile) },
                    onMyCart = { navController.navigate(Screen.MyCart) },
                )
            }
            composable<Screen.Delivery> {
                Delivery(
                    onPrev = { navController.navigateUp() },
                    onMyOrderProductClick = { navController.navigate(Screen.DetailOrder) }
                )
            }
            composable<Screen.DetailOrder> {
                DetailOrder(
                    onPrev = { navController.navigateUp() },
                )
            }
        }
    }
}
