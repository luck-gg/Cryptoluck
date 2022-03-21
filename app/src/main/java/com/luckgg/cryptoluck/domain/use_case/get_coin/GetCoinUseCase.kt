package com.luckgg.cryptoluck.domain.use_case.get_coin

import com.luckgg.cryptoluck.common.Resource
import com.luckgg.cryptoluck.data.remote.dto.toCoin
import com.luckgg.cryptoluck.data.remote.dto.toCoinDetail
import com.luckgg.cryptoluck.domain.model.Coin
import com.luckgg.cryptoluck.domain.model.CoinDetail
import com.luckgg.cryptoluck.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

import javax.inject.Inject

class GetCoinUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(coinId : String): Flow<Resource<CoinDetail>> = flow {
        emit(Resource.Loading())
        val coin = repository.getCoinsById(coinId).toCoinDetail()
        emit(Resource.Success(coin))
    }
}