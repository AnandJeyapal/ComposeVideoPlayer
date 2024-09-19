package com.poc.composeplayer.player

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.poc.composeplayer.data.mediaItems

@Composable
fun PlayerScreen(modifier: Modifier = Modifier) {
    val playerMediaItems = mediaItems
    var mediaItemIndex by rememberSaveable {
        mutableIntStateOf(0)
    }
    Column(modifier = modifier.fillMaxSize()) {
        VideoPlayer(playerMediaItem = playerMediaItems[mediaItemIndex])
        LazyColumn {
            items(playerMediaItems.size) {
                MediaItemRow(
                    modifier = Modifier.clickable { mediaItemIndex = it },
                    mediaItem = playerMediaItems[it]
                )
            }
        }
    }
}