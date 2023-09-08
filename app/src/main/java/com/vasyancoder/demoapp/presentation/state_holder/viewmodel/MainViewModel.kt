package com.vasyancoder.demoapp.presentation.state_holder.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vasyancoder.demoapp.data.repository.GifRepositoryImpl
import com.vasyancoder.demoapp.domain.Resource
import com.vasyancoder.demoapp.domain.usecase.GetTrendGifListUseCase
import com.vasyancoder.demoapp.presentation.state_holder.ErrorUiUiState
import com.vasyancoder.demoapp.presentation.state_holder.LoadingUiUiState
import com.vasyancoder.demoapp.presentation.state_holder.MainUiState
import com.vasyancoder.demoapp.presentation.state_holder.ResultSuccessUiUiState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val repository = GifRepositoryImpl()
    private val getTrendGifListUseCase = GetTrendGifListUseCase(repository)

    private val _mainState: MutableStateFlow<MainUiState> = MutableStateFlow(LoadingUiUiState)
    val mainState: StateFlow<MainUiState> = _mainState

//    private val _mainStateLd: MutableLiveData<MainUiState> = MutableLiveData(LoadingUiUiState)
//    val mainStateLd: LiveData<MainUiState>
//        get() = _mainStateLd

    fun getGifList() {
        viewModelScope.launch(Dispatchers.IO) {
            when (val result = getTrendGifListUseCase()) {
                is Resource.Success -> {
//                    _mainStateLd.postValue(ResultSuccess(result.data!!.dataGif))
                    _mainState.value = ResultSuccessUiUiState(result.data!!.dataGif)
                }

                is Resource.Error -> {
                    _mainState.value =
                        ErrorUiUiState(
                            result.message ?: "An resource unknown error occurred"
                        )
                }
            }
        }
    }
}
