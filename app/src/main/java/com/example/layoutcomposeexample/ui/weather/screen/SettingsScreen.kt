package com.example.layoutcomposeexample.ui.weather.screen

import android.content.pm.PackageManager
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import androidx.navigation.NavController
import com.example.layoutcomposeexample.ui.weather.component.SettingsTopBar
import android.Manifest
import android.content.Context
import androidx.compose.material3.ButtonDefaults
import androidx.compose.ui.graphics.Color
import com.example.layoutcomposeexample.utils.isNetworkAvailable

@Composable
fun SettingsScreen(navController: NavController){
    val context = LocalContext.current

    var permissionStatusText by remember { mutableStateOf("Permiso de Ubicación no solicitado.") }

    var networkStatusText by remember { mutableStateOf("Estado de red no verificado.") }

    val locationPermissionLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestPermission(),
        onResult = { isGranted: Boolean ->
            if (isGranted) {
                permissionStatusText = "Permiso de Ubicación concedido."
            } else {
                permissionStatusText = "Permiso de Ubicación denegado."
            }
        }
    )

    Scaffold (
        topBar = {
            SettingsTopBar(navController = navController)
        }

    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {

            Text(text = permissionStatusText)
            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = {
                    when (ContextCompat.checkSelfPermission(
                        context,
                        Manifest.permission.ACCESS_FINE_LOCATION
                    )) {
                        PackageManager.PERMISSION_GRANTED -> {
                            permissionStatusText = "Permiso ya está concedido."
                        }
                        else -> {
                            locationPermissionLauncher.launch(
                                Manifest.permission.ACCESS_FINE_LOCATION
                            )
                        }
                    }
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Gray,
                    contentColor = Color.White
                )
            ) {
                Text("Solicitar Permiso de Ubicación")
            }

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = {
                        if(isNetworkAvailable(context)){
                            networkStatusText = "Conexión de red disponible."
                        }else{
                            networkStatusText = "Sin conexión de red."
                        }
                    },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Gray,
                    contentColor = Color.White
                )
            ) {
                Text("Verificar Conexión de Red")
            }
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = networkStatusText)
        }
    }
}


