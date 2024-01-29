package com.example.artinstituteofchicagono.data.room

import androidx.room.*

@Dao
interface PaintDAO {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(paint: Paint)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
   suspend fun insertAll(Courses: List<Paint>)

    @Update
    suspend fun update(paint: Paint)

    @Delete
    suspend fun delete(paint: Paint)

  /*  @Query("DELETE from paintingsData")
    suspend fun deleteAllNotes()

    @Query("SELECT * from paintingsData order by artist_id desc")
    suspend fun getAllNotes(): List<Paint>?*/



    /*@Query("SELECT * FROM movie_table WHERE id = :id LIMIT 1")
    fun retrieveMovie(id:Int): LiveData<Paint>*/

}
