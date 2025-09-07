package com.example.todotask.data.repo

import com.example.db.dao.TodoDao
import com.example.todotask.data.mapper.toDomain
import com.example.todotask.data.mapper.toEntity
import com.example.todotask.domain.model.Todo
import com.example.todotask.domain.repo.TodoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class TodoRepositoryImpl @Inject constructor(
    private val todoDao: TodoDao
) : TodoRepository {

    override fun getTodosStream(): Flow<List<Todo>> {
        return todoDao.getTodosStream().map { entities ->
            entities.map { it.toDomain() }
        }
    }

    override suspend fun addTodo(todo: Todo) {
        todoDao.insertTodo(todo.toEntity())
    }

}