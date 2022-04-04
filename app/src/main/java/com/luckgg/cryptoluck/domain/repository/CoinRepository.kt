package com.luckgg.cryptoluck.domain.repository

import com.luckgg.cryptoluck.common.Resource
import com.luckgg.cryptoluck.data.remote.dto.CoinDetailDto
import com.luckgg.cryptoluck.data.remote.dto.CoinDto
import com.luckgg.cryptoluck.domain.model.Coin
import com.luckgg.cryptoluck.domain.model.CoinDetail
import kotlinx.coroutines.flow.Flow

//For test purposes
interface CoinRepository {

    suspend fun getCoins(): Resource<List<Coin>>

    suspend fun getCoinsById(coinId:String): Resource<CoinDetail>
}