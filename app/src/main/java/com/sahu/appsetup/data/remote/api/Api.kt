package com.sahu.appsetup.data.remote.api

import com.sahu.appUtil.MyResult
import kotlinx.coroutines.flow.Flow
import retrofit2.Response
import retrofit2.http.GET

interface Api {

    @GET("data")
    suspend fun getData(): Flow<MyResult<List<Int>>>
}