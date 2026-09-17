package com.ute.studentprofilecard

import android.content.Context
import android.widget.Toast

// Hàm xếp loại học lực dựa trên điểm số
fun Double.toAcademicRanking(): String = when {
    this >= 3.6 -> "Xuất sắc!!"
    this >= 3.2 -> "Giỏi"
    this >= 2.5 -> "Khá"
    else -> "Trung bình"
}

// Hàm hiện thông báo ngắn gọn cho dễ gọi
fun Context.toast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}