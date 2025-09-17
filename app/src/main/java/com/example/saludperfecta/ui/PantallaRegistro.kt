package com.example.saludperfecta.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import java.net.URLEncoder

@Composable
fun PantallaRegistro(navController: NavHostController) {
    var nombre by remember { mutableStateOf("") }
    var telefono by remember { mutableStateOf("") }
    var nombreError by remember { mutableStateOf(false) }
    var telefonoError by remember { mutableStateOf(false) }

    LaunchedEffect(nombre) { nombreError = nombre.trim().split("\\s+".toRegex()).size < 2 }
    LaunchedEffect(telefono) { telefonoError = telefono.length != 10 || !telefono.all { it.isDigit() } }

    val datosValidos = !nombreError && !telefonoError && nombre.isNotBlank() && telefono.isNotBlank()

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            OutlinedTextField(value = nombre, onValueChange = { nombre = it },
                label = { Text("Nombre completo") }, isError = nombreError, modifier = Modifier.fillMaxWidth())
            if (nombreError) Text("Ingrese nombre y apellido.", color = MaterialTheme.colorScheme.error)

            Spacer(modifier = Modifier.height(8.dp))

            OutlinedTextField(value = telefono, onValueChange = { telefono = it },
                label = { Text("Teléfono (10 dígitos)") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                isError = telefonoError,
                modifier = Modifier.fillMaxWidth()
            )
            if (telefonoError) Text("Teléfono inválido.", color = MaterialTheme.colorScheme.error)

            Spacer(modifier = Modifier.height(16.dp))

            Button(onClick = {
                val nombreEnc = URLEncoder.encode(nombre, "UTF-8")
                val telefonoEnc = URLEncoder.encode(telefono, "UTF-8")
                navController.navigate("fechaHora/$nombreEnc/$telefonoEnc")
            }, enabled = datosValidos) {
                Text("Siguiente")
            }
        }
    }
}
