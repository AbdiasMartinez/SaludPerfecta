package com.example.saludperfecta.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import java.net.URLDecoder

@Composable
fun PantallaResumen(nombre: String, telefono: String, fechaHora: String) {
    val nombreDec = URLDecoder.decode(nombre, "UTF-8")
    val telefonoDec = URLDecoder.decode(telefono, "UTF-8")
    val fechaHoraDec = URLDecoder.decode(fechaHora, "UTF-8")

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Card(modifier = Modifier.padding(16.dp), elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)) {
            Column(modifier = Modifier.padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally) {
                Icon(imageVector = Icons.Default.CheckCircle, contentDescription = null, modifier = Modifier.size(64.dp))
                Spacer(modifier = Modifier.height(8.dp))
                Text("Cita Confirmada", style = MaterialTheme.typography.headlineSmall)
                Spacer(modifier = Modifier.height(12.dp))
                Text("Nombre: $nombreDec", style = MaterialTheme.typography.bodyLarge)
                Text("Teléfono: $telefonoDec", style = MaterialTheme.typography.bodyLarge)
                Text("Fecha y Hora: $fechaHoraDec", style = MaterialTheme.typography.bodyLarge)
            }
        }
    }
}
