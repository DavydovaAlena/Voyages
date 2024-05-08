package ru.adavydova.voyages.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.HttpClient
import ru.adavydova.voyages.BuildConfig
import ru.adavydova.voyages_api.TraverseApi
import ru.adavydova.voyages_api.TraverseHttpClient
import ru.adavydova.voyages_api.TraverseKtorClient
import ru.adavydova.voyages_data.repository.TraverseRepository
import ru.adavydova.voyages_data.usecase.GetAttractionUseCase
import ru.adavydova.voyages_data.usecase.GetCitiesUseCase
import ru.adavydova.voyages_data.usecase.GetCountriesUseCase
import ru.adavydova.voyages_data.usecase.GetProductsUseCase
import ru.adavydova.voyages_data.usecase.SearchByQueryUseCase
import ru.adavydova.voyages_data.usecase.VoyagesUseCase
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object RemoteModule {

    @Provides
    @Singleton
    fun provideHttpClient(): HttpClient {
        return TraverseHttpClient(defaultRequest = BuildConfig.BASE_URL).getHttpClient()
    }

    @Provides
    @Singleton
    fun provideTraverseApi(httpClient: HttpClient): TraverseApi {
        return TraverseKtorClient(httpClient)
    }

    @Provides
    @Singleton
    fun provideTraverseRepository(api: TraverseApi): TraverseRepository {
        return TraverseRepository(api)
    }

    @Provides
    @Singleton
    fun provideVoyagesUseCase(traverseRepository: TraverseRepository): VoyagesUseCase{
        return VoyagesUseCase(
            getAttractionUseCase = GetAttractionUseCase(traverseRepository),
            getCitiesUseCase = GetCitiesUseCase(traverseRepository),
            getCountriesUseCase = GetCountriesUseCase(traverseRepository),
            getProductsUseCase = GetProductsUseCase(traverseRepository),
            searchByQueryUseCase = SearchByQueryUseCase(traverseRepository)
        )
    }


}