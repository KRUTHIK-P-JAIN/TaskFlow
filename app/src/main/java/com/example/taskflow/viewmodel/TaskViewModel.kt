package com.example.taskflow.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.taskflow.data.model.Task
import com.example.taskflow.data.repository.TaskRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TaskViewModel @Inject constructor(
    private val repository: TaskRepository
): ViewModel() {

    private val _tasks = MutableLiveData<List<Task>>()
    val tasks: LiveData<List<Task>> = _tasks

    init {
        loadTasks()
    }

    private fun loadTasks() {
        viewModelScope.launch {
            _tasks.value = repository.getTasks()
        }
    }

    fun addTask(title: String) {
        viewModelScope.launch {
            repository.addTask(title)
            loadTasks()
        }
    }
}