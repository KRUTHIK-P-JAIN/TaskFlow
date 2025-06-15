package com.example.taskflow.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.taskflow.data.model.Task

@Dao
interface TaskDao {
    @Query("SELECT * FROM task")
    suspend fun getTasks(): List<Task>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(tasks: List<Task>)

    @Query("DELETE FROM task")
    suspend fun clearTasks()
}