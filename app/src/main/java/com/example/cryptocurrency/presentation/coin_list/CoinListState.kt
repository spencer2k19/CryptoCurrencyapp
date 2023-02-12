package com.example.cryptocurrency.presentation.coin_list

import com.example.cryptocurrency.domain.model.Coin

data class CoinListState(
    val isLoading:Boolean = false,
    val coins:List<Coin> = emptyList(),
    val error:String = ""
)
