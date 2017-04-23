package com.debugstudios.squeaky.ui.fragments

import android.content.ContentResolver
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.debugstudios.squeaky.R
import com.debugstudios.squeaky.contracts.views.YourMusicView
import com.debugstudios.squeaky.model.data_objects.Song
import com.debugstudios.squeaky.presenters.YourMusicPresenter
import com.debugstudios.squeaky.ui.adapters.SongsAdapter
import kotlinx.android.synthetic.main.fragment_your_music.*
import net.grandcentrix.thirtyinch.TiFragment

public class YourMusicFragment : TiFragment<YourMusicPresenter, YourMusicView>(), YourMusicView {

    override var mContentResolver: ContentResolver? = null

    override fun setToolbarTitle(title: String) {
        activity.title = title
    }

    override fun setAdapterToSongsRecyclerView(songs: ArrayList<Song>) {
        val adapter = SongsAdapter(context, songs)
        songsRecyclerView.adapter = adapter
        songsRecyclerView.layoutManager = LinearLayoutManager(context)
    }

    override fun providePresenter(): YourMusicPresenter = YourMusicPresenter()

    public override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                                     savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        val view = inflater.inflate(R.layout.fragment_your_music, container, false)
        mContentResolver = activity.contentResolver
        return view
    }

}