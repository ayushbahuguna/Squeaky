package com.debugstudios.squeaky.model.data_objects

class Song(songId: Long, songDuration: Long? = null, songTitle: String? = null, songArtist: String? = null, songDisplayName: String? = null) {

    var id: Long? = songId
    var duration : Long? = 0
    var title: String? = "Unknown Title"
    var displayName: String? = "Unknown Name"
    var artist: String? = "Unknown Artist"


    init {
        if(duration != null) duration = songDuration
        if (songTitle != null) title = songTitle
        if (displayName != null) displayName = songDisplayName
        if (songArtist != null) artist = songArtist
    }

}