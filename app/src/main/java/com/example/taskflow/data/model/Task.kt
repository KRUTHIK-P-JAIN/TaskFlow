package com.example.taskflow.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "task")
data class Task(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val title: String
)