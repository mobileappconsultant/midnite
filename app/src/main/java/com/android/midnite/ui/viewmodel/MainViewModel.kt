package com.android.midnite.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.android.midnite.domain.model.UpcomingMatchItem
import com.android.midnite.domain.usecase.GetUpcomingMatchesUseCase
import com.android.midnite.utils.DispatcherProvider
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getHeadlinesUseCase: GetUpcomingMatchesUseCase,
    private val dispatchers: DispatcherProvider
) : ViewModel() {

    private val _pagingData = MutableStateFlow<PagingData<UpcomingMatchItem>>(PagingData.empty())
    val pagingData = _pagingData.asStateFlow()

    init {
        getUpcomingMatches()
    }

    fun getUpcomingMatches() {
        viewModelScope.launch(dispatchers.io) {
            getHeadlinesUseCase.execute()
                .cachedIn(this)
                .collect {
                    _pagingData.value = it
                }
        }
    }
}
