package com.android.midnite.ui.viewmodel

import com.android.midnite.TestDispatcherProvider
import com.android.midnite.domain.usecase.GetUpcomingMatchesUseCase
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test

class MainViewModelTest {

    private lateinit var underTest: MainViewModel

    @MockK
    private lateinit var getUpcomingMatchesUseCase: GetUpcomingMatchesUseCase

    private val testDispatcherProvider = TestDispatcherProvider()

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        underTest = MainViewModel(
            getUpcomingMatchesUseCase,
            testDispatcherProvider
        )
    }

    @Test
    fun `given when getUpcomingMatches is call, verify that the required methods are called`() = runTest {
        coEvery { getUpcomingMatchesUseCase.execute() } returns flowOf()
        underTest.getUpcomingMatches()

        coVerify { getUpcomingMatchesUseCase.execute() }
    }
}
