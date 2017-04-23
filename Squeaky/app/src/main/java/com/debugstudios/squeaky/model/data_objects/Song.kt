package com.debugstudios.squeaky.model.data_objects

class Song(songId: Long, songTitle: String? = null, songArtist: String? = null, songDisplayName: String? = null) {

    var id: Long? = songId
    var title: String? = "Unknown Title"
    var displayName: String? = "Unknown Name"
    var artist: String? = "Unknown Artist"

    init {
        if (songTitle != null) title = songTitle
        if (displayName != null) displayName = songDisplayName
        if (songArtist != null) artist = songArtist
    }

}