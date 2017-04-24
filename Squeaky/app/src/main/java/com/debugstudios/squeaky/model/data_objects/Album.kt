package com.debugstudios.squeaky.model.data_objects

class Album {

    var name : String? = null
    var songs : List<Song>? = null

    constructor(albumName : String, albumSongs : List<Song>) {
        name = albumName
        songs = albumSongs
    }
}