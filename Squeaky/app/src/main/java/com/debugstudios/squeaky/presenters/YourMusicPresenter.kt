package com.debugstudios.squeaky.presenters

import com.debugstudios.squeaky.contracts.views.YourMusicView
import net.grandcentrix.thirtyinch.TiPresenter

class YourMusicPresenter : TiPresenter<YourMusicView>() {

    override fun onAttachView(view: YourMusicView) {
        super.onAttachView(view)
        view.setToolbarTitle("Your Music")
    }
}