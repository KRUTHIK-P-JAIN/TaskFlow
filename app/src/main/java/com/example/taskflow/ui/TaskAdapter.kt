package com.example.taskflow.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.taskflow.data.model.Task
import com.example.taskflow.databinding.ItemTaskBinding

class TaskAdapter : ListAdapter<Task, TaskAdapter.TaskViewHolder>(DiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskAdapter.TaskViewHolder {
        val binding = ItemTaskBinding.inflate(LayoutInflater.from(parent.context))
        return TaskViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TaskAdapter.TaskViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class TaskViewHolder(private val binding: ItemTaskBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(task: Task) {
            binding.taskTv.text = task.title
        }
    }

    class DiffCallback: DiffUtil.ItemCallback<Task>() {
        override fun areItemsTheSame(oldItem: Task, newItem: Task): Boolean = oldItem == newItem

        override fun areContentsTheSame(oldItem: Task, newItem: Task): Boolean = oldItem == newItem
    }
}