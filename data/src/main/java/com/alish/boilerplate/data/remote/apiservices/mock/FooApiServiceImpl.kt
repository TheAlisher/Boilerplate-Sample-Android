package com.alish.boilerplate.data.remote.apiservices.mock

import android.content.Context
import com.alish.boilerplate.data.remote.apiservices.FooApiService
import com.alish.boilerplate.data.remote.dtos.foo.FooDto
import com.alish.boilerplate.data.remote.dtos.foo.FooPagingResponse
import com.alish.boilerplate.data.utils.fromJson
import com.alish.boilerplate.data.utils.jsonFromAssets
import kotlinx.coroutines.delay
import retrofit2.Response
import javax.inject.Inject

/**
 * Mock class
 */
class FooApiServiceImpl @Inject constructor(
    private val context: Context
) : FooApiService {

    override suspend fun fetchFoo(page: Int): Response<FooPagingResponse<FooDto>> {
        delay(2000)
        return when (page) {
            1 -> {
                Response.success(fromJson(context.jsonFromAssets("FooPagingPage1.json")))
            }
            2 -> {
                Response.success(fromJson(context.jsonFromAssets("FooPagingPage2.json")))
            }
            3 -> {
                Response.success(fromJson(context.jsonFromAssets("FooPagingPage3.json")))
            }
            else -> {
                Response.success(fromJson(context.jsonFromAssets("FooPagingPage4.json")))
            }
        }
    }
}