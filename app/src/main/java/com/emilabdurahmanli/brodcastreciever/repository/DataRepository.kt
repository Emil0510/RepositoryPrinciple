package com.emilabdurahmanli.brodcastreciever.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.emilabdurahmanli.brodcastreciever.DataFetcher
import com.emilabdurahmanli.brodcastreciever.DataResult
import com.emilabdurahmanli.brodcastreciever.IDataCallback
import com.emilabdurahmanli.brodcastreciever.model.DummyModel
import com.emilabdurahmanli.brodcastreciever.network.RetrofitClient

object DataRepository  {

    var data  = MutableLiveData<DummyModel>()
    fun getDummyData(iFailure : IFailure){
        DataFetcher().getDummy(object : IDataCallback{
            override fun callback(result: DataResult) {
                when(result){
                    is DataResult.Success<*> ->{
                        data.postValue(result.data as DummyModel)
                    }
                    is DataResult.Failure ->{
                        iFailure.onFail(result.message)
                    }
                    is DataResult.FailureHTTP ->{
                        iFailure.onFail(result.message)
                    }
                }
            }

        })
    }

}

interface IFailure {
    fun onFail(message : String)
}