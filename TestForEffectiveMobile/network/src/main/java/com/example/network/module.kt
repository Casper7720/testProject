package com.example.network


import com.example.testforeffectivemobile.data.repository.network.NetworkRepository
import com.example.testforeffectivemobile.data.repository.network.NetworkRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideSignInApiService(
        common: Common
    ) = common.apiService

    @Singleton
    @Provides
    fun provideCommon(): Common = Common

}

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoriesModule {

    @Binds
    abstract fun bindNetworkRepository(networkRepositoryImpl: NetworkRepositoryImpl): NetworkRepository
}