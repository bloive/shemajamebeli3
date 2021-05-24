package com.example.shemajamebeli3

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ItemViewModel : ViewModel() {
    val data = MutableLiveData<MutableList<UserModel>>()
    val currentUser = MutableLiveData<UserModel>()

    init {
        data.postValue(mutableListOf())
    }

    fun save(userModel: UserModel) {
        val currentList = data.value
        currentList?.add(userModel)
        data.postValue(currentList!!)
    }
}