package com.alish.boilerplate.data.repositories.base

import com.alish.boilerplate.data.utils.DataMapper
import com.alish.boilerplate.data.utils.mapToDomain
import com.alish.boilerplate.domain.utils.Either
import com.alish.boilerplate.domain.utils.NetworkError
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import okhttp3.ResponseBody
import retrofit2.Response

abstract class BaseRepository {

    /**
     * Do network request
     *
     * @return result in [flow] with [Either]
     */
    protected fun <T : DataMapper<T, S>, S> doNetworkRequest(
        request: suspend () -> Response<T>
    ) = flow<Either<NetworkError, S>> {
        request().let {
            if (it.isSuccessful && it.body() != null) {
                emit(Either.Right(it.body()!!.mapToDomain()))
            } else {
                emit(Either.Left(NetworkError.Api(it.errorBody().toApiError())))
            }
        }
    }.flowOn(Dispatchers.IO).catch { exception ->
        emit(
            Either.Left(NetworkError.Unexpected(exception.localizedMessage ?: "Error Occurred!"))
        )
    }

    /**
     * Convert network error from server side
     */
    private fun ResponseBody?.toApiError(): MutableMap<String, List<String>> {
        return Gson().fromJson(
            this?.string(),
            object : TypeToken<MutableMap<String, List<String>>>() {}.type
        )
    }
}