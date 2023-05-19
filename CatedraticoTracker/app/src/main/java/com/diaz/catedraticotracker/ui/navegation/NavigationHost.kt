package com.diaz.catedraticotracker.ui.navegation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.diaz.catedraticotracker.ui.catedraticos.AddCatedraticoScreen
import com.diaz.catedraticotracker.ui.catedraticos.CatedraticosScreen


@Composable
fun NavigationHost() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "catedraticos_screen") {
        composable("catedraticos_screen") {
            CatedraticosScreen(navController)
        }
        composable("add_catedratico_screen") {
            AddCatedraticoScreen(navController)
        }
    }
}