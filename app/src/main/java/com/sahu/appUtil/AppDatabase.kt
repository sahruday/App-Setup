package com.sahu.appUtil

import androidx.room.Database
import androidx.room.RoomDatabase
import com.sahu.appsetup.data.cache.dao.Table
import com.sahu.appsetup.data.cache.dao.TableDao


const val DB_NAME = "AppSetUp.db"

@Database(
    entities = [Table::class],
    version = 1,
    exportSchema = true
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun tableDao() : TableDao

}