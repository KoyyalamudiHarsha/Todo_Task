package com.example.todotask.ui.features.todo_list

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todotask.domain.usecase.GetTodosUseCase
import com.example.todotask.domain.usecase.SearchTodosUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@OptIn(FlowPreview::class)
@HiltViewModel
class TodoListViewModel @Inject constructor(
    private val getTodosUseCase: GetTodosUseCase,
    private val searchTodosUseCase: SearchTodosUseCase,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _uiState = MutableStateFlow(TodoListUiState())
    val uiState = _uiState.asStateFlow()

    private val _todos = getTodosUseCase()

    init {
        val errorMessage = savedStateHandle.get<String>("error_message")
        if (errorMessage != null) {
            _uiState.update { it.copy(error = errorMessage) }
            savedStateHandle.remove<String>("error_message")
        }

        _todos.combine(uiState) { todos, state ->
            val filteredList = searchTodosUseCase(todos, state.searchQuery)
            _uiState.update {
                it.copy(
                    todos = filteredList,
                    isLoading = false
                )
            }
        }
            .debounce(500L)
            .launchIn(viewModelScope)
    }

    fun onEvent(event: TodoListEvent) {
        when (event) {
            is TodoListEvent.OnSearchQueryChanged -> {
                _uiState.update { it.copy(searchQuery = event.query) }
            }
            is TodoListEvent.OnClearError -> {
                _uiState.update { it.copy(error = null) }
            }
        }
    }
}