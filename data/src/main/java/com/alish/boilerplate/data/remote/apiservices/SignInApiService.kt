package com.alish.boilerplate.data.remote.apiservices

import com.alish.boilerplate.data.remote.dtos.sign.SignInResponse
import com.alish.boilerplate.data.remote.dtos.sign.UserSignInDto
import retrofit2.http.Body
import retrofit2.http.POST

interface SignInApiService {

    @POST
    suspend fun signIn(@Body userSignInDto: UserSignInDto): SignInResponse
}