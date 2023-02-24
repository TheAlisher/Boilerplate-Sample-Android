package com.alish.boilerplate.domain.repositories

import com.alish.boilerplate.domain.models.sign.SignIn
import com.alish.boilerplate.domain.models.sign.UserSignIn
import com.alish.boilerplate.domain.utils.RemoteWrapper

interface SignInRepository {

    fun signIn(userSignIn: UserSignIn): RemoteWrapper<SignIn>
}