package com.emilabdurahmanli.brodcastreciever.veiw_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.emilabdurahmanli.brodcastreciever.model.DummyModel
import com.emilabdurahmanli.brodcastreciever.repository.DataRepository
import com.emilabdurahmanli.brodcastreciever.repository.IFailure

class BlankViewModel : ViewModel() {

    private var failMessage = MutableLiveData<String>()
    fun getData (){
        DataRepository.getDummyData(object : IFailure{
            override fun onFail(message: String) {

            }

        })
    }

    fun observeMessage() : LiveData<String>{
        return failMessage
    }
}