package com.debugstudios.squeaky.model.data_objects

class Song {

    var id : Long? = null
    var title : String? = null
    var artist : String? = "Unknown Artist"

    constructor (songId: Long, songTitle : String,
                 songArtist : String? = null) {
        id = songId
        title = songTitle
        if(songArtist != null) {
            artist = songArtist
        }
    }
}