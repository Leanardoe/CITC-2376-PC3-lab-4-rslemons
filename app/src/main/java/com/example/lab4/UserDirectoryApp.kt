package com.example.lab4

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.lab4.ui.UserListScreen
import com.example.lab4.ui.UserViewModel

@Composable
fun UserDirectoryApp() {
    val viewModel: UserViewModel = viewModel()
    UserListScreen(viewModel = viewModel)
}
