package com.penatabahasa.a10119200latihan7.ui.detail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.penatabahasa.a10119200latihan7.model.detail.DetailResponse
import com.penatabahasa.a10119200latihan7.utils.NetworkResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

/*
14 Juli 2022
10119200
Muhammad Jafar Shidik
IF-5
*/

@HiltViewModel
class DetailViewModel @Inject constructor(private val repository: DetailRepository) : ViewModel() {

    val detailResponse: MutableLiveData<DetailResponse?> = MutableLiveData()
    val isLoading: MutableLiveData<Boolean> = MutableLiveData(true)
    val onError: MutableLiveData<String?> = MutableLiveData()

    fun getDetail(
        apiKey: String,
        symbol: String
    ) = viewModelScope.launch {
        isLoading.value = true
        when (val request = repository.getDetail(apiKey, symbol)) {
            is NetworkResult.Success -> {
                isLoading.value = false
                detailResponse.value = request.data
            }
            is NetworkResult.Error -> {
                isLoading.value = false
                onError.value = request.message
            }
        }
    }
}