package com.example.artinstituteofchicagono.obj.vm

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.*
import com.example.artinstituteofchicagono.Repo
import com.example.artinstituteofchicagono.data.modelv2.SmallArtic
import com.example.artinstituteofchicagono.data.room.small.SmallDataBase
import com.example.artinstituteofchicagono.data.room.small.SmallPaint
import com.example.artinstituteofchicagono.obj.DateObj
import com.example.artinstituteofchicagono.obj.DateObj.formatToString
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class MainFVM(
    private val application: Application, override val coroutineContext: CoroutineContext
) : AndroidViewModel(application), CoroutineScope {


    val database: SmallDataBase by lazy { SmallDataBase.getDatabase(application) }


    //  var  call : MutableLiveData<Artic?> = Repo().fetchData()




    private val _data = MutableLiveData<List<SmallPaint>?>()
    val data: LiveData<List<SmallPaint>?> = _data

    // var call: MutableLiveData<SmallArtic?> = Repo().fetchSmallData()
    init {
        // database.paintDao().getDate(DateObj.getCurrentDateTime().formatToString("dd/MM/yyyy"))

//        launch {


        // Toast.makeText(application, "ou ${call.value}", Toast.LENGTH_SHORT).show()


        // var h = database.paintDao()
        // .getDate(DateObj.getCurrentDateTime().formatToString("dd/MM/yyyy"))
        // Toast.makeText(application.baseContext, h.toString(), Toast.LENGTH_LONG).show()
        // if (h.isEmpty()) {

            //artic =


            //  database.paintDao().getDate(DateObj.getCurrentDateTime().formatToString("dd/MM/yyyy"))


            Repo().fetchSmallData().observeForever {

                GlobalScope.launch(Dispatchers.IO) {

                if (it != null) {
                        withContext(coroutineContext){
                            _data.postValue(it.data.map { SmallPaint(it) })
                        }
                    } else {
                        withContext(coroutineContext){
                            _data.postValue(null)
                        }
                    }
                }


        }

    }

    fun getData() {

        Toast.makeText(application, "getData()", Toast.LENGTH_SHORT).show()

        Repo().fetchSmallData().observeForever {

            if (it != null) {
                //artic = it
                //Toast.makeText(application.baseContext, artic.toString(), Toast.LENGTH_SHORT).show()

                // call.postValue(artic.data.map { SmallPaint(it) })
            } else {

            }
        }

    }

    suspend fun checkDataToday(): List<SmallPaint> {
        var list =
            database.paintDao().getDate(DateObj.getCurrentDateTime().formatToString("dd/MM/yyyy"))

        return list
    }


}