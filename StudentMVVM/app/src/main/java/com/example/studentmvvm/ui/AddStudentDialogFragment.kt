package com.example.studentmvvm.ui

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.activityViewModels
import com.example.studentmvvm.databinding.DialogAddStudentBinding
import com.example.studentmvvm.model.Student
import com.example.studentmvvm.viewmodel.StudentViewModel

class AddStudentDialogFragment : DialogFragment() {
    private val viewModel: StudentViewModel by activityViewModels {
        (requireActivity() as MainActivity).studentViewModelFactory
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val binding = DialogAddStudentBinding.inflate(LayoutInflater.from(requireContext()))
        val dialog = AlertDialog.Builder(requireContext())
            .setTitle("Thêm sinh viên mới")
            .setView(binding.root)
            .setPositiveButton("Lưu", null)
            .setNegativeButton("Hủy", null)
            .create()

        dialog.setOnShowListener {
            dialog.getButton(AlertDialog.BUTTON_POSITIVE).setOnClickListener {
                val name = binding.etName.text.toString().trim()
                val code = binding.etCode.text.toString().trim()
                val email = binding.etEmail.text.toString().trim()
                val gpa = binding.etGpa.text.toString().trim().toDoubleOrNull()
                when {
                    name.isBlank() || code.isBlank() || email.isBlank() || gpa == null ->
                        Toast.makeText(requireContext(), "Nhập đủ họ tên, MSSV, email và GPA", Toast.LENGTH_SHORT).show()
                    !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches() ->
                        binding.etEmail.error = "Email không hợp lệ"
                    gpa !in 0.0..4.0 -> binding.etGpa.error = "GPA phải từ 0 đến 4"
                    else -> {
                        viewModel.insert(Student(fullName = name, studentCode = code, email = email, gpa = gpa))
                        dialog.dismiss()
                    }
                }
            }
        }
        return dialog
    }
}
