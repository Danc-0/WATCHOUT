package com.danc.watchout.presentation.viewmodels

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.danc.watchout.domain.usecases.PeoplesUseCase
import com.danc.watchout.presentation.states.PeopleState
import com.danc.watchout.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PeopleViewModel @Inject constructor(
    private val peoplesUseCase: PeoplesUseCase
) : ViewModel() {

    private val _state = mutableStateOf(PeopleState())
    val state: State<PeopleState> = _state

    private val _eventFlow = MutableSharedFlow<UIEvent>()
    val sharedEventFlow = _eventFlow.asSharedFlow()

    private var peoplesJob: Job? = null

    init {
        getAllPeople()
    }

    private fun getAllPeople() {
        peoplesJob?.cancel()
        peoplesJob = viewModelScope.launch {
            peoplesUseCase()
                .onEach { response ->
                    when (response) {
                        is Resource.Success -> {
                            _state.value = state.value.copy(
                                allPeople = response.data,
                                isLoading = false
                            )
                        }

                        is Resource.Loading -> {
                            _state.value = state.value.copy(
                                allPeople = response.data,
                                isLoading = true
                            )
                        }

                        is Resource.Error -> {
                            _state.value = state.value.copy(
                                allPeople = response.data,
                                isLoading = false
                            )
                            _eventFlow.emit(
                                UIEvent.ShowSnackBar(
                                    response.message ?: "Unknown Error Occurred"
                                )
                            )
                        }
                    }
                }.launchIn(this)
        }
    }

    sealed class UIEvent {
        data class ShowSnackBar(val message: String) : UIEvent()
    }

}