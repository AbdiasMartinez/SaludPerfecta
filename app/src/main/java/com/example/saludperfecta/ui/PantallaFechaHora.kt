package com.example.saludperfecta.ui

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import java.text.SimpleDateFormat
import java.util.*

@Composable
fun PantallaFechaHora(navController: NavHostController, nombre: String, telefono: String) {
    val contexto = LocalContext.current
    val calendario = Calendar.getInstance()

    var fechaSeleccionada by remember { mutableStateOf("") }
    var horaSeleccionada by remember { mutableStateOf("") }

    val datePicker = DatePickerDialog(
        contexto,
        { _, year, month, dayOfMonth ->
            val cal = Calendar.getInstance()
            cal.set(year, month, dayOfMonth)
            fechaSeleccionada = SimpleDateFormat("EEEE, d 'de' MMMM yyyy", Locale("es")).format(cal.time)
        },
        calendario.get(Calendar.YEAR),
        calendario.get(Calendar.MONTH),
        calendario.get(Calendar.DAY_OF_MONTH)
    ).apply { datePicker.minDate = System.currentTimeMillis() }

    val timePicker = TimePickerDialog(
        contexto,
        { _, hour, minute ->
            var h = hour
            var m = when {
                minute < 15 -> 0
                minute < 45 -> 30
                else -> { h += 1; 0 }
            }
            if (h < 8) h = 8
            if (h > 18) h = 18
            horaSeleccionada = String.format("%02d:%02d", h, m)
        },
        8, 0, true
    )

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Button(onClick = { datePicker.show() }) { Text("Seleccionar Fecha") }
            Spacer(modifier = Modifier.height(8.dp))
            Button(onClick = { timePicker.show() }) { Text("Seleccionar Hora") }
            Spacer(modifier = Modifier.height(16.dp))

            if (fechaSeleccionada.isNotEmpty()) Text("Fecha: $fechaSeleccionada", style = MaterialTheme.typography.bodyLarge)
            if (horaSeleccionada.isNotEmpty()) Text("Hora: $horaSeleccionada", style = MaterialTheme.typography.bodyLarge)

            Spacer(modifier = Modifier.height(16.dp))

            if (fechaSeleccionada.isNotEmpty() && horaSeleccionada.isNotEmpty()) {
                val fechaHora = "$fechaSeleccionada $horaSeleccionada"
                val fechaHoraEnc = java.net.URLEncoder.encode(fechaHora, "UTF-8")
                val nombreEnc = java.net.URLEncoder.encode(nombre, "UTF-8")
                val telefonoEnc = java.net.URLEncoder.encode(telefono, "UTF-8")
                Button(onClick = {
                    navController.navigate("resumen/$nombreEnc/$telefonoEnc/$fechaHoraEnc")
                }) { Text("Confirmar Cita") }
            }
        }
    }
}
