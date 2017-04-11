package com.debugstudios.squeaky.contracts.views

import net.grandcentrix.thirtyinch.TiView
import net.grandcentrix.thirtyinch.callonmainthread.CallOnMainThread

interface MainView : TiView {

    @CallOnMainThread
    fun showText(text:String):Unit
}