package com.example.cryptocurrency.domain.use_case.get_coins

import com.example.cryptocurrency.common.Resource
import com.example.cryptocurrency.data.remote.dto.toCoin
import com.example.cryptocurrency.domain.model.Coin
import com.example.cryptocurrency.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okio.IOException
import retrofit2.HttpException
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(
    private val coinRepository: CoinRepository
){

    operator fun invoke():Flow<Resource<List<Coin>>> {
        return flow {
            try {
                emit(Resource.Loading())
                val coins = coinRepository.getCoins().map { it.toCoin() }
                emit(Resource.Success(data = coins))

            }catch (e:HttpException) {
                emit(Resource.Error(message = e.localizedMessage?:"An unexpected error occured"))
            } catch (e:IOException) {
                emit(Resource.Error(message = "Couldn' reach server. Please check your internet connection"))
            }
        }
    }
}