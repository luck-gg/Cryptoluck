package com.luckgg.cryptoluck.data.repository

import com.luckgg.cryptoluck.data.remote.CoinPaprikaAPI
import com.luckgg.cryptoluck.data.remote.dto.CoinDetailDto
import com.luckgg.cryptoluck.data.remote.dto.CoinDto
import com.luckgg.cryptoluck.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api: CoinPaprikaAPI
) : CoinRepository {
    override suspend fun getCoins(): List<CoinDto> {
        return api.getCoins()
    }

    override suspend fun getCoinsById(coinId: String): CoinDetailDto {
        return api.getCoinById(coinId)
    }
}