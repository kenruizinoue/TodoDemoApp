package com.kenruizinoue.tododemoapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.kenruizinoue.tododemoapp.composables.TodoInputBar
import com.kenruizinoue.tododemoapp.composables.TodoItemsContainer
import com.kenruizinoue.tododemoapp.ui.constants.OverlappingHeight
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val mainViewModel: MainViewModel by viewModels()
        setContent {
            Box(
                modifier = Modifier.fillMaxSize()
            ) {
                TodoItemsContainer(
                    todoItemsFlow = mainViewModel.todos,
                    onItemClick = mainViewModel::toggleTodo,
                    onItemDelete = mainViewModel::removeTodo,
                    overlappingElementsHeight = OverlappingHeight
                )
                TodoInputBar(
                    modifier = Modifier.align(Alignment.BottomStart),
                    onAddButtonClick = mainViewModel::addTodo
                )
            }
        }
    }
}