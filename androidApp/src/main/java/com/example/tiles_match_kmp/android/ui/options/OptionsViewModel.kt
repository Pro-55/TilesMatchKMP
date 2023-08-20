package com.example.tiles_match_kmp.android.ui.options

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tiles_match_kmp.data.model.Option
import com.example.tiles_match_kmp.data.model.Resource
import com.example.tiles_match_kmp.data.repository.contract.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class OptionsViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {

    // Global
    private val TAG = OptionsViewModel::class.java.simpleName
    private val _options = MutableLiveData<Resource<List<Option>>>()
    val options: LiveData<Resource<List<Option>>> = _options

    fun getOptions() {
        repository.getOptions()
            .onEach { _options.value = it }
            .launchIn(viewModelScope)
    }

}