package com.android.midnite.ui.composable

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.paging.PagingData
import androidx.paging.compose.collectAsLazyPagingItems
import com.android.midnite.domain.model.UpcomingMatchItem
import com.android.midnite.ui.screens.main.UpcomingMatchesList
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.flow.flowOf
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class UpcomingMatchesListTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    private val mockedAwayTeam1 = "mockedAwayTeam1"
    private val mockedAwayTeam2 = "mockedAwayTeam2"

    private val mockedUpcomingItem = mockk<UpcomingMatchItem>(relaxed = true)

    private val mockedUpcomingItem2 = mockk<UpcomingMatchItem>(relaxed = true)

    @Test
    fun `given UpcomingMatchesList Composable when PagingItems is available, then the correct data should be displayed`() {
        val upcomingItems = flowOf(PagingData.from(listOf(mockedUpcomingItem, mockedUpcomingItem2)))
        every { mockedUpcomingItem.awayTeam } returns mockedAwayTeam1
        every { mockedUpcomingItem2.awayTeam } returns mockedAwayTeam2

        composeTestRule.setContent {
            upcomingItems.collectAsLazyPagingItems()
            UpcomingMatchesList(listItems = upcomingItems.collectAsLazyPagingItems()) {
            }
        }
        composeTestRule.onNodeWithText(mockedAwayTeam1).assertIsDisplayed()
        composeTestRule.onNodeWithText(mockedAwayTeam2).assertIsDisplayed()
    }
}
