package com.alish.boilerplate.domain.repositories

import com.alish.boilerplate.domain.utils.Either
import com.alish.boilerplate.domain.models.sign.SignIn
import com.alish.boilerplate.domain.models.sign.UserSignIn
import com.alish.boilerplate.domain.utils.NetworkError
import kotlinx.coroutines.flow.Flow

interface SignInRepository {

    fun signIn(userSignIn: UserSignIn): Flow<Either<NetworkError, SignIn>>
}