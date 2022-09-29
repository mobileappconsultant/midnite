package com.android.midnite.ui.screens.main

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import com.android.midnite.domain.model.UpcomingMatchItem
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState

@Composable
fun MainScreen(data: LazyPagingItems<UpcomingMatchItem>, onRefresh: () -> Unit, onItemSelected: (UpcomingMatchItem) -> Unit) {
    Column(Modifier) {
        TopAppBar(modifier = Modifier.fillMaxWidth()) {
            Text(text = "Upcoming Matches", style = MaterialTheme.typography.body1, modifier = Modifier.padding(horizontal = 24.dp))
        }
        SwipeRefresh(
            state = rememberSwipeRefreshState(isRefreshing = data.loadState.refresh == LoadState.Loading),
            onRefresh = onRefresh
        ) {
            UpcomingMatchesList(listItems = data, onItemSelected)
        }
    }
}
