package com.alish.boilerplate.presentation.ui.fragments

import com.alish.boilerplate.domain.models.sign.SignIn
import com.alish.boilerplate.domain.models.sign.UserSignIn
import com.alish.boilerplate.domain.usecases.SignInUseCase
import com.alish.boilerplate.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor(
    private val signInUseCase: SignInUseCase
) : BaseViewModel() {

    private val _signInState = MutableUIStateFlow<SignIn>()
    val signInState = _signInState.asStateFlow()

    fun signIn(userSignIn: UserSignIn) {
        signInUseCase(userSignIn).collectRequest(_signInState) { it }
    }
}