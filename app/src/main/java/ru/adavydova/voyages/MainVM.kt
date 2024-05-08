package ru.adavydova.voyages

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.launch
import ru.adavydova.voyages_data.models.Country
import ru.adavydova.voyages_data.repository.TraverseRepository
import javax.inject.Inject

@HiltViewModel
class MainVM @Inject constructor(
    repository: TraverseRepository
) : ViewModel() {

    val state = MutableStateFlow<MainData>(MainData())

    init {

        viewModelScope.launch(Dispatchers.IO) {
            val c = repository.getCountries()

            state.value = state.value.copy(countries = c)
        }
    }
}


data class MainData(
    val countries: Flow<PagingData<Country>> = emptyFlow()
)