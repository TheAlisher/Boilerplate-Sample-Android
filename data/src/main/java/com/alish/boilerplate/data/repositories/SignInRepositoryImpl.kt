package com.alish.boilerplate.data.repositories

import com.alish.boilerplate.data.remote.apiservices.SignInApiService
import com.alish.boilerplate.data.remote.dtos.sign.UserSignInDto
import com.alish.boilerplate.data.remote.dtos.sign.fromDomain
import com.alish.boilerplate.data.remote.dtos.sign.toDomain
import com.alish.boilerplate.data.repositories.base.BaseRepository
import com.alish.boilerplate.domain.Either
import com.alish.boilerplate.domain.models.sign.SignIn
import com.alish.boilerplate.domain.models.sign.UserSignIn
import com.alish.boilerplate.domain.repositories.SignInRepository
import javax.inject.Inject

class SignInRepositoryImpl @Inject constructor(
    private val service: SignInApiService
) : BaseRepository(), SignInRepository {

    override fun signIn(userSignIn: UserSignIn) = doRequest(this::setupSignInSuccess) {
        service.signIn(userSignIn.fromDomain()).toDomain()
    }

    private fun setupSignInSuccess(signIn: SignIn) {
        // save token
        signIn.token
    }
}