package com.debugstudios.squeaky.contracts.views

import android.content.ContentResolver
import com.debugstudios.squeaky.model.data_objects.Song
import net.grandcentrix.thirtyinch.TiView
import net.grandcentrix.thirtyinch.callonmainthread.CallOnMainThread

interface YourMusicView : TiView {

    val mContentResolver : ContentResolver?

    fun setAdapterToSongsRecyclerView(songs: ArrayList<Song>)

    @CallOnMainThread
    fun setToolbarTitle(title : String)
}