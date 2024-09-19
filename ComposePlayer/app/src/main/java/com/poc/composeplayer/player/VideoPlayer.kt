package com.poc.composeplayer.player

import android.graphics.Color
import android.net.Uri
import android.util.Log
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
import com.poc.composeplayer.data.PlayerMediaItem

@Composable
fun VideoPlayer(playerMediaItem: PlayerMediaItem) {
    // Create context from Compose
    val context = LocalContext.current

    // Create and remember an ExoPlayer instance
    val exoPlayer = remember {
        ExoPlayer.Builder(context).build().apply {
            // Start playing the video automatically
            playWhenReady = true
        }
    }

    LaunchedEffect(exoPlayer, playerMediaItem) {
        // Create the MediaItem
        Log.d("AAA", playerMediaItem.url)
        exoPlayer.setMediaItem(MediaItem.fromUri(Uri.parse(playerMediaItem.url)))
        // Prepare the player
        exoPlayer.prepare()
        exoPlayer.playWhenReady = true
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
    DisposableEffect(exoPlayer) {
        onDispose {
            exoPlayer.release()
        }
    }
}