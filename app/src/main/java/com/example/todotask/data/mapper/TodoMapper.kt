package com.example.todotask.data.mapper

import com.example.todotask.data.db.entity.TodoEntity
import com.example.todotask.domain.model.Todo

/**
 * Converts a database TodoEntity object into a domain Todo object.
 */
fun TodoEntity.toDomain(): Todo {
    return Todo(
        id = this.id,
        title = this.title,
        timestamp = this.timestamp
    )
}

/**
 * Converts a domain Todo object into a database TodoEntity object for saving.
 */
fun Todo.toEntity(): TodoEntity {
    return TodoEntity(
        id = this.id,
        title = this.title,
        timestamp = this.timestamp
    )
}