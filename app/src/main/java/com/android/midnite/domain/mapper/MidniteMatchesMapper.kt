package com.android.midnite.domain.mapper

import com.android.midnite.data.cache.entity.MidniteMatchEntity
import com.android.midnite.data.model.*
import com.android.midnite.data.model.details.ContractDto
import com.android.midnite.data.model.details.MarketDto
import com.android.midnite.data.model.details.MidniteMatchDetailDto
import com.android.midnite.domain.model.MarketContract
import com.android.midnite.domain.model.MarketData
import com.android.midnite.domain.model.UpcomingMatchDetail
import com.android.midnite.domain.model.UpcomingMatchItem
import com.android.midnite.utils.Constants.DATE_FORMAT
import javax.inject.Inject

class MidniteMatchesMapper @Inject constructor() {
    fun mapToEntity(matchDataDto: MatchDataDto, page: Int): MidniteMatchEntity = MidniteMatchEntity(
        id = matchDataDto.id,
        page = page,
        homeTeam = matchDataDto.homeTeam,
        awayTeam = matchDataDto.awayTeam,
        homeImageUrl = matchDataDto.homeImageUrl,
        awayImageUrl = matchDataDto.awayImageUrl,
        gameName = matchDataDto.gameName,
        competitionName = matchDataDto.competitionName,
        startTime = matchDataDto.startTime.toString(DATE_FORMAT)
    )

    fun mapToItem(matchEntity: MidniteMatchEntity): UpcomingMatchItem = UpcomingMatchItem(
        id = matchEntity.id,
        homeTeam = matchEntity.homeTeam,
        awayTeam = matchEntity.awayTeam,
        homeImageUrl = matchEntity.homeImageUrl,
        awayImageUrl = matchEntity.awayImageUrl,
        gameName = matchEntity.gameName,
        competitionName = matchEntity.competitionName,
        startTime = matchEntity.startTime
    )

    fun mapToItem(dto: MidniteMatchDetailDto): UpcomingMatchDetail =
        UpcomingMatchDetail(
            id = dto.id,
            homeTeam = dto.homeTeam,
            awayTeam = dto.awayTeam,
            homeImageUrl = dto.homeImageUrl,
            awayImageUrl = dto.awayImageUrl,
            gameName = dto.gameName,
            competitionName = dto.competitionName,
            startTime = dto.startTime.toString(DATE_FORMAT),
            marketData = dto.markets.map { mapToMarketData(it) },
        )

    private fun mapToMarketData(market: MarketDto): MarketData =
        MarketData(
            name = market.name,
            status = market.status,
            contracts = market.contracts.map { mapToContract(it) }
        )

    private fun mapToContract(contract: ContractDto): MarketContract =
        MarketContract(
            name = contract.name,
            price = contract.price,
            maxBet = contract.maxBet
        )
}
