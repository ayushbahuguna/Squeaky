package com.debugstudios.squeaky

import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class NetworkApiModule {
    @Provides
    @Singleton
    fun provideString() = NetworkApi()
}