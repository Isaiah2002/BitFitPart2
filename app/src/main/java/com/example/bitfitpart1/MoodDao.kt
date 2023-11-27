package com.example.bitfitpart1


import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow


@Dao
interface MoodDao {
    @Insert
    fun Insert(moodEntry: MoodEntry): Long

    @Query("SELECT * FROM mood_entries")
    fun getALlEntries(): Flow<List<MoodEntry>>
}