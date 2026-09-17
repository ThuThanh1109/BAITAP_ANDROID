package com.ute.studentprofilecard

data class Student(
    val id: String,
    val name: String,
    val className: String,
    val email: String,
    val gpa: Double = 0.0
)