package com.kenruizinoue.tododemoapp

import androidx.compose.ui.test.assertContentDescriptionEquals
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsNotDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onAllNodesWithTag
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import androidx.test.core.app.ActivityScenario
import com.kenruizinoue.tododemoapp.ui.constants.TODO_INPUT_BAR_ADD_TODO_FAB_TEST_TAG
import com.kenruizinoue.tododemoapp.ui.constants.TODO_INPUT_BAR_INPUT_FIELD_TEST_TAG
import com.kenruizinoue.tododemoapp.ui.constants.TODO_ITEM_UI_CONTAINER_CHECKED_CONTENT_DESCRIPTION
import com.kenruizinoue.tododemoapp.ui.constants.TODO_ITEM_UI_CONTAINER_TEST_TAG
import com.kenruizinoue.tododemoapp.ui.constants.TODO_ITEM_UI_CONTAINER_UNCHECKED_CONTENT_DESCRIPTION
import com.kenruizinoue.tododemoapp.ui.constants.TODO_ITEM_UI_DELETE_BUTTON_TEST_TAG
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Rule
import org.junit.Test

@HiltAndroidTest
class MainActivityTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @Test
    fun shouldDisplayAddedTodoItem() {
        val todoText = "Walk the dog on the moon"
        ActivityScenario.launch(MainActivity::class.java).use {
            addTodoItem(todoText)
            composeTestRule.onNodeWithText(todoText).assertIsDisplayed()
        }
    }

    @Test
    fun shouldToggleTodoItemState() {
        val todoText = "Teach the cat quantum physics"
        val todoItem1Position = 0
        ActivityScenario.launch(MainActivity::class.java).use {
            addTodoItem(todoText)
            toggleTodoItemState(todoItem1Position)
            composeTestRule
                .onNodeWithTag(TODO_ITEM_UI_CONTAINER_TEST_TAG)
                .assertContentDescriptionEquals(TODO_ITEM_UI_CONTAINER_CHECKED_CONTENT_DESCRIPTION)
        }
    }

    @Test
    fun shouldRemoveTodoItemWhenDeleted() {
        val todoText = "Convince a kangaroo to do yoga"
        val todoItem1Position = 0
        ActivityScenario.launch(MainActivity::class.java).use {
            addTodoItem(todoText)
            deleteTodoItem(todoItem1Position)
            composeTestRule.onNodeWithText(todoText).assertIsNotDisplayed()
        }
    }

    @Test
    fun shouldDisplayAllAddedTodoItems() {
        val todoText1 = "Walk the dog on the moon"
        val todoText2 = "Teach the cat quantum physics"
        val todoText3 = "Convince a kangaroo to do yoga"
        ActivityScenario.launch(MainActivity::class.java).use {
            addTodoItem(todoText1)
            addTodoItem(todoText2)
            addTodoItem(todoText3)
            composeTestRule.onNodeWithText(todoText1).assertIsDisplayed()
            composeTestRule.onNodeWithText(todoText2).assertIsDisplayed()
            composeTestRule.onNodeWithText(todoText3).assertIsDisplayed()
        }
    }

    @Test
    fun shouldDisplayRemainingTodoItemsAfterOneIsDeleted() {
        val todoText1 = "Walk the dog on the moon"
        val todoText2 = "Teach the cat quantum physics"
        val todoText3 = "Convince a kangaroo to do yoga"
        val todoItem2Position = 1
        ActivityScenario.launch(MainActivity::class.java).use {
            addTodoItem(todoText1)
            addTodoItem(todoText2)
            addTodoItem(todoText3)
            deleteTodoItem(todoItem2Position)
            composeTestRule.onNodeWithText(todoText1).assertIsDisplayed()
            composeTestRule.onNodeWithText(todoText3).assertIsDisplayed()
            composeTestRule.onNodeWithText(todoText2).assertIsNotDisplayed()
        }
    }

    @Test
    fun shouldToggleStateOfSpecificTodoItem() {
        val todoText1 = "Walk the dog on the moon"
        val todoText2 = "Teach the cat quantum physics"
        val todoText3 = "Convince a kangaroo to do yoga"
        val todoItem3Position = 2
        ActivityScenario.launch(MainActivity::class.java).use {
            addTodoItem(todoText1)
            addTodoItem(todoText2)
            addTodoItem(todoText3)
            toggleTodoItemState(todoItem3Position)
            composeTestRule
                .onAllNodesWithTag(TODO_ITEM_UI_CONTAINER_TEST_TAG)[0]
                .assertContentDescriptionEquals(TODO_ITEM_UI_CONTAINER_UNCHECKED_CONTENT_DESCRIPTION)
            composeTestRule
                .onAllNodesWithTag(TODO_ITEM_UI_CONTAINER_TEST_TAG)[1]
                .assertContentDescriptionEquals(TODO_ITEM_UI_CONTAINER_UNCHECKED_CONTENT_DESCRIPTION)
            composeTestRule
                .onAllNodesWithTag(TODO_ITEM_UI_CONTAINER_TEST_TAG)[2]
                .assertContentDescriptionEquals(TODO_ITEM_UI_CONTAINER_CHECKED_CONTENT_DESCRIPTION)
        }
    }

    private fun addTodoItem(todoText: String) {
        composeTestRule.onNodeWithTag(TODO_INPUT_BAR_INPUT_FIELD_TEST_TAG).performTextInput(todoText)
        composeTestRule.onNodeWithTag(TODO_INPUT_BAR_ADD_TODO_FAB_TEST_TAG).performClick()
    }

    private fun toggleTodoItemState(index: Int) {
        composeTestRule.onAllNodesWithTag(TODO_ITEM_UI_CONTAINER_TEST_TAG)[index].performClick()
    }

    private fun deleteTodoItem(index: Int) {
        composeTestRule.onAllNodesWithTag(TODO_ITEM_UI_DELETE_BUTTON_TEST_TAG)[index].performClick()
    }
}