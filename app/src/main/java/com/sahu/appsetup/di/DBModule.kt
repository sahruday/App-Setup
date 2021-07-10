package com.sahu.appsetup.di

import android.content.Context
import androidx.room.Room
import com.sahu.appUtil.AppDatabase
import com.sahu.appUtil.DB_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DBModule {

    @Singleton
    @Provides
    fun getDB(@ApplicationContext context: Context): AppDatabase = Room.databaseBuilder(context, AppDatabase::class.java, DB_NAME)
        .build()

    @Singleton
    @Provides
    fun getNewsDao(appDatabase: AppDatabase) = appDatabase.tableDao()
}