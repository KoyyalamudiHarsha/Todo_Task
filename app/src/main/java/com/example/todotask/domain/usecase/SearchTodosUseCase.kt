package com.example.todotask.domain.usecase

import com.example.todotask.domain.model.Todo
import javax.inject.Inject

class SearchTodosUseCase @Inject constructor() {
    operator fun invoke(todos: List<Todo>, query: String): List<Todo> {
        if (query.isBlank()) {
            return todos
        }
        return todos.filter {
            it.title.contains(query, ignoreCase = true)
        }
    }
}