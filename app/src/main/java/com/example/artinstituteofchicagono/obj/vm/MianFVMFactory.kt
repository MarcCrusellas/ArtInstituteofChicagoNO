package com.example.artinstituteofchicagono.obj.vm

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import kotlin.coroutines.CoroutineContext


/*
class MianFVMFactory: ViewModelProvider.Factory {

    lateinit var application: Application
    lateinit var coroutineContext: CoroutineContext

    fun MianFVMFactory(application: Application, coroutineContext: CoroutineContext){
        this.application = application
        this.coroutineContext = coroutineContext
    }


    fun <T : ViewModel?> create(modelClass: Class<T>?): T {
        return MainFVM(application, coroutineContext) as T
    }
}
*/


class MianFVMFactory(private val application: Application, private val coroutineContext: CoroutineContext) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainFVM(application, coroutineContext) as T
    }
}

/*

public class MyViewModelFactory implements ViewModelProvider.Factory {
    private Application mApplication;
    private String mParam;


    public MyViewModelFactory(Application application, String param) {
        mApplication = application;
        mParam = param;
    }


    @Override
    public <T extends ViewModel> T create(Class<T> modelClass) {
        return (T) new MyViewModel(mApplication, mParam);
    }
}
 */
