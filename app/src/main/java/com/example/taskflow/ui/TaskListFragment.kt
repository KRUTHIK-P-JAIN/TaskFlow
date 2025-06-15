package com.example.taskflow.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.taskflow.R
import com.example.taskflow.databinding.FragmentTaskListBinding
import com.example.taskflow.viewmodel.TaskViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TaskListFragment : Fragment(R.layout.fragment_task_list) {
    private var _binding: FragmentTaskListBinding? = null
    private val binding get() = _binding!!

    private val viewModel: TaskViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        _binding = FragmentTaskListBinding.bind(view)

        val adapter = TaskAdapter()
        binding.tasksRv.adapter = adapter

        binding.fabAddTask.setOnClickListener {
            AddTaskDialog().show(parentFragmentManager, "AddTaskDialog")
        }

        viewModel.tasks.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}