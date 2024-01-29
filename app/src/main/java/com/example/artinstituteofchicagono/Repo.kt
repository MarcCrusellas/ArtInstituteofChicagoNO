package com.example.artinstituteofchicagono

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.artinstituteofchicagono.data.ApiCall
import com.example.artinstituteofchicagono.data.model.Artic
import com.example.artinstituteofchicagono.data.modelv2.SmallArtic
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class Repo {

    private val api = ApiCall.create()
    var dataInfo = MutableLiveData<Artic?>()
    var dataSmallInfo = MutableLiveData<SmallArtic?>()
    // var planetInfo = MutableLiveData<Planet>()


    fun fetchData(): MutableLiveData<Artic?> {

        val call = api.getPag()
        call.enqueue(object: Callback<Artic> {

            override fun onFailure(call: Call<Artic>, t: Throwable) {
                Log.wtf("My ERROR", t.message.toString())
                Log.wtf("My ERROR cause", t.cause.toString())
                Log.wtf("My ERROR", t.localizedMessage)
                Log.wtf("My ERROR", t.stackTrace.toString())
                // throw error("rrr")
                dataInfo.postValue(null)

            }

            override fun onResponse(call: Call<Artic?>, response: Response<Artic?>) {
                if (response.isSuccessful) {
                    dataInfo.value = response.body()
                    // Log.wtf("0K", response.body().toString())
                    // throw error("sss")
                }
            }
        })

        return dataInfo
    }


    fun fetchSmallData(): MutableLiveData<SmallArtic?> {

        val call = api.getSmallArt()
        call.enqueue(object: Callback<SmallArtic> {

            override fun onFailure(call: Call<SmallArtic>, t: Throwable) {
                Log.wtf("My ERROR", t.message.toString())
                Log.wtf("My ERROR cause", t.cause.toString())
                Log.wtf("My ERROR", t.localizedMessage)
                Log.wtf("My ERROR", t.stackTrace.toString())
                // throw error("rrr")
                dataSmallInfo.postValue(null)

            }

            override fun onResponse(call: Call<SmallArtic?>, response: Response<SmallArtic?>) {
                if (response.isSuccessful) {
                    dataSmallInfo.value = response.body()
                    Log.wtf("0K", response.body().toString())
                    // throw error("sss")
                }
            }
        })

        return dataSmallInfo
    }


}