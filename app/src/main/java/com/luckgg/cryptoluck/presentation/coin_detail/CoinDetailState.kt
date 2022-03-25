package com.luckgg.cryptoluck.presentation.coin_detail

import com.luckgg.cryptoluck.domain.model.CoinDetail

data class CoinDetailState(
    val isLoading: Boolean = false,
    val coin: CoinDetail? = null,
    val error: String = ""
)