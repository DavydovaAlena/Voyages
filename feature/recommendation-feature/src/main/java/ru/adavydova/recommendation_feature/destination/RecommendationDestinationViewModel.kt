package ru.adavydova.recommendation_feature.destination

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
class RecommendationDestinationViewModel @Inject constructor(
    private val useCase: VoyagesUseCase
): ViewModel() {

    private val _recommendationAttractionState = MutableStateFlow(RecommendationDestinationState())
    val recommendationAttractionState = _recommendationAttractionState.asStateFlow()

    init {
        viewModelScope.launch {
            _recommendationAttractionState.value =
                _recommendationAttractionState.value.copy(
                    attraction = getAttraction()
                )
        }
    }

    private suspend fun getAttraction() = withContext(Dispatchers.IO) {
        useCase.getAttractionUseCase()
    }
}

data class RecommendationDestinationState(
    val attraction: Flow<PagingData<ItemTraverse.Attraction>> = emptyFlow()
)