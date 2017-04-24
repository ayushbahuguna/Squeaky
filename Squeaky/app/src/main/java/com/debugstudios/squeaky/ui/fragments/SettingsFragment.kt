package com.debugstudios.squeaky.ui.fragments

import android.os.Bundle
import android.support.v7.preference.PreferenceFragmentCompat
import com.debugstudios.squeaky.R

class SettingsFragment : PreferenceFragmentCompat() {

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.settings, rootKey)
    }
}