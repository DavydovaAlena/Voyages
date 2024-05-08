package ru.adavydova.voyages

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.collectAsLazyPagingItems
import dagger.hilt.android.AndroidEntryPoint
import ru.adavydova.models.CountryUI
import ru.adavydova.voyages.ui.theme.VoyagesTheme
import ru.adavydova.voyages_data.models.Country
import ru.adavydova.voyages_navigation.BottomNavigationApp

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

                    Box(modifier = Modifier.fillMaxSize()){
                        BottomNavigationApp(modifier = Modifier.fillMaxSize())
                    }

//                    Box(modifier = Modifier.fillMaxSize()){
//                        LazyRow(modifier = Modifier
//                            .fillMaxWidth()
//                            .height(540.dp), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
//                            items(countries.itemCount){
//                                val country = countries[it]
//                                country?.let {
//                                    RecommendationCountryCard(country = country.toCountryUI())
//                                }
//                            }
//                        }
//                    }



                }
            }
        }
    }
}

