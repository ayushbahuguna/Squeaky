package com.debugstudios.squeaky.playback

import android.support.v4.media.session.MediaSessionCompat

/**
 * Interface for Local or Remote Playback. Essentially every service which
 * handles playback has to implement this interface
 */
interface Playback {

    /**
     * Start/setup the playback
     */
    fun start(): Unit

    /**
     * Stops the playback. All resources such as AudioFocus should be de-allocated
     * here.
     * @param notifyListeners if true and if a callback has been set by setCallback,
     *                          callback.onPlaybackStatusChanged will
     *                          be called after changing state.
     */
    fun stop(notifyListeners: Boolean): Unit

    /**
     * Set the playback state as determined by the Caller
     */
    fun setState(state: Int): Unit

    /**
     * Get the current playback state [android.media.session.PlaybackState]
     */
    fun getState(): Int

    /**
     * Shows if the playback is ready to be used
     */
    fun isConnected(): Boolean

    /**
     * Shows whether the player is playing currently
     */
    fun isPlaying(): Boolean

    /**
     * Returns the current position in a stream if player is currently playing
     */
    fun getCurrentStreamPosition(): Int

    /**
     * Sets the current position in stream.
     */
    fun setCurrentStreamPosition(position: Int): Unit

    /**
     * Updates the internal last known stream position
     */
    fun updateLastKnownStreamPosition(): Unit

    /**
     * @param item is played
     */
    fun play(item: MediaSessionCompat.QueueItem): Unit

    /**
     * Pause the currently playing item
     */
    fun pause(): Unit

    /**
     * Seek to the provided position
     */
    fun seekTo(position: Int): Unit

    /**
     * Sets the current MediaId. Only used when switching from one
     * playback to another
     */
    fun setCurrentMediaId(mediaId: String): Unit

    /**
     * The current media Id being processed in any state
     */
    val getCurrentMediaId: String

    interface Callback {

        /**
         * On Current music completed
         */
        fun onCompletion()

        /**
         * This can be used to update playback state on media sessions
         */
        fun onPlaybackStatusChanged(state: Int)

        /**
         * @param error to be added to playback state
         */
        fun onError(error: String)

        /**
         * @param mediaId being currently played
         */
        fun setCurrentMediaId(mediaId: String)

    }

    /**
     * Callback to be called
     */
    fun setCallback(callback: Callback)

}