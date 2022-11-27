package com.udacity.firstprojectshoestore

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ShoeViewModel : ViewModel() {

    var shoe = Shoe("", "", "", "")

    val listOfShoes = MutableLiveData<MutableList<Shoe>>()

    init {
        listOfShoes.value = originShoeList()

    }
    fun addShoe(shoeAdded: Shoe) {
        listOfShoes.value?.add(shoeAdded)
    }

    private fun originShoeList(): MutableList<Shoe> {
        return mutableListOf(
            Shoe("Air Speed", "Nike", "44", "Nike is so good"))
    }
}