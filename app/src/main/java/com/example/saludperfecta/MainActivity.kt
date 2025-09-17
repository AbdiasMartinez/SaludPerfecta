package com.example.saludperfecta

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.NavHostController
import com.example.saludperfecta.ui.PantallaFechaHora
import com.example.saludperfecta.ui.PantallaRegistro
import com.example.saludperfecta.ui.PantallaResumen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            Surface(color = MaterialTheme.colorScheme.background) {
                NavHost(navController = navController, startDestination = "registro") {
                    composable("registro") {
                        PantallaRegistro(navController)
                    }
                    composable("fechaHora/{nombre}/{telefono}") { backStackEntry ->
                        val nombre = backStackEntry.arguments?.getString("nombre") ?: ""
                        val telefono = backStackEntry.arguments?.getString("telefono") ?: ""
                        PantallaFechaHora(navController, nombre, telefono)
                    }
                    composable("resumen/{nombre}/{telefono}/{fechaHora}") { backStackEntry ->
                        val nombre = backStackEntry.arguments?.getString("nombre") ?: ""
                        val telefono = backStackEntry.arguments?.getString("telefono") ?: ""
                        val fechaHora = backStackEntry.arguments?.getString("fechaHora") ?: ""
                        PantallaResumen(nombre, telefono, fechaHora)
                    }
                }
            }
        }
    }
}
