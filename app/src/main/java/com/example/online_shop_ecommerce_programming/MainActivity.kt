package com.example.matule

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.matule.navigation.NavGraph

/**
 * Автор: Шадрин Роман Алексеевич
 *
 * Функция MainActivity не принимает параметров
 *
 * 1. В ней находится логика для настройки навигации
 * 2. Вызов NavGraph в котором прописаны все пути для активностей
 */
class MainActivity : ComponentActivity() {
    private lateinit var navController : NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            navController = rememberNavController()
            NavGraph.SetupNavGraph(navController = navController as NavHostController)
        }
    }
}