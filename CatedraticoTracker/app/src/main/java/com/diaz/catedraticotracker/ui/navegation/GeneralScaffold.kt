package com.diaz.catedraticotracker.ui.navegation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.diaz.catedraticotracker.ui.catedraticos.CatedraticoViewModel

@Composable
fun GeneralScaffold(viewModelCate: CatedraticoViewModel) {
    val navHostController = rememberNavController()
    Scaffold(
        topBar = { Text(text = "Catedraticos")},
    ) {
        Box(modifier = Modifier.padding(it)){
            NavigationHost(viewModelCate)
        }
    }
}