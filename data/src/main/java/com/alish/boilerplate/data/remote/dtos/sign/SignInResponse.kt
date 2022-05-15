package com.alish.boilerplate.data.remote.dtos.sign

import com.alish.boilerplate.domain.models.sign.SignIn
import com.google.gson.annotations.SerializedName

class SignInResponse(
    @SerializedName("token")
    val token: String
)

fun SignInResponse.toDomain() = SignIn(
    token
)