package com.alish.boilerplate.data.remote.apiservices

import android.content.Context
import com.alish.boilerplate.data.remote.dtos.sign.SignInResponse
import com.alish.boilerplate.data.remote.dtos.sign.UserSignInDto
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.delay
import okhttp3.ResponseBody.Companion.toResponseBody
import retrofit2.Response
import javax.inject.Inject

/**
 * Mock class
 */
class SignInApiServiceImpl @Inject constructor(
    private val context: Context
) : SignInApiService {

    private inline fun <reified T> fromJson(fileName: String): T {
        return Gson().fromJson(fileName, object : TypeToken<T>() {}.type)
    }

    private fun jsonFromAssets(fileName: String): String {
        return context.assets.open(fileName).bufferedReader().use { it.readText() }
    }

    override suspend fun signIn(userSignInDto: UserSignInDto): Response<SignInResponse> {
        delay(1000)
        return if (userSignInDto.username == "OnePunchMan" && userSignInDto.password == "Fubuk1") {
            Response.success(fromJson(jsonFromAssets("SignInResponse.json")))
        } else {
            Response.error(422, jsonFromAssets("ErrorBody.json").toResponseBody())
        }
    }
}