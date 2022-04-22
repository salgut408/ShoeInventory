package com.example.myapplicationshoes.screens.shoelisting

import android.util.Log
import androidx.databinding.Bindable
import androidx.databinding.Observable
import androidx.databinding.PropertyChangeRegistry
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplicationshoes.models.Shoe
import com.example.myapplicationshoes.BR

class ShoeListingViewModel : ViewModel(), Observable {

    private  val propertyChangeRegistry = PropertyChangeRegistry()
    private val shoes = MutableLiveData<MutableList<Shoe>>(mutableListOf())

    init {
        Log.i("shoe list model", "shoe list ViewModel created")
    }
    @Bindable
    var shoe = Shoe()
    set(value){
        if(value != field){
            field = value
            propertyChangeRegistry.notifyChange(this, BR.shoe)
        }
    }

    fun getShoeLiveData(): LiveData<MutableList<Shoe>> = shoes

    fun addShoe(item: Shoe?) {
        item?.let {
            shoes.value?.add(item)
        }
    }

    override fun onCleared() {
        super.onCleared()
        Log.i("shoe list model", "shoe list model destroyed")
    }

    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
        propertyChangeRegistry.add(callback)
    }

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
        propertyChangeRegistry.remove(callback)
    }
}

























