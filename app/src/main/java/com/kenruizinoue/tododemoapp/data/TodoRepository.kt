package com.kenruizinoue.tododemoapp.data

import kotlinx.coroutines.flow.Flow

class TodoRepository(private val todoDao: TodoDao) {
    val allTodos: Flow<List<TodoItem>> = todoDao.getAllTodos()

    suspend fun insert(todo: TodoItem) {
        todoDao.insert(todo)
    }

    suspend fun delete(todo: TodoItem) {
        todoDao.delete(todo)
    }
}