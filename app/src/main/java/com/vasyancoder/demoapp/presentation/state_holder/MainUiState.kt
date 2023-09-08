package com.vasyancoder.demoapp.presentation.state_holder

import com.vasyancoder.demoapp.domain.entity.DataGif

sealed class MainUiState

data object LoadingUiUiState : MainUiState()
class ResultSuccessUiUiState(val gifList: List<DataGif>) : MainUiState()
class ErrorUiUiState(val message: String) : MainUiState()
