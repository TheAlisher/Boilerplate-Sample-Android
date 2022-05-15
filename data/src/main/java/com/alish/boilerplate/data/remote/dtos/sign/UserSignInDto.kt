package com.alish.boilerplate.data.remote.dtos.sign

import com.alish.boilerplate.domain.models.sign.UserSignIn
import com.google.gson.annotations.SerializedName

class UserSignInDto(
    @SerializedName("username")
    val username: String,
    @SerializedName("password")
    val password: String
)

fun UserSignIn.fromDomain() = UserSignInDto(
    username,
    password
)