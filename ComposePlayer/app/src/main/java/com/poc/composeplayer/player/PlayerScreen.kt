package com.poc.composeplayer.player

import android.net.Uri
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.media3.common.MediaItem

@Composable
fun PlayerScreen(modifier: Modifier = Modifier) {
    val mediaItem =
        MediaItem.fromUri(Uri.parse("https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4"))
    Box(modifier = modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
        VideoPlayer(mediaItem = mediaItem)
    }
}