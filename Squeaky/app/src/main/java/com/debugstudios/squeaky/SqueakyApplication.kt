package com.debugstudios.squeaky

import android.app.Application
import com.joanzapata.iconify.Iconify
import com.joanzapata.iconify.fonts.FontAwesomeModule
import com.joanzapata.iconify.fonts.MaterialCommunityModule
import com.joanzapata.iconify.fonts.MaterialModule

public class SqueakyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        Iconify
                .with(FontAwesomeModule())
                .with(MaterialModule())
                .with(MaterialCommunityModule())
    }
}