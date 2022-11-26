package com.udacity.firstprojectshoestore

import androidx.databinding.adapters.ViewGroupBindingAdapter.OnChildViewAdded
import androidx.lifecycle.MutableLiveData

class ViewModel {

    var shoe = Shoe("", "", "", "")

    var listOfShoes = MutableLiveData<MutableList<Shoe>>()


    fun addShoe(shoeAdded: Shoe) {
        listOfShoes.value?.add(shoeAdded)
    }
}