package com.example.taskflow.ui

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.activityViewModels
import com.example.taskflow.R
import com.example.taskflow.databinding.AddTaskDialogBinding
import com.example.taskflow.viewmodel.TaskViewModel
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddTaskDialog : DialogFragment() {

    // Use shared ViewModel from activity
    private val viewModel: TaskViewModel by activityViewModels()
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val binding = AddTaskDialogBinding.inflate(layoutInflater)

        val dialog = MaterialAlertDialogBuilder(requireContext())
            .setTitle(getString(R.string.add_task_title))
            .setView(binding.root)
            .setPositiveButton("Add", null)
            .setNegativeButton("Cancel", null)
            .create()

        dialog.setOnShowListener {
            val addButton = dialog.getButton(AlertDialog.BUTTON_POSITIVE)
            addButton.setOnClickListener {
                val input = binding.editTextTask.text.toString().trim()

                if (input.isEmpty()){
                    binding.editTextTask.error = "Please enter a task"
                } else {
                    viewModel.addTask(input)
                    dismiss()
                }
            }
        }

        return dialog
    }
}