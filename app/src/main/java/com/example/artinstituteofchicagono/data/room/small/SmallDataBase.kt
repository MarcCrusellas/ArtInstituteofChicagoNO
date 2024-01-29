package com.example.artinstituteofchicagono.data.room.small

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [SmallPaint::class], version = 1, exportSchema = false)
abstract class SmallDataBase : RoomDatabase() {
    abstract fun paintDao(): SmallPaintDAO



    companion object {
        @Volatile
        private var INSTANCE: SmallDataBase? = null

        fun getDatabase(context: Context): SmallDataBase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context,
                    SmallDataBase::class.java,
                    "small_app_database")
                    .build()
                INSTANCE = instance

                instance
            }
        }
    }


}