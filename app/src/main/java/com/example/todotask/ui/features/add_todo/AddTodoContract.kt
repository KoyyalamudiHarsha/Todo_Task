package com.example.todotask.ui.features.add_todo

// Represents the state of the AddTodoScreen
data class AddTodoUiState(
    val isLoading: Boolean = false,
)

// Represents user interactions on the screen
sealed interface AddTodoUiEvent {
    data class OnTodoTitleChanged(val title: String) : AddTodoUiEvent
    data class OnAddTodoClicked(val title: String) : AddTodoUiEvent
}

// Represents side effects that should happen once (e.g., navigation, showing a toast)
sealed interface AddTodoEffect {
    object NavigateBack : AddTodoEffect
}