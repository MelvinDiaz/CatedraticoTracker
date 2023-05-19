package com.diaz.catedraticotracker.ui.catedraticos

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.diaz.catedraticotracker.data.CatedraticoModel

@Composable
fun AddCatedraticoScreen(navController: NavHostController, cateViewModel: CatedraticoViewModel) {
    val name: String by cateViewModel.name.observeAsState("")
    val id: Int by cateViewModel.id.observeAsState(0)
    val lastName: String by cateViewModel.lastName.observeAsState("")
    val titulo: String by cateViewModel.titulo.observeAsState("")

    Column(modifier = Modifier.fillMaxWidth().padding(16.dp)) {
        IdTextField(id) { cateViewModel.onAddingChange(name, lastName, it.toInt(), titulo) }
        Spacer(modifier = Modifier.height(16.dp))
        NameTextField(name) { cateViewModel.onAddingChange(it, lastName, id, titulo) }
        Spacer(modifier = Modifier.height(16.dp))
        LastNameTextField(lastName) { cateViewModel.onAddingChange(name, it, id, titulo) }
        Spacer(modifier = Modifier.height(16.dp))
        TituloTextField(titulo) { cateViewModel.onAddingChange(name, lastName, id, it) }
        Spacer(modifier = Modifier.height(16.dp))

        var catedratico = CatedraticoModel(id, name, lastName, titulo)

        Button(onClick = {
            cateViewModel.addCatedratico(catedratico)
            navController.navigateUp()
        }) {

        }
    }

}

@Composable
fun IdTextField(id: Int, onTextFieldChanged: (String) -> Unit) {
    OutlinedTextField(
        value = id.toString(),
        onValueChange = { onTextFieldChanged(it) },
        label = { Text("Id") },
        shape = MaterialTheme.shapes.small,

        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp),

        singleLine = true,

        )
}

@Composable
fun NameTextField(name: String, onTextFieldChanged: (String) -> Unit) {
    OutlinedTextField(
        value = name,
        onValueChange = { onTextFieldChanged(it) },
        label = { Text("Nombre") },
        shape = MaterialTheme.shapes.small,

        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp),

        singleLine = true,

        )
}

@Composable
fun LastNameTextField(lastName: String, onTextFieldChanged: (String) -> Unit) {
    OutlinedTextField(
        value = lastName,
        onValueChange = { onTextFieldChanged(it) },
        label = { Text("Apellido") },
        shape = MaterialTheme.shapes.small,

        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp),

        singleLine = true,

        )
}

@Composable
fun TituloTextField(titulo: String, onTextFieldChanged: (String) -> Unit) {
    OutlinedTextField(
        value = titulo,
        onValueChange = { onTextFieldChanged(it) },
        label = { Text("Titulo") },
        shape = MaterialTheme.shapes.small,

        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp),

        singleLine = true,

        )
}

