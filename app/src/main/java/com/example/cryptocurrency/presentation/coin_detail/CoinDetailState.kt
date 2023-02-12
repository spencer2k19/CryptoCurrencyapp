package com.example.cryptocurrency.presentation.coin_detail

import com.example.cryptocurrency.domain.model.CoinDetail

data class CoinDetailState(
    val isLoading:Boolean = false,
    val coinDetail: CoinDetail? = null,
    val error:String = ""
)