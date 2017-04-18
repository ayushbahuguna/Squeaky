package com.debugstudios.squeaky.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.debugstudios.squeaky.R
import com.debugstudios.squeaky.contracts.views.YourMusicView
import com.debugstudios.squeaky.presenters.YourMusicPresenter
import net.grandcentrix.thirtyinch.TiFragment

class YourMusicFragment : TiFragment<YourMusicPresenter, YourMusicView>(), YourMusicView {

    override fun setToolbarTitle(title: String) {
        activity.title = title
    }

    override fun providePresenter(): YourMusicPresenter = YourMusicPresenter()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        val view = inflater.inflate(R.layout.fragment_your_music, container, false)
        return view
    }
}