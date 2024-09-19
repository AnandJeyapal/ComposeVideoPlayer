package com.poc.composeplayer.data

data class PlayerMediaItem(
    val title: String, val description: String, val url: String,
    val thumbnail: String = "https://storage.googleapis.com/gtv-videos-bucket/sample/images/BigBuckBunny.jpg"
)