package com.example.artinstituteofchicagono.data

import android.util.Log
import com.example.artinstituteofchicagono.data.model.Artic
import com.example.artinstituteofchicagono.data.modelv2.SmallArtic
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiCall {

    // api/v1/artworks
// /api/v1/artworks?limit=100
    @GET("/api/v1/artworks")
    fun getData(): Call<Artic>

    @GET("/api/v1/artworks?page=1&limit=60")
    fun getPag(): Call<Artic>
// fields=id,title,artist_display,image_id,date_display,main_reference_number,artist_id,artist_title
// /api/v1/artworks?page=2&limit=60&fields=id,title,artist_display,image_id,date_display,main_reference_number,artist_id,artist_title


    //    /api/v1/artworks?page=2&limit=60&fields=id,title,artist_display,image_id,date_display,main_reference_number,artist_id,artist_title&image_id__isnull=False
    @GET("/api/v1/artworks?page=2&limit=60&fields=id,title,artist_display,image_id,date_display,main_reference_number,artist_id,artist_title")
    fun getSmallArt(): Call<SmallArtic>

    // https://api.artic.edu/api/v1/artworks
    companion object {
        private const val BASE_URL = "https://api.artic.edu"

        fun create(): ApiCall {
            Log.wtf("ApiCall", BASE_URL)

            val client = OkHttpClient.Builder().build()
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build()
            return retrofit.create(ApiCall::class.java)
        }

    }
}