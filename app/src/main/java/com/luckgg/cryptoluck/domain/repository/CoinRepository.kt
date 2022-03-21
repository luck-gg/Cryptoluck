package com.luckgg.cryptoluck.domain.repository

import com.luckgg.cryptoluck.data.remote.dto.CoinDetailDto
import com.luckgg.cryptoluck.data.remote.dto.CoinDto

//For test purposes
interface CoinRepository {

    suspend fun getCoins(): List<CoinDto>

    suspend fun getCoinsbyId(coinId:String):CoinDetailDto
}