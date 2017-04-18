package com.debugstudios.squeaky.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.debugstudios.squeaky.R
import com.debugstudios.squeaky.contracts.views.RecentPlaysView
import com.debugstudios.squeaky.presenters.RecentPlaysPresenter
import net.grandcentrix.thirtyinch.TiFragment

class RecentPlaysFragment : TiFragment<RecentPlaysPresenter, RecentPlaysView>(), RecentPlaysView {

    override fun setToolbarTitle(title: String) {
        activity.title = title
    }

    override fun providePresenter(): RecentPlaysPresenter = RecentPlaysPresenter()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        val view = inflater.inflate(R.layout.fragment_recent, container, false)
        return view
    }
}