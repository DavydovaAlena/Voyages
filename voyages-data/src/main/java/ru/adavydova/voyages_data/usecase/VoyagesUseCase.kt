package ru.adavydova.voyages_data.usecase

data class VoyagesUseCase (
    val getAttractionUseCase: GetAttractionUseCase,
    val getCitiesUseCase: GetCitiesUseCase,
    val getCountriesUseCase: GetCountriesUseCase,
    val getProductsUseCase: GetProductsUseCase,
    val searchByQueryUseCase: SearchByQueryUseCase,
    val getMetadataOfTheCityByQueryUseCase: GetMetadataOfTheCityByQueryUseCase
)