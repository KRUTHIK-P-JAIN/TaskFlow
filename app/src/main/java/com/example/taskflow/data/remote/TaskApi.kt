package com.example.taskflow.data.remote

import com.example.taskflow.data.model.Task
import retrofit2.http.GET

interface TaskApi {
    @GET("7e0e6b3d-46de-4936-b209-b4dee1617119")
    suspend fun getTasks(): List<Task>
}