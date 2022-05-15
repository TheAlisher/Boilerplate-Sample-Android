package com.alish.boilerplate.di

import com.alish.boilerplate.data.remote.RetrofitClient
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
        retrofitClient: RetrofitClient
    ) = retrofitClient.provideSignInApiService()
}