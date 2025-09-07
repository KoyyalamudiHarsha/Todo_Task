package com.example.todotask.domain.usecase

import com.example.todotask.domain.model.Todo
import com.example.todotask.domain.repo.TodoRepository
import javax.inject.Inject

class AddTodoUseCase @Inject constructor(
    private val todoRepository: TodoRepository
) {
    suspend operator fun invoke(title: String) {
        if (title.equals("Error", ignoreCase = true)) {
            throw IllegalStateException("Cannot add a todo with title 'Error'.")
        }
        val newTodo = Todo(title = title, timestamp = System.currentTimeMillis())
        todoRepository.addTodo(newTodo)
    }
}