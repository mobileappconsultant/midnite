package com.android.midnite.ui.screens.main

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import coil.annotation.ExperimentalCoilApi
import com.android.midnite.domain.model.UpcomingMatchItem
import com.android.midnite.ui.composable.ErrorPage
import com.android.midnite.ui.composable.FullScreenProgress

@ExperimentalCoilApi
@Composable
fun UpcomingMatchesList(listItems: LazyPagingItems<UpcomingMatchItem>, onClicked: (UpcomingMatchItem) -> Unit) {
    LazyColumn(Modifier.padding(horizontal = 16.dp)) {
        items(listItems.itemCount) { index ->
            listItems[index]?.let {
                UpcomingMatchListItem(it, onClicked)
                Spacer(Modifier.height(4.dp))
            }
        }

        listItems.apply {
            when {
                loadState.mediator?.refresh is LoadState.Loading -> {
                    item { FullScreenProgress(modifier = Modifier.fillParentMaxSize()) }
                }
                loadState.mediator?.append is LoadState.Loading -> {
                    item { FullScreenProgress(modifier = Modifier.wrapContentHeight()) }
                }
                loadState.mediator?.refresh is LoadState.Error -> {
                    val error = loadState.refresh as LoadState.Error
                    if (listItems.itemSnapshotList.items.isEmpty()) {
                        item { ErrorPage(message = error.error.localizedMessage.orEmpty(), modifier = Modifier.fillParentMaxSize()) { retry() } }
                    }
                }
                loadState.mediator?.append is LoadState.Error -> {
                    val error = loadState.append as LoadState.Error
                    item { ErrorPage(message = error.error.localizedMessage.orEmpty(), modifier = Modifier.wrapContentHeight()) { retry() } }
                }
            }
        }
    }
}
