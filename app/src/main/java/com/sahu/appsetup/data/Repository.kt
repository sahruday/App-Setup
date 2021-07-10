package com.sahu.appsetup.data

import com.sahu.appUtil.Callback
import com.sahu.appUtil.MyResult
import com.sahu.appsetup.data.cache.LocalService
import com.sahu.appsetup.data.cache.dao.Table
import com.sahu.appsetup.data.remote.RemoteService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Repository @Inject constructor(
    private val remote: RemoteService,
    private val local: LocalService,
) {

    fun getData(): Flow<List<Table>> = local.getData()

    suspend fun getDataFromApi(): Flow<Callback> = flow {
        val result: MyResult<List<Int>> = remote.getData().first()
        result.handle(
            onSuccess = {
                local.insertData(it)
                emit(Callback.Success)
            },
            onFailure = {
                emit(Callback.Error(it.message))
            }
        )

    }

}