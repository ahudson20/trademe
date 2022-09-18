package com.app.trademee.logic.state

import com.app.trademee.data.model.Listing

sealed class MainState {
    object Loading: MainState()
    data class Success(val listings: List<Listing>): MainState()
    object Error: MainState()
}