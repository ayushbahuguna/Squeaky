package com.debugstudios.squeaky.presenters

import com.debugstudios.squeaky.contracts.views.MainView
import net.grandcentrix.thirtyinch.TiPresenter

class MainPresenter : TiPresenter<MainView>() {

    override fun onAttachView(view: MainView) {
        super.onAttachView(view)
        view.setUserName("prajjwaldimri")
    }
}