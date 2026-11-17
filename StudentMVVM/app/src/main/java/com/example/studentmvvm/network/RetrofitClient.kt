package com.example.studentmvvm.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    // URL trong bài giảng chỉ là ví dụ, cần thay bằng backend thực tế nếu muốn dùng.
    private const val BASE_URL = "https://api.example.com/"

    val apiService: StudentApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(StudentApiService::class.java)
    }
}
