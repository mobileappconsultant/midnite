package com.android.midnite.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.midnite.domain.usecase.GetMatchDetailsUseCase
import com.android.midnite.utils.DispatcherProvider
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

@HiltViewModel
class DetailsViewModel @Inject constructor(
    private val dispatcherProvider: DispatcherProvider,
    private val getMatchDetailsUseCase: GetMatchDetailsUseCase
) : ViewModel() {

    private val _state = MutableStateFlow<MatchDetailsUiState>(MatchDetailsUiState.Loading)
    val state: StateFlow<MatchDetailsUiState> = _state.asStateFlow()

    fun getMatchDetailsById(id: Int) = viewModelScope.launch(dispatcherProvider.io) {
        val result = getMatchDetailsUseCase.execute(id)
        result.data?.let {
            _state.emit(MatchDetailsUiState.Success(it))
        } ?: _state.emit(MatchDetailsUiState.Failure(result.message))
    }
}
