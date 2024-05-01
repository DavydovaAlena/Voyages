package ru.adavydova.voyages

import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.os.BuildCompat
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.collectAsLazyPagingItems
import dagger.hilt.EntryPoint
import dagger.hilt.android.AndroidEntryPoint
import ru.adavydova.models.CountryUI
import ru.adavydova.ui_component.card.RecommendationCountryCard
import ru.adavydova.voyages.ui.theme.VoyagesTheme
import ru.adavydova.voyages_api.models.Country

fun Country.toCountryUI() = CountryUI(
    id = id,
    name = name,
    code = getCountryCode(),
    picture = getCountryImage(),
    slug = slug
)

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
                    Box(modifier = Modifier.fillMaxSize()){
                        LazyRow(modifier = Modifier
                            .fillMaxWidth()
                            .height(540.dp), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                            items(countries.itemCount){
                                val country = countries[it]
                                country?.let {
                                    RecommendationCountryCard(country = country.toCountryUI())
                                }
                            }
                        }
                    }



                }
            }
        }
    }
}

