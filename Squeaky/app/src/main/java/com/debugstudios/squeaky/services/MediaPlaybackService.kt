package com.debugstudios.squeaky.services

import android.os.Bundle
import android.support.v4.media.MediaBrowserCompat
import android.support.v4.media.MediaBrowserServiceCompat
import android.support.v4.media.session.MediaSessionCompat
import android.support.v4.media.session.PlaybackStateCompat
import com.debugstudios.squeaky.R

/**
 * https://developer.android.com/guide/topics/media-apps/audio-app/building-a-mediabrowserservice.html
 * https://developer.android.com/reference/android/support/v4/media/MediaBrowserServiceCompat.html
 */
class MediaPlaybackService : MediaBrowserServiceCompat() {

    private var mMediaSession : MediaSessionCompat? = null
    private var mStateBuilder : PlaybackStateCompat.Builder? = null


    override fun onCreate() {
        super.onCreate()

        mMediaSession = MediaSessionCompat(this, this.javaClass.simpleName)
        mMediaSession!!.setFlags(
                MediaSessionCompat.FLAG_HANDLES_MEDIA_BUTTONS or
                MediaSessionCompat.FLAG_HANDLES_TRANSPORT_CONTROLS)
        mStateBuilder = PlaybackStateCompat.Builder()
                .setActions(PlaybackStateCompat.ACTION_PLAY or
                PlaybackStateCompat.ACTION_PAUSE)
        mMediaSession!!.setPlaybackState(mStateBuilder!!.build())

        //mMediaSession!!.setCallback(MediaSessionCallback())
        sessionToken = mMediaSession!!.sessionToken
    }


    override fun onGetRoot(clientPackageName: String, clientUid: Int, rootHints: Bundle?):
            BrowserRoot? {
            return BrowserRoot(R.string.app_name.toString(), null)
    }

    override fun onLoadChildren(parentId: String, result:
    Result<MutableList<MediaBrowserCompat.MediaItem>>) {
        result.sendResult(null)
    }
}