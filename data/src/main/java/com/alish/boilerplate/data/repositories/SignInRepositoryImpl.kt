package com.alish.boilerplate.data.repositories

import com.alish.boilerplate.data.remote.apiservices.SignInApiService
import com.alish.boilerplate.data.remote.dtos.sign.fromDomain
import com.alish.boilerplate.data.base.BaseRepository
import com.alish.boilerplate.domain.models.sign.UserSignIn
import com.alish.boilerplate.domain.repositories.SignInRepository
import javax.inject.Inject

class SignInRepositoryImpl @Inject constructor(
    private val service: SignInApiService
) : BaseRepository(), SignInRepository {

    override fun signIn(userSignIn: UserSignIn) = doNetworkRequest {
        service.signIn(userSignIn.fromDomain()).onSuccess { data ->
            /**
             * Do something with [data]
             */
            data.token
        }
    }
}