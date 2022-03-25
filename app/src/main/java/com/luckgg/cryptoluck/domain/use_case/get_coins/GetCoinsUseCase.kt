package com.luckgg.cryptoluck.domain.use_case.get_coins

import com.luckgg.cryptoluck.common.Resource
import com.luckgg.cryptoluck.data.remote.dto.toCoin
import com.luckgg.cryptoluck.domain.model.Coin
import com.luckgg.cryptoluck.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(): Flow<Resource<List<Coin>>> = flow {
        try {
            this.emit(Resource.Loading<List<Coin>>())
            val coins = repository.getCoins().map { it.toCoin() } // Transform the List of CoinDTO to a List of coins
            emit(Resource.Success(coins))
        }catch (e: HttpException){
            emit(Resource.Error<List<Coin>>("test"))
            emit(Resource.Error<List<Coin>>(e.localizedMessage?: "Hubo un error inesperado"))
        }catch (e: IOException){
            emit(Resource.Error<List<Coin>>(e.localizedMessage?: "Hubo un error inesperado"))
        }
    }
}