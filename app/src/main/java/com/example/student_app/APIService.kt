package com.example.student_app

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FieldMap
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST

interface APIService {
    @FormUrlEncoded
    @POST("addStudent.php") // Replace with your actual PHP file name
    fun addStudent(@Body student: Student): Call<Void> // Change the return type based on your response type
    /* @FormUrlEncoded
    @POST("addStudent.php") // Replace with your actual PHP file name
    fun insertData(
        @Field("first_name") firstName: String,
        @Field("last_name") lastName: String,
        @Field("date_of_birth") dateOfBirth: String,
        @Field("email") email: String,
        @Field("phone_number") phoneNumber: String
    ): Call<Array<String>> */
}