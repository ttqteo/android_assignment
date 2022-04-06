package com.example.fooddelivery

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class RestaurantViewModal : ViewModel() {
    private var _listOfData : MutableLiveData<List<Restaurant>> = MutableLiveData()
    val listOfData : LiveData<List<Restaurant>>
        get() = _listOfData

    fun loadData() {
        val data = Datastore.getDataSet()
        _listOfData.postValue(data)
    }
}