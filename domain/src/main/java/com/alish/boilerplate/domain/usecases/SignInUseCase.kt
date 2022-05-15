package com.alish.boilerplate.domain.usecases

import com.alish.boilerplate.domain.models.sign.UserSignIn
import com.alish.boilerplate.domain.repositories.SignInRepository
import javax.inject.Inject

class SignInUseCase @Inject constructor(
    private val repository: SignInRepository
) {
    operator fun invoke(userSignIn: UserSignIn) = repository.signIn(userSignIn)
}