package com.diaz.catedraticotracker.ui.catedraticos

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.diaz.catedraticotracker.data.CatedraticoModel

@Composable
fun CatedraticosScreen(navController: NavHostController, viewModelCate: CatedraticoViewModel) {


    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = { navController.navigate("add_catedratico_screen") }) {

            }
        }
    ) {
        Box(modifier = Modifier.padding(it)) {
            CatedraticoScreenSection(viewModelCate, navController)
        }

    }
}

@Composable
fun CatedraticoScreenSection(viewModelCate: CatedraticoViewModel, navController: NavHostController) {
    viewModelCate.getCatedraticos()
    val catedraticosList = viewModelCate.catedraticosList.observeAsState(emptyList())

    LazyColumn(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxSize()
    ) {
        items(catedraticosList.value) {
            CatedraticoCard(it, navController)
        }
    }
}


@Composable
fun CatedraticoCard(catedratico: CatedraticoModel, navController: NavHostController) {
    val cateId = catedratico.id
    Card(modifier = Modifier
        .padding(8.dp)
        .clickable {
            navController.navigate("catedraticoInfo/${catedratico.id}")
        }) {
        Column(modifier = Modifier.padding(8.dp)) {
            Text(text = catedratico.nombre)
            Text(text = catedratico.apellido)
            Text(text = catedratico.titulo)
        }

    }
}


