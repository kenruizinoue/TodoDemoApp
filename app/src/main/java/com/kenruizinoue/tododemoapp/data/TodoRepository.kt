package com.kenruizinoue.tododemoapp.data

import kotlinx.coroutines.flow.Flow

// 1. Repository Initialization
class TodoRepository(private val todoDao: TodoDao) {
    // 2. Data Retrieval
    val allTodos: Flow<List<TodoItem>> = todoDao.getAllTodos()

    // 3. Data Modification Methods
    suspend fun insert(todo: TodoItem) {
        todoDao.insert(todo)
    }

    suspend fun delete(todo: TodoItem) {
        todoDao.delete(todo)
    }
}