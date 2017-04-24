package com.debugstudios.squeaky.ui.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.debugstudios.squeaky.R
import com.debugstudios.squeaky.model.data_objects.Song

class SongsAdapter(context: Context, songs: List<Song>) : RecyclerView.Adapter<SongsAdapter.ViewHolder>() {

    private var mSongs: List<Song>? = songs
    private var mContext: Context? = context

    fun getContext(): Context = mContext!!

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        val song = mSongs!![position]
        val textView = holder!!.songTitleTextView
        textView!!.text = song.title
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder{
        val inflater = LayoutInflater.from(parent!!.context)
        val songView = inflater.inflate(R.layout.item_song, parent, false)
        val viewHolder = ViewHolder(songView)
        return viewHolder
    }

    override fun getItemCount(): Int = mSongs!!.size

    class ViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
        var songTitleTextView: TextView? = null

        init {
            songTitleTextView = itemView!!.findViewById(R.id.item_song_name)
                    as TextView
        }
    }
}