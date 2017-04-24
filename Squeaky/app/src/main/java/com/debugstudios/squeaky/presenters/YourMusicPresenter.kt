package com.debugstudios.squeaky.presenters

import com.debugstudios.squeaky.contracts.views.YourMusicView
import com.debugstudios.squeaky.services.LocalMediaRetriever
import net.grandcentrix.thirtyinch.TiPresenter

class YourMusicPresenter : TiPresenter<YourMusicView>() {

    override fun onAttachView(view: YourMusicView) {
        super.onAttachView(view)
        view.setToolbarTitle("Your Music")
        view.setLoadingStatus(true)
        val localMediaRetriever = LocalMediaRetriever(view.mContentResolver!!)
        val songList =  localMediaRetriever.retrieveMedia()
        view.setAdapterToSongsRecyclerView(songList)
        view.setLoadingStatus(false)
    }
}