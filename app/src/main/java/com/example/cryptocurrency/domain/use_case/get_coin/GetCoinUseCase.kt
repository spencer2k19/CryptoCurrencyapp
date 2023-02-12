package com.example.cryptocurrency.domain.use_case.get_coin

import com.example.cryptocurrency.common.Resource
import com.example.cryptocurrency.data.remote.dto.toCoinDetail
import com.example.cryptocurrency.domain.model.CoinDetail
import com.example.cryptocurrency.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okio.IOException
import retrofit2.HttpException
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(
    private val coinRepository: CoinRepository
) {
     operator fun invoke(coinId:String):Flow<Resource<CoinDetail>> {
        return flow {
            try {
                emit(Resource.Loading())
                val coinDetail = coinRepository.getCoinById(coinId).toCoinDetail()
                emit(Resource.Success(data = coinDetail))
            }catch (e:HttpException) {
                emit(Resource.Error(e.localizedMessage?:"An unexpected error occured"))
            }catch (e:IOException) {
                emit(Resource.Error("Couldn't reach server. Please check your internet connection"))
            }
        }
    }
}