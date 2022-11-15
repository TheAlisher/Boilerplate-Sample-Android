package com.alish.boilerplate.presentation.ui.fragments.main.home

import com.alish.boilerplate.domain.usecases.FetchFooUseCase
import com.alish.boilerplate.presentation.base.BaseViewModel
import com.alish.boilerplate.presentation.models.foo.toUI
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val fetchFooUseCase: FetchFooUseCase
) : BaseViewModel() {

    fun fetchFoo() = fetchFooUseCase().collectPagingRequest { it.toUI() }
}