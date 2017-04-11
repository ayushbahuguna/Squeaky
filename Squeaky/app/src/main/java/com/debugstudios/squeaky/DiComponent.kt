package com.debugstudios.squeaky

import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(NetworkApiModule::class))
public interface DiComponent {
    fun inject(activity:MainActivity):Unit
}