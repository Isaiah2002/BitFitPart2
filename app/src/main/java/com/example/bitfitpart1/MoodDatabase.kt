package com.example.bitfitpart1

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [MoodEntry::class], version = 1, exportSchema = false)
abstract class MoodDatabase : RoomDatabae()
{
    abstract fun moodDao(): MoodDao

    companion object
    {
        @Volatile
        private var INSTANCE: MoodDatabase? = null

        fun fetDatabase(context: Context): MoodDatabase
        {
            return INSTANCE ?: sychronized(this)
            {
                val instance = Room.databaseBuilder(context.applicationContext, MoodDatabase::class.java, "mood_database").build()
                INSTANCE = instance
                instance
            }
        }
    }
}