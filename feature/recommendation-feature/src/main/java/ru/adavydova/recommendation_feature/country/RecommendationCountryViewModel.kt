package ru.adavydova.recommendation_feature.country

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import ru.adavydova.voyages_data.models.Country
import ru.adavydova.voyages_data.usecase.VoyagesUseCase
import javax.inject.Inject

@HiltViewModel
class RecommendationCountryViewModel @Inject constructor(
    private val useCase: VoyagesUseCase
) : ViewModel() {

    private val _recommendationCountryState = MutableStateFlow(RecommendationCountryState())
    val recommendationCountryState = _recommendationCountryState.asStateFlow()

    init {
        viewModelScope.launch {
            _recommendationCountryState.value =
                _recommendationCountryState.value.copy(
                    countries = getCountries()
                )
        }
    }

    private suspend fun getCountries() = withContext(Dispatchers.IO) {
        useCase.getCountriesUseCase()
    }
}

data class RecommendationCountryState(
    val countries: Flow<PagingData<Country>> = emptyFlow()
)