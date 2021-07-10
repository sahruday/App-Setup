package com.sahu.appsetup.data.cache

import com.sahu.appsetup.data.cache.dao.Table
import com.sahu.appsetup.data.cache.dao.TableDao
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LocalService @Inject constructor(
    private val tableDao: TableDao,
    //use mapper(s)
) {

    fun getData(): Flow<List<Table>> = tableDao.getDate()

    suspend fun deleteAll() = tableDao.delete()

    suspend fun insertData(list: List<Int>) =
        list.forEach { it-> tableDao.addData(Table(it)) }

}