package com.android.midnite.ui.viewmodel

import com.android.midnite.domain.model.UpcomingMatchDetail

sealed interface MatchDetailsUiState {
    data class Success(val data: UpcomingMatchDetail) : MatchDetailsUiState
    data class Failure(val message: String) : MatchDetailsUiState
    object Loading : MatchDetailsUiState
}
