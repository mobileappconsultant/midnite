package com.android.midnite.ui.screens.details

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.android.midnite.ui.composable.ErrorPage
import com.android.midnite.ui.composable.FullScreenProgress
import com.android.midnite.ui.viewmodel.MatchDetailsUiState

@Composable
fun DetailsScreen(state: MatchDetailsUiState, onRetry: () -> Unit, onBack: () -> Unit) {
    Column {
        TopAppBar(modifier = Modifier.fillMaxWidth()) {
            IconButton(onClick = onBack) {
                Icon(Icons.Filled.ArrowBack, contentDescription = null)
            }
            Spacer(modifier = Modifier.width(12.dp))
            Text(text = "Match Details", style = MaterialTheme.typography.body1)
        }
        when (state) {
            is MatchDetailsUiState.Failure -> {
                ErrorPage(
                    modifier = Modifier.fillMaxSize(),
                    message = state.message,
                    onClickRetry = onRetry
                )
            }
            MatchDetailsUiState.Loading -> {
                FullScreenProgress(
                    modifier = Modifier.fillMaxSize()
                )
            }
            is MatchDetailsUiState.Success -> {
                UpcomingMatchDetailScreen(state.data)
            }
        }
    }
}
