package com.example.todotask.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.todotask.ui.features.add_todo.AddTodoScreen
import com.example.todotask.ui.features.todo_list.TodoListScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screen.TodoList.route
    ) {
        composable(route = Screen.TodoList.route) {
            TodoListScreen(
                onFabClick = {
                    navController.navigate(Screen.AddTodo.route)
                }
            )
        }
        composable(route = Screen.AddTodo.route) {
            AddTodoScreen(
                onNavigateBack = {
                    navController.popBackStack()
                }
            )
        }
    }
}