package com.example.layoutcomposeexample.ui.weather.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun BottomBar(){
    NavigationBar {
        NavigationBarItem(
            icon = { Icon(Icons.Filled.Home, contentDescription = "Inicio") },
            label = {Text("Inicio")},
            selected = true,
            onClick = { /*accion*/}
        )

        NavigationBarItem(
            icon = { Icon(Icons.Filled.Settings, contentDescription = "Configuración") },
            label = {Text("Configuracion")},
            selected = false,
            onClick = { /*accion*/}
        )
    }
}

