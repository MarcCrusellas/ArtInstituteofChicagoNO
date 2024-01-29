package com.example.artinstituteofchicagono.data.room.small

import androidx.room.*


@Dao
interface SmallPaintDAO {


    @Query("SELECT * FROM SmallPaint as db WHERE db.time LIKE :gTime")
    suspend fun getDate(gTime: String):  List<SmallPaint>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(sPaint: SmallPaint)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertAll(Courses: List<SmallPaint>)

    @Update
    suspend fun update(paint: SmallPaint)

    @Delete
    suspend fun delete(paint: SmallPaint)
}