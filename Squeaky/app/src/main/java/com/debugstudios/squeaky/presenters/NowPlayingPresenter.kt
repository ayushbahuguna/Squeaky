package com.debugstudios.squeaky.presenters

import com.debugstudios.squeaky.contracts.views.NowPlayingView
import net.grandcentrix.thirtyinch.TiPresenter

class NowPlayingPresenter : TiPresenter<NowPlayingView>() {

    override fun onAttachView(view: NowPlayingView) {
        super.onAttachView(view)
        view.setToolbarTitle("Now Playing")
    }
}