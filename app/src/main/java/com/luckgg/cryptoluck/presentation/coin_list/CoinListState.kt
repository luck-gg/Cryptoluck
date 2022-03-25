package com.luckgg.cryptoluck.presentation.coin_list

import com.luckgg.cryptoluck.common.Resource
import com.luckgg.cryptoluck.domain.model.Coin

data class CoinListState(
    val isLoading: Boolean = false,
    val coins: List<Coin> = emptyList(),
    val error: String = ""
)