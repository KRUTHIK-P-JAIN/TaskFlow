package com.example.taskflow.data.repository

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import com.example.taskflow.data.local.TaskDao
import com.example.taskflow.data.model.Task
import com.example.taskflow.data.remote.TaskApi
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class TaskRepository @Inject constructor(
    private val taskApi: TaskApi,
    private val taskDao: TaskDao,
    @ApplicationContext private val context: Context
) {
    suspend fun getTasks(): List<Task> {
        return if(isOnline()) {
            val remoteTasks = taskApi.getTasks()
            taskDao.clearTasks()
            taskDao.insertAll(remoteTasks)
            remoteTasks
        } else {
            taskDao.getTasks()
        }
    }

    suspend fun addTask(title: String) {
        val newTask = Task(title = title)
        taskDao.insertAll(listOf(newTask))
    }

    private fun isOnline(): Boolean {
        val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val network = cm.activeNetwork ?: return false
        val capabilities = cm.getNetworkCapabilities(network) ?: return false
        return capabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
    }
}