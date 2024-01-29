package com.example.artinstituteofchicagono.data.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase


@Database(entities = [Paint::class], version = 1, exportSchema = false)
abstract class PaintDatabase : RoomDatabase() {
    abstract fun paintDao(): PaintDAO

/*
    private var INSTANCE: PaintDatabase? = null
    fun getInstance(context: Context): PaintDatabase {
        if (INSTANCE == null) {
            synchronized(PaintDatabase::class) {
                INSTANCE = buildRoomDB(context)
            }
        }
        return INSTANCE!!
    }
    private fun buildRoomDB(context: Context) =
        Room.databaseBuilder(
            context.applicationContext,
            PaintDatabase::class.java,
            "geeksforgeeks-example-coroutines"
        ).build()



 */

    // private var instance: PaintDatabase? = null
    /*companion object {


        @Synchronized
        fun getInstance(ctx: Context): PaintDatabase {
            if(instance == null)
                instance = Room.databaseBuilder(ctx.applicationContext, PaintDatabase::class.java,
                    "paintingsData")
                    .fallbackToDestructiveMigration()
                    .addCallback(roomCallback)
                    .build()

            return instance!!

        }

        private val roomCallback = object : RoomDatabase.Callback() {
            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)
                // populateDatabase(instance!!)
            }
        }

        *//*private fun populateDatabase(db: PaintDatabase) {
            val noteDao = db.paintDao()
            subscribeOnBackground {
                noteDao.insert(Paint("title 1", "desc 1", 1))
                noteDao.insert(Paint("title 2", "desc 2", 2))
                noteDao.insert(Paint("title 3", "desc 3", 3))

            }
        }*//*
    }

    companion object {
        @Volatile
        private var INSTANCE: PaintDatabase? = null

        fun getDatabase(context: Context): PaintDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    PaintDatabase::class.java,
                    "paintingsData"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }

*/

    companion object {
        @Volatile
        private var instance: PaintDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: buildDatabase(context).also { instance = it }
        }

        private fun buildDatabase(context: Context) = Room.databaseBuilder(
            context,
            PaintDatabase::class.java,
            "paintingsData"
        )
            .build()
    }

}