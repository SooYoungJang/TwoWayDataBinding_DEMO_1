package com.anushka.viewmodeldemo2

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel(startingTotal : Int) : ViewModel() {
    private var total = MutableLiveData<Int>()

    val inputText = MutableLiveData<String>()

    val totalData : LiveData<Int>
    get() = total

    init {
        total.value = startingTotal
    }

    fun setTotal(){
        val num : Int = inputText.value!!.toInt()
        total.value =(total.value)?.plus(num)
    }
}