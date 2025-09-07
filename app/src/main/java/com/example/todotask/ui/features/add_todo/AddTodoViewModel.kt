package com.example.todotask.ui.features.add_todo

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todotask.domain.usecase.AddTodoUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddTodoViewModel @Inject constructor(
    private val addTodoUseCase: AddTodoUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(AddTodoUiState())
    val uiState: StateFlow<AddTodoUiState> = _uiState.asStateFlow()

    private val _effect = Channel<AddTodoEffect>()
    val effect: Flow<AddTodoEffect> = _effect.receiveAsFlow()

    fun onEvent(event: AddTodoUiEvent) {
        when (event) {
            is AddTodoUiEvent.OnAddTodoClicked -> {
                addTodo(event.title)
            }

            is AddTodoUiEvent.OnTodoTitleChanged -> {
            }
        }
    }

    private fun addTodo(title: String) {
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true) }
            try {
                addTodoUseCase(title)
                delay(3000)
                _effect.send(AddTodoEffect.NavigateBack)
            } catch (e: Exception) {
                _effect.send(AddTodoEffect.NavigateBack)
            } finally {
                _uiState.update { it.copy(isLoading = false) }
            }
        }
    }
}