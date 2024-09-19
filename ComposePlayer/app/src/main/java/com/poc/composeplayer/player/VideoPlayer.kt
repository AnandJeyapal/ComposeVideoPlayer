package com.poc.composeplayer.player

import android.graphics.Color
import android.net.Uri
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.viewinterop.AndroidView
import androidx.media3.common.MediaItem
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.ui.PlayerView

@Composable
fun VideoPlayer(mediaItem: MediaItem) {
    // Create context from Compose
    val context = LocalContext.current

    val lifecycleOwner = LocalLifecycleOwner.current

    // Create and remember an ExoPlayer instance
    val exoPlayer = remember {
        ExoPlayer.Builder(context).build().apply {
            // Start playing the video automatically
            playWhenReady = true
        }
    }

    LaunchedEffect(exoPlayer, mediaItem) {
        // Create the MediaItem
        exoPlayer.addMediaItem(mediaItem)
        // Prepare the player
        exoPlayer.prepare()
    }

    val defaultPlayerView =
        remember {
            PlayerView(context).apply {
                player = exoPlayer
                useController = true  // Enables playback controls (play, pause, etc.)
            }
        }

    // Compose the UI with ExoPlayer
    // AndroidView for ExoPlayer's PlayerView
    AndroidView(
        factory = {
            defaultPlayerView.apply {
                setBackgroundColor(Color.BLACK)
            }
        },
        modifier = Modifier.fillMaxWidth()
    )

    // Release ExoPlayer when no longer needed
    DisposableEffect(lifecycleOwner) {
        onDispose {
            exoPlayer.release()
        }
    }
}