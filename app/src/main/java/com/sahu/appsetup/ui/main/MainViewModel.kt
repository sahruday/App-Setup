package com.sahu.appsetup.ui.main

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sahu.appUtil.Callback
import com.sahu.appsetup.data.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor(
    private val repo : Repository
) : ViewModel() {

    fun getLocalData() = repo.getData()

    fun fetchData() = viewModelScope.launch(Dispatchers.IO) {
        repo.getDataFromApi().collect {
            when(it){
                is Callback.Error -> {

                }
                Callback.Success -> {

                }
            }
        }
    }
}