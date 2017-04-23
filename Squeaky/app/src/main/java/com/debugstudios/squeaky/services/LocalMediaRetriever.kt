package com.debugstudios.squeaky.services

import android.content.ContentResolver
import android.provider.MediaStore

class LocalMediaRetriever(contentResolver: ContentResolver) {

    private var mContentResolver : ContentResolver = contentResolver

    fun retrieveMedia() : ArrayList<String> {

        var audioList: ArrayList<String> = ArrayList()

        val dataRequested = arrayOf(MediaStore.Audio.Media._ID,
                MediaStore.Audio.Media.DISPLAY_NAME)

        val audioCursor = mContentResolver.query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,
                dataRequested, null, null, null)
        if(audioCursor != null) {
           if(audioCursor.moveToFirst()){
               do{
                   var audioIndex = audioCursor.getColumnIndexOrThrow(
                           MediaStore.Audio.Media.DISPLAY_NAME
                   )
                   audioList.add(audioCursor.getString(audioIndex))
               } while (audioCursor.moveToNext())
           }
        }
        audioCursor.close()
        return audioList
    }
}