package com.udacity.firstprojectshoestore

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ShoeViewModel : ViewModel() {

    var shoe = Shoe("", "", "", "")

    val listOfShoes = MutableLiveData<MutableList<Shoe>>()

    fun addShoe(shoeAdded: Shoe) {
        listOfShoes.value?.add(shoeAdded)
    }
}