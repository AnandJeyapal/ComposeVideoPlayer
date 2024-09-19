package com.poc.composeplayer.player

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.poc.composeplayer.data.PlayerMediaItem

@Composable
fun MediaItemRow(modifier: Modifier = Modifier, mediaItem: PlayerMediaItem) {
    Row(modifier = modifier) {
        AsyncImage(
            modifier = Modifier
                .width(100.dp)
                .height(72.dp)
                .clip(RectangleShape),
            contentScale = ContentScale.FillBounds,
            model = mediaItem.thumbnail,
            contentDescription = null,
        )
        Column(modifier = Modifier.height(72.dp)) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 8.dp)
                    .weight(1f),
                verticalArrangement = Arrangement.Center
            ) {
                Text(text = mediaItem.title, fontSize = 16.sp, fontWeight = FontWeight.Bold)
                Text(text = mediaItem.description, fontSize = 14.sp, maxLines = 2)
            }
            Divider(modifier = Modifier.fillMaxWidth())
        }
    }
}

@Preview
@Composable
fun MediaItemRowPreview(modifier: Modifier = Modifier, mediaItem: PlayerMediaItem) {
    val mediaItem = PlayerMediaItem(
        "Big Buck Bunny",
        "Big Buck Bunny tells the story of a giant rabbit with a heart bigger than himself. When one sunny day three rodents rudely harass him, something snaps... and the rabbit ain't no bunny anymore! In the typical cartoon tradition he prepares the nasty rodents a comical revenge.",
        "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4"
    )
    MediaItemRow(mediaItem = mediaItem)
}
