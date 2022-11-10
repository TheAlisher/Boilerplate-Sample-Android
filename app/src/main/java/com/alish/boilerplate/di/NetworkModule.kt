package com.alish.boilerplate.di

import android.content.Context
import com.alish.boilerplate.data.remote.apiservices.FooApiService
import com.alish.boilerplate.data.remote.apiservices.SignInApiService
import com.alish.boilerplate.data.remote.apiservices.mock.FooApiServiceImpl
import com.alish.boilerplate.data.remote.apiservices.mock.SignInApiServiceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideSignInApiService(
        @ApplicationContext context: Context
    ): SignInApiService {
        return SignInApiServiceImpl(context)
    }

    @Singleton
    @Provides
    fun provideFooApiService(
        @ApplicationContext context: Context
    ): FooApiService {
        return FooApiServiceImpl(context)
    }
}