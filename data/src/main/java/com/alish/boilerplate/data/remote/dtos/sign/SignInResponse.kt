package com.alish.boilerplate.data.remote.dtos.sign

import com.alish.boilerplate.data.utils.DataMapper
import com.alish.boilerplate.domain.models.sign.SignIn
import com.google.gson.annotations.SerializedName

class SignInResponse(
    @SerializedName("token")
    val token: String
) : DataMapper<SignIn> {

    override fun mapToDomain() = SignIn(
        token
    )
}