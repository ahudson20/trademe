package com.app.trademee.logic

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.app.trademee.data.repository.Repository
import com.app.trademee.logic.state.MainState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    app: Application,
    private val repository: Repository
) : AndroidViewModel(app) {

    private val mutableState = MutableStateFlow<MainState>(MainState.Loading)
    val state = mutableState.asStateFlow()

    init {
        getData()
    }

    private fun getData() = viewModelScope.launch {
        try {
            // add delay so we can see the loading state.
            delay(2000)

            val response = repository.getData()
            if(!response.isSuccessful) {
                mutableState.value = MainState.Error
            }
            mutableState.value = MainState.Success(response.body()!!.list)
        } catch (exception: Exception) {
            mutableState.value = MainState.Error
            Log.d("exception requesting data", exception.printStackTrace().toString())
        }
    }
}