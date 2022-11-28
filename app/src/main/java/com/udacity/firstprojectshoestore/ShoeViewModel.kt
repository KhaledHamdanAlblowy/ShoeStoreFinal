package com.udacity.firstprojectshoestore

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ShoeViewModel : ViewModel() {

    var shoe = Shoe("", "", "", "")

    val listOfShoes = MutableLiveData<MutableList<Shoe>>()

    init {
        listOfShoes.value = mutableListOf(
            Shoe("Shoe", "24", "Adidas", "Adidas is so good")
        )

    }

    fun addShoe(shoeAdded: Shoe) {
        listOfShoes.value?.add(shoeAdded)
    }

}