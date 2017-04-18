package com.debugstudios.squeaky.presenters

import com.debugstudios.squeaky.contracts.views.RecentPlaysView
import net.grandcentrix.thirtyinch.TiPresenter

class RecentPlaysPresenter : TiPresenter<RecentPlaysView>() {

    override fun onAttachView(view: RecentPlaysView) {
        super.onAttachView(view)
        view.setToolbarTitle("Recent Plays")
    }
}