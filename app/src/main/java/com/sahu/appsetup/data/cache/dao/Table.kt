package com.sahu.appsetup.data.cache.dao

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Entity
data class Table(
    @PrimaryKey val id: Int
)

@Dao
interface TableDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addData(table: Table)

    @Query("SELECT * FROM `Table`")
    fun getDate(): Flow<List<Table>>

    @Query("DELETE FROM `Table` WHERE 1=1")
    suspend fun delete()
}