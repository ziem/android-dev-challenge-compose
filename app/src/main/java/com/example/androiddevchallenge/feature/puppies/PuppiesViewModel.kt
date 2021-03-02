package com.example.androiddevchallenge.feature.puppies

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
class PuppiesViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val puppiesRepository: PuppiesRepository,
) : ViewModel() {
    private val _puppies = MutableStateFlow<List<Puppy>>(emptyList())

    val puppies: StateFlow<List<Puppy>>
        get() = _puppies

    init {
        viewModelScope.launch {
            _puppies.value = puppiesRepository.getPuppies()
        }
    }
}