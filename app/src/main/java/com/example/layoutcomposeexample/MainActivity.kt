package com.example.layoutcomposeexample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.layoutcomposeexample.ui.theme.LayoutComposeExampleTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.NotificationsOff
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow


class NotificationViewModel : ViewModel() {
    private val _notificationsEnabled = MutableStateFlow(true)

    val notificationsEnabled: StateFlow<Boolean> = _notificationsEnabled.asStateFlow()

    fun toggleNotifications() {
        _notificationsEnabled.value = !_notificationsEnabled.value
    }
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LayoutComposeExampleTheme {
                Scaffold( modifier = Modifier.fillMaxSize() ) { innerPadding ->
                    NotificationSettingsScreen(Modifier.padding(innerPadding))
                }
            }
        }
    }
}


@Composable
fun NotificationSettingsScreen(modifier: Modifier = Modifier, viewModel: NotificationViewModel = viewModel()) {

    val notificationsEnabled by viewModel.notificationsEnabled.collectAsState()

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = "Configuración de Notificaciones",
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(24.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    imageVector = if (notificationsEnabled) Icons.Default.Notifications else Icons.Default.NotificationsOff,
                    contentDescription = "Estado de notificación",
                    tint = if (notificationsEnabled) MaterialTheme.colorScheme.primary else Color.Gray,
                    modifier = Modifier.size(32.dp)
                )
                Spacer(modifier = Modifier.width(16.dp))
                Column {
                    Text(
                        text = "Recibir Alertas",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                    Text(
                        text = if (notificationsEnabled) "Notificaciones activas" else "Notificaciones silenciadas",
                        color = if (notificationsEnabled) Color(0xFF00C853) else Color.Red, // Verde o Rojo
                        fontSize = 14.sp
                    )
                }
            }

            Switch(
                checked = notificationsEnabled,
                onCheckedChange = {
                    viewModel.toggleNotifications()
                }
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun NotificationSettingsPreview() {
    LayoutComposeExampleTheme {
        NotificationSettingsScreen()
    }
}