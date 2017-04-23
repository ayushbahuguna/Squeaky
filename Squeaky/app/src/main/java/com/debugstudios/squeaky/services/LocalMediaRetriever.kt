package com.debugstudios.squeaky.services

import android.content.ContentResolver
import android.provider.MediaStore
import com.debugstudios.squeaky.model.data_objects.Song

class LocalMediaRetriever(contentResolver: ContentResolver) {

    private var mContentResolver : ContentResolver = contentResolver

    fun retrieveMedia() : ArrayList<Song> {

        val audioList: ArrayList<Song> = ArrayList()

        val dataRequested = arrayOf(MediaStore.Audio.Media._ID,
                MediaStore.Audio.Media.DISPLAY_NAME)

        val audioCursor = mContentResolver.query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,
                dataRequested, null, null, null)
        if(audioCursor != null) {
           if(audioCursor.moveToFirst()){
               do{
                   val idIndex = audioCursor.getColumnIndex(MediaStore.Audio.Media._ID)
                   val titleIndex = audioCursor.getColumnIndex(MediaStore.Audio.Media.TITLE)
                   val displayIndex = audioCursor.getColumnIndex(MediaStore.Audio.Media.DISPLAY_NAME)
                   val artistIndex = audioCursor.getColumnIndex(MediaStore.Audio.Media.ARTIST)

                   val audio = Song(audioCursor.getLong(idIndex))
                   if(titleIndex > -1) audio.title = audioCursor.getString(titleIndex)
                   if(displayIndex > -1) audio.displayName = audioCursor.getString(displayIndex)
                   if(artistIndex > -1) audio.artist = audioCursor.getString(artistIndex)

                   //Adds song to the songList if it is not null
                   audioList.add(audio)
               } while (audioCursor.moveToNext())
           }
        }
        audioCursor.close()
        return audioList
    }
}