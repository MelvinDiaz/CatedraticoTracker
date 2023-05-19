package com.diaz.catedraticotracker.ui.navegation

import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.diaz.catedraticotracker.ui.catedraticos.AddCatedraticoScreen
import com.diaz.catedraticotracker.ui.catedraticos.CatedraticoInfo
import com.diaz.catedraticotracker.ui.catedraticos.CatedraticoViewModel
import com.diaz.catedraticotracker.ui.catedraticos.CatedraticosScreen


@Composable
fun NavigationHost(viewModelCate: CatedraticoViewModel) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "catedraticos_screen") {
        composable("catedraticos_screen") {
            CatedraticosScreen(navController, viewModelCate)
        }
        composable("add_catedratico_screen") {
            AddCatedraticoScreen(navController, viewModelCate)
        }
        composable("catedraticoInfo/{catedraticoId}",
            arguments = listOf(
                navArgument("catedraticoId") {
                    type = NavType.IntType
                }
            )
        ) {
            val cateId = it.arguments?.getInt("catedraticoId")
            if (cateId != null) {
                val catedratico = viewModelCate.getCatedraticoById(cateId)
                if (catedratico != null) {
                    CatedraticoInfo(catedratico)
                }
            }
        }
    }
}