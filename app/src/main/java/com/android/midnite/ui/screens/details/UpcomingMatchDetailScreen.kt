package com.android.midnite.ui.screens.details

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Games
import androidx.compose.material.icons.filled.Map
import androidx.compose.material.icons.filled.Timer
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.android.midnite.domain.model.UpcomingMatchDetail
import com.android.midnite.ui.screens.main.TeamInfo

@Composable
fun UpcomingMatchDetailScreen(detail: UpcomingMatchDetail) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .verticalScroll(rememberScrollState())
    ) {
        Row(Modifier.fillMaxWidth()) {
            TeamInfo(
                Modifier.weight(1f),
                imageUrl = detail.homeImageUrl,
                teamName = detail.homeTeam
            )
            Text(
                modifier = Modifier.padding(16.dp),
                text = "VS",
                style = MaterialTheme.typography.h5
            )
            TeamInfo(
                Modifier.weight(1f),
                imageUrl = detail.awayImageUrl,
                teamName = detail.awayTeam
            )
        }
        DetailsSummaryView(Icons.Filled.Timer, detail.startTime)
        DetailsSummaryView(Icons.Filled.Map, detail.competitionName)
        DetailsSummaryView(Icons.Filled.Games, detail.gameName)
        Spacer(modifier = Modifier.height(16.dp))
        MarketList(detail.marketData)
    }
}
