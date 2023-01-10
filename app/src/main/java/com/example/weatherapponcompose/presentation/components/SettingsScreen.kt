package com.example.weatherapponcompose.presentation.components


import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.weatherapponcompose.presentation.dataStore
import com.jamal.composeprefs3.ui.PrefsScreen
import com.jamal.composeprefs3.ui.prefs.CheckBoxPref
import com.jamal.composeprefs3.ui.prefs.EditTextPref

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun SettingsScreen() {
    Surface(modifier = Modifier.padding(16.dp)) {
        PrefsScreen(
            dataStore = LocalContext.current.dataStore,

        ) {
            prefsItem {
                EditTextPref(
                    key = "location",
                    title = "Текущая позиция",
                    summary = "Определяет местоположение, для которого ",
                    dialogTitle = "Изменение текущего местоположения",
                    dialogMessage = "Укажите координаты места, для которого хотите получать погоду (например: 55.757,37.615)",
                    enabled = false
                )
                CheckBoxPref(
                    key = "location_auto",
                    title = "Получать местоположение по GPS",
                    summary = "Автоматическое определение местоположение. Требует разрешения к данным о местоположении ",
                )
            }
        }
    }
}