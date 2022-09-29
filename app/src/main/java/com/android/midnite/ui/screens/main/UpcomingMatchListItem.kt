package com.android.midnite.ui.screens.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberAsyncImagePainter
import com.android.midnite.domain.model.UpcomingMatchItem
import com.android.midnite.ui.theme.primaryTextColor
import com.android.midnite.ui.theme.secondaryTextColor

@ExperimentalCoilApi
@Composable
fun UpcomingMatchListItem(matchItem: UpcomingMatchItem, onClicked: (UpcomingMatchItem) -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                onClicked(matchItem)
            }
            .wrapContentHeight(),
    ) {
        Column(Modifier.padding(16.dp)) {
            Text(
                text = "${matchItem.gameName} - ${matchItem.competitionName}",
                style = MaterialTheme.typography.body2,
                color = MaterialTheme.colors.primaryTextColor
            )
            Text(
                text = matchItem.startTime,
                style = MaterialTheme.typography.subtitle2,
                color = MaterialTheme.colors.secondaryTextColor
            )
            Spacer(modifier = Modifier.height(12.dp))
            Row(Modifier.fillMaxWidth()) {
                TeamInfo(
                    Modifier.weight(1f),
                    imageUrl = matchItem.homeImageUrl,
                    teamName = matchItem.homeTeam
                )
                Text(
                    modifier = Modifier.padding(16.dp),
                    text = "VS",
                    style = MaterialTheme.typography.h5
                )
                TeamInfo(
                    Modifier.weight(1f),
                    imageUrl = matchItem.awayImageUrl,
                    teamName = matchItem.awayTeam
                )
            }
        }
    }
}

@Composable
fun TeamLogo(url: String) {
    Image(
        modifier = Modifier
            .size(84.dp),
        painter = rememberAsyncImagePainter(url),
        contentDescription = "Team Logo",
        contentScale = ContentScale.Crop,
    )
}

@Composable
fun TeamInfo(modifier: Modifier, imageUrl: String, teamName: String) {
    Column(modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        TeamLogo(url = imageUrl)
        Spacer(modifier = Modifier.height(12.dp))
        Text(text = teamName, style = MaterialTheme.typography.caption)
    }
}
