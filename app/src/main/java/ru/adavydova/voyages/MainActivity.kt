package ru.adavydova.voyages

import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.os.BuildCompat
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.collectAsLazyPagingItems
import dagger.hilt.EntryPoint
import dagger.hilt.android.AndroidEntryPoint
import ru.adavydova.voyages.ui.theme.VoyagesTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            VoyagesTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val viewModel = hiltViewModel<MainVM>()
                    val data = viewModel.state.collectAsState()
                    val countries = data.value.countries.collectAsLazyPagingItems()


                    Log.d("d",countries.itemCount.toString())
                    LazyColumn(modifier = Modifier.fillMaxSize()) {
                        items(countries.itemCount){
                            val country = countries[it]
                            Text(text = country?.name?: "error")
                        }
                    }


                }
            }
        }
    }
}

