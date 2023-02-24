package com.alish.boilerplate.domain.repositories

import com.alish.boilerplate.domain.models.foo.Foo
import com.alish.boilerplate.domain.utils.RemotePagingWrapper

interface FooRepository {

    fun fetchFoo(): RemotePagingWrapper<Foo>
}