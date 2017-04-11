package com.debugstudios.squeaky

import android.app.Application

class MyApplication : Application() {

    lateinit var component:DiComponent

    override fun onCreate() {
        super.onCreate()
        component = DaggerDiComponent.builder().build()
    }

    fun getMyComponent():DiComponent = component
}