package com.example.lab4.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lab4.Data.User
import kotlinx.coroutines.launch
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

sealed class UserUiState {
    object Loading : UserUiState()
    data class Success(val users: List<User>) : UserUiState()
    data class Error(val message: String) : UserUiState()
}

class UserViewModel : ViewModel() {
    var uiState by mutableStateOf<UserUiState>(UserUiState.Loading)
        private set

    init {
        fetchUsers()
    }

    private fun fetchUsers() {
        viewModelScope.launch {
            try {
                val response = com.example.lab4.Data.RetrofitInstance.api.getUsers()
                uiState = UserUiState.Success(response.results)
            } catch (e: Exception) {
                uiState = UserUiState.Error("Failed to load users: ${e.message}")
            }
        }
    }
}