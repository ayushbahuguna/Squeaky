package com.debugstudios.squeaky.presenters

import com.debugstudios.squeaky.contracts.views.MainView
import net.grandcentrix.thirtyinch.TiPresenter

class MainPresenter : TiPresenter<MainView>() {

    override fun onAttachView(view: MainView):Unit{
        super.onAttachView(view)
        view.showText("Hello from Main Presenter!")
    }
}