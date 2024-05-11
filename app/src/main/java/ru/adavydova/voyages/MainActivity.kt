package ru.adavydova.voyages

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import dagger.hilt.android.AndroidEntryPoint
import ru.adavydova.models.CountryUI
import ru.adavydova.voyages.ui.theme.VoyagesTheme
import ru.adavydova.voyages_data.models.Country
import ru.adavydova.voyages_navigation.BottomNavigationApp


@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            VoyagesTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Box(modifier = Modifier.fillMaxSize()) {
                        BottomNavigationApp(modifier = Modifier.fillMaxSize())
                    }
                }
            }
        }
    }
}

