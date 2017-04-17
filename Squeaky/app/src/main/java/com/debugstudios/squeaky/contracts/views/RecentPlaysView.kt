package com.debugstudios.squeaky.contracts.views

import net.grandcentrix.thirtyinch.TiView
import net.grandcentrix.thirtyinch.callonmainthread.CallOnMainThread

interface RecentPlaysView : TiView {

    @CallOnMainThread
    fun setToolbarTitle(title : String)
}