package com.diaz.catedraticotracker.ui.catedraticos

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.diaz.catedraticotracker.data.CatedraticoModel

@Composable
fun CatedraticoInfo(catedratico: CatedraticoModel) {
    Column() {
        Text(text = catedratico.nombre)
        Text(text = catedratico.apellido)
        Text(text = catedratico.id.toString())
        Text(text = catedratico.titulo)
    }
}