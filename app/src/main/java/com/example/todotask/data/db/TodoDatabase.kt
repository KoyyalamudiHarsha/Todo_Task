package com.example.todotask.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.db.dao.TodoDao
import com.example.todotask.data.db.entity.TodoEntity

@Database(
    entities = [TodoEntity::class],
    version = 1,
    exportSchema = false
)
abstract class TodoDatabase : RoomDatabase() {

    abstract fun todoDao(): TodoDao
}