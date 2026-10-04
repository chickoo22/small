package com.example.data.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface LearningItemDao {
    @Query("SELECT * FROM learning_items WHERE categoryId = :catId")
    fun getItemsForCategory(catId: String): Flow<List<LearningItemEntity>>

    @Query("SELECT * FROM learning_items")
    suspend fun getAllItemsSync(): List<LearningItemEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(items: List<LearningItemEntity>)

    @Query("SELECT COUNT(*) FROM learning_items")
    suspend fun getCount(): Int
}
