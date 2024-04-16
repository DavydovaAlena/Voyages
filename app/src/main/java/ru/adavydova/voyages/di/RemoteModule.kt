package ru.adavydova.voyages.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.HttpClient
import ru.adavydova.voyages.BuildConfig
import ru.adavydova.voyages_api.TraverseApi
import ru.adavydova.voyages_api.TraverseKtorClient
import ru.adavydova.voyages_api.TraverseHttpClient
import ru.adavydova.voyages_api.TraverseRepository
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

}