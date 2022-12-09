package com.danc.watchout.presentation.viewmodels

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.snapshots.Snapshot.Companion.withMutableSnapshot
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.saveable
import com.danc.watchout.domain.models.SpecificFilmResult
import com.danc.watchout.domain.usecases.SpecificFilmUseCase
import com.danc.watchout.presentation.states.FilmState
import com.danc.watchout.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SpecificFilmViewModel @Inject constructor(
    private val specificFilmUseCase: SpecificFilmUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {
    private var filmList: ArrayList<SpecificFilmResult> = ArrayList()

    private val _state = MutableStateFlow(FilmState())
    val state: StateFlow<FilmState> = _state

    private val _events = MutableSharedFlow<UIEvent>()
    val eventFlow = _events.asSharedFlow()

    private var filmJob: Job? = null

    fun loadFilms(urls: List<String>) {
        filmJob?.cancel()
        urls.forEach { url ->
            filmJob = viewModelScope.launch {
                specificFilmUseCase(url).collectLatest { film ->
                    if (film.toString().isNotEmpty()) {
                        when (film) {
                            is Resource.Loading -> {
                                _state.value = state.value.copy(
                                    specificFilm = filmList,
                                    isLoading = true
                                )
                            }
                            is Resource.Success -> {
                                filmList.add(film.data!!)
                                _state.value = state.value.copy(
                                    specificFilm = filmList,
                                    isLoading = true
                                )
                            }
                            is Resource.Error -> {
                                _state.value = state.value.copy(
                                    specificFilm = filmList,
                                    isLoading = false
                                )
                            }
                        }
                    }
                }
            }
        }
    }

    sealed class UIEvent {
        data class ShowSnackBar(val message: String) : UIEvent()
    }

}