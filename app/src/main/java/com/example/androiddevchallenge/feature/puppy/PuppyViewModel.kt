package com.example.androiddevchallenge.feature.puppy

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androiddevchallenge.data.PuppiesRepository
import com.example.androiddevchallenge.data.Puppy
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@ExperimentalCoroutinesApi
@HiltViewModel
class PuppyViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val puppiesRepository: PuppiesRepository,
) : ViewModel() {
    // TODO
    private val _puppy = MutableStateFlow<Puppy?>(null)

    val puppy: StateFlow<Puppy?>
        get() = _puppy

    init {
        viewModelScope.launch {
            // TODO
            _puppy.value = puppiesRepository.getPuppy(1)
        }
    }
}