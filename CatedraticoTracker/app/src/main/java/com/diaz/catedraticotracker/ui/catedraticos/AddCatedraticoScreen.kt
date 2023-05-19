package com.diaz.catedraticotracker.ui.catedraticos

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController

@Composable
fun AddCatedraticoScreen(navController: NavHostController) {
    Scaffold(
        floatingActionButton = { navController.navigate("add_catedratico_screen") }
    ) {
        Box(modifier = Modifier.padding(it)) {
            CatedraticoScreenSection()
        }

    }
}

@Composable
fun CatedraticoScreenSection() {

}