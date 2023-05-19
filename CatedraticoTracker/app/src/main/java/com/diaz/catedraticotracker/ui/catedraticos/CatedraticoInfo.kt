package com.diaz.catedraticotracker.ui.catedraticos

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.diaz.catedraticotracker.data.CatedraticoModel

@Composable
fun CatedraticoInfo(catedratico: CatedraticoModel) {
    Text(text = catedratico.nombre)
}