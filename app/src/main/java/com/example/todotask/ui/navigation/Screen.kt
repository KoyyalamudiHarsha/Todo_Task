package com.example.todotask.ui.navigation

sealed class Screen(val route: String) {
    object TodoList : Screen("todo_list_screen")
    object AddTodo : Screen("add_todo_screen")
}