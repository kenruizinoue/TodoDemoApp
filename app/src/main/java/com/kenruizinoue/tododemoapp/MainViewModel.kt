package com.kenruizinoue.tododemoapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kenruizinoue.tododemoapp.data.TodoItem
import com.kenruizinoue.tododemoapp.data.TodoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: TodoRepository,
    private val ioDispatcher: CoroutineDispatcher
) : ViewModel() {

    val todos = repository.allTodos

    fun addTodo(todo: String) =
        viewModelScope.launch(ioDispatcher) { repository.insert(TodoItem(title = todo)) }

    fun toggleTodo(todoItem: TodoItem) =
        viewModelScope.launch(ioDispatcher) { repository.insert(todoItem.copy(isDone = !todoItem.isDone)) }

    fun removeTodo(todoItem: TodoItem) =
        viewModelScope.launch(ioDispatcher) { repository.delete(todoItem) }
}