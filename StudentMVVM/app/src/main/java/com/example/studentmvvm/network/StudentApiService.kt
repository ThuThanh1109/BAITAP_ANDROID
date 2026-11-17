package com.example.studentmvvm.network

import com.google.gson.annotations.SerializedName
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

// Mô hình Retrofit THAM KHẢO theo trang 12 của PDF.
// Không chạy mạng mặc định vì tài liệu chỉ cung cấp base URL ví dụ.
data class StudentDto(
    @SerializedName("id") val remoteId: String,
    @SerializedName("full_name") val fullName: String,
    @SerializedName("student_code") val studentCode: String,
    @SerializedName("email") val email: String,
    @SerializedName("gpa") val gpa: Double
)

interface StudentApiService {
    @GET("api/v1/students")
    suspend fun getStudents(): List<StudentDto>

    @POST("api/v1/students")
    suspend fun createStudent(@Body studentDto: StudentDto): StudentDto
}
