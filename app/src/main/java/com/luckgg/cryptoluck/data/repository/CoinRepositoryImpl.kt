package com.luckgg.cryptoluck.data.repository

import com.luckgg.cryptoluck.common.Resource
import com.luckgg.cryptoluck.data.remote.CoinPaprikaAPI
import com.luckgg.cryptoluck.data.remote.dto.CoinDetailDto
import com.luckgg.cryptoluck.data.remote.dto.CoinDto
import com.luckgg.cryptoluck.data.remote.dto.toCoin
import com.luckgg.cryptoluck.data.remote.dto.toCoinDetail
import com.luckgg.cryptoluck.domain.model.Coin
import com.luckgg.cryptoluck.domain.model.CoinDetail
import com.luckgg.cryptoluck.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api: CoinPaprikaAPI
) : CoinRepository {

    override suspend fun getCoins(): Resource<List<Coin>> {
        return try {
            val coins = api.getCoins().map { it.toCoin() } // Transform the List of CoinDTO to a List of coins
            Resource.Success(coins)
        }catch (e: HttpException){
            Resource.Error<List<Coin>>(e.localizedMessage?: "Hubo un error inesperado")
        }catch (e: IOException){
            Resource.Error<List<Coin>>(e.localizedMessage?: "Hubo un error inesperado")
        }
    }

    override suspend fun getCoinsById(coinId: String): Resource<CoinDetail> {

        return try {
            val coin = api.getCoinById(coinId).toCoinDetail()
            Resource.Success(coin)
        }
        catch (e: HttpException){
            Resource.Error<CoinDetail>(e.localizedMessage?: "Hubo un error inesperado")
        }
        catch (e: IOException){
            Resource.Error<CoinDetail>(e.localizedMessage?: "Hubo un error inesperado")
        }
    }
}