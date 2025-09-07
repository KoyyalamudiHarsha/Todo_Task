package com.example.todotask.domain.repo

import com.example.todotask.domain.model.Todo
import kotlinx.coroutines.flow.Flow

interface TodoRepository {
    fun getTodosStream(): Flow<List<Todo>>
    suspend fun addTodo(todo: Todo)
}