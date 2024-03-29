package com.alish.boilerplate.data.remote.pagingsources

import com.alish.boilerplate.data.base.BasePagingSource
import com.alish.boilerplate.data.remote.apiservices.FooApiService
import com.alish.boilerplate.data.remote.dtos.foo.FooDto
import com.alish.boilerplate.domain.models.foo.Foo

class FooPagingSource(
    private val service: FooApiService
) : BasePagingSource<FooDto, Foo>(
    { service.fetchFoo(it) }
)