package com.example.todotask.ui.features.todo_list

import com.example.todotask.domain.model.Todo

data class TodoListUiState(
    val todos: List<Todo> = emptyList(),
    val searchQuery: String = "",
    val isLoading: Boolean = true,
    val error: String? = null,
    val selectedIds: Set<Int> = emptySet()
) {
    val isSelectionMode: Boolean
        get() = selectedIds.isNotEmpty()
}

sealed interface TodoListEvent {
    data class OnSearchQueryChanged(val query: String) : TodoListEvent
    object OnClearError : TodoListEvent
}