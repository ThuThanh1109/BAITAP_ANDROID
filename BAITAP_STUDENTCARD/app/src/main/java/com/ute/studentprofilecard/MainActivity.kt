package com.ute.studentprofilecard

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ute.studentprofilecard.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    // Khai báo công cụ ViewBinding để gọi giao diện
    private lateinit var binding: ActivityMainBinding

    // Tạo sẵn một bạn sinh viên mẫu
    private var currentStudent = Student(
        id = "2415053122243",
        name = "Phan Thi Thu Thanh",
        className = "24T2",
        email = "2415053122243@ute.udn.vn",
        gpa = 3.8
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Cài đặt giao diện lên màn hình
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // Điền dữ liệu ban đầu lên giao diện
        bindStudentData(currentStudent)
        // Xử lý khi bấm nút "Cập Nhật Thông Tin"
        binding.btnUpdateGpa.setOnClickListener {
            val inputStr = binding.edtNewGpa.text.toString().trim()
            val newGpa = inputStr.toDoubleOrNull()
            // Nếu nhập sai số hoặc không nằm trong khoảng 0 đến 4
            if (newGpa == null || newGpa !in 0.0..4.0) {
                binding.edtNewGpa.error = "Vui lòng nhập GPA hợp lệ (0.0 - 4.0)"
                toast("Điểm GPA không hợp lệ!")
                return@setOnClickListener
            }
            // Cập nhật lại điểm số của sinh viên
            currentStudent = currentStudent.copy(gpa = newGpa)
            // Điền lại dữ liệu mới lên giao diện
            bindStudentData(currentStudent)
            toast("Cập nhật điểm thành công!")
        }
    }
    // Hàm chuyên dùng để đổ thông tin sinh viên vào các ô trên màn hình
    private fun bindStudentData(student: Student) {
        with(binding) {
            tvName.text = student.name
            tvStudentId.text = "MSSV: ${student.id} Lớp: ${student.className}"
            tvGpaBadge.text = "${student.gpa} GPA (${student.gpa.toAcademicRanking()})"
            edtNewGpa.setText(student.gpa.toString())
        }
    }
}