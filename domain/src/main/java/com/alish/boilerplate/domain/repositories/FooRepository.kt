package com.alish.boilerplate.domain.repositories

import androidx.paging.PagingData
import com.alish.boilerplate.domain.models.foo.Foo
import kotlinx.coroutines.flow.Flow

interface FooRepository {

    fun fetchFoo(): Flow<PagingData<Foo>>
}