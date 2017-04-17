package com.debugstudios.squeaky.ui.fragments

import android.os.Bundle
import android.support.annotation.Nullable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.debugstudios.squeaky.R
import com.debugstudios.squeaky.contracts.views.NowPlayingView
import com.debugstudios.squeaky.presenters.NowPlayingPresenter
import net.grandcentrix.thirtyinch.TiFragment

class NowPlayingFragment : TiFragment<NowPlayingPresenter, NowPlayingView>(), NowPlayingView {

    override fun setToolbarTitle(title: String) {
        activity.title = title
    }

    override fun providePresenter(): NowPlayingPresenter = NowPlayingPresenter()

    @Nullable
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)

        val view = inflater.inflate(R.layout.fragment_now_playing, container, false)

        return view
    }
}