package com.debugstudios.squeaky.presenters

import com.debugstudios.squeaky.contracts.views.YourMusicView
import com.debugstudios.squeaky.model.data_objects.Song
import com.debugstudios.squeaky.services.LocalMediaRetriever
import net.grandcentrix.thirtyinch.TiPresenter

class YourMusicPresenter : TiPresenter<YourMusicView>() {

    override fun onAttachView(view: YourMusicView) {
        super.onAttachView(view)
        view.setToolbarTitle("Your Music")
        val localMediaRetriever = LocalMediaRetriever(view.mContentResolver!!)
        val list = localMediaRetriever.retrieveMedia()
        val songList = ArrayList<Song>()
        list.forEach { songList.add(Song(0, it, null)) }
        view.setAdapterToSongsRecyclerView(songList)
    }
}