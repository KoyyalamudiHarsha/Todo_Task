package com.example.todotask.domain.usecase

import com.example.todotask.domain.model.Todo
import com.example.todotask.domain.repo.TodoRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetTodosUseCase @Inject constructor(
    private val repository: TodoRepository
) {
    operator fun invoke(): Flow<List<Todo>> {
        return repository.getTodosStream()
    }
}