package com.android.midnite.domain.usecase

import com.android.midnite.data.model.details.MidniteMatchDetailDto
import com.android.midnite.data.repository.MatchesLocalRepository
import com.android.midnite.data.repository.MidniteRemoteRepository
import com.android.midnite.domain.mapper.MidniteMatchesMapper
import com.android.midnite.utils.ApiResult
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Assert

import org.junit.Before
import org.junit.Test

class GetMatchDetailsUseCaseTest {

    private lateinit var underTest: GetMatchDetailsUseCase

    @MockK
    private lateinit var matchesLocalRepository: MatchesLocalRepository

    @MockK
    private lateinit var midniteRemoteRepository: MidniteRemoteRepository

    private val midniteMatchesMapper = MidniteMatchesMapper()

    private val mockedMidniteMatchDetailDto = mockk<MidniteMatchDetailDto>(relaxed = true)

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        underTest = GetMatchDetailsUseCase(
            midniteRemoteRepository = midniteRemoteRepository,
            matchesMapper = midniteMatchesMapper
        )
    }

    @Test
    fun `given when execute is called and the request is successful, verify that the correct data is returned`() = runTest {
        coEvery { midniteRemoteRepository.getMatchDetails(any()) } returns ApiResult.Success(mockedMidniteMatchDetailDto)
        val actual = underTest.execute(7)
        Assert.assertTrue(actual.data != null)
    }
}
