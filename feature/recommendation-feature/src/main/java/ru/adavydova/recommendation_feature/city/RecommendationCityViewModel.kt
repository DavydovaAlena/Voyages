package ru.adavydova.recommendation_feature.city

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
import ru.adavydova.voyages_data.models.ItemTraverse
import ru.adavydova.voyages_data.usecase.VoyagesUseCase
import javax.inject.Inject

@HiltViewModel
class RecommendationCityViewModel @Inject constructor(
    private val useCase: VoyagesUseCase
) : ViewModel() {

    private val _recommendationCityState = MutableStateFlow(RecommendationCityState())
    val recommendationCitiesState = _recommendationCityState.asStateFlow()

    init {
        viewModelScope.launch {
            _recommendationCityState.value =
                _recommendationCityState.value.copy(
                    countries = getCities()
                )
        }
    }

    private suspend fun getCities() = withContext(Dispatchers.IO) {
        useCase.getCitiesUseCase()
    }
}

data class RecommendationCityState(
    val countries: Flow<PagingData<ItemTraverse.City>> = emptyFlow()
)