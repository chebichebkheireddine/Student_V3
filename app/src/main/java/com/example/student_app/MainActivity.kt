package com.example.student_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    private lateinit var editTextFirstName: EditText
    private lateinit var editTextLastName: EditText
    private lateinit var editTextDOB: EditText
    private lateinit var editTextEmail: EditText
    private lateinit var editTextPhoneNumber: EditText
    private lateinit var buttonSave: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        editTextFirstName = findViewById(R.id.editTextFirstName)
        editTextLastName = findViewById(R.id.editTextLastName)
        editTextDOB = findViewById(R.id.editTextDOB)
        editTextEmail = findViewById(R.id.editTextEmail)
        editTextPhoneNumber = findViewById(R.id.editTextPhoneNumber)
        buttonSave = findViewById(R.id.button)
        buttonSave.setOnClickListener {
            saveStudentInfo()
        }
    }
    private fun saveStudentInfo() {
        val retrofit = Retrofit.Builder()
            .baseUrl(APIUrl.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(APIService::class.java)
        val firstName = editTextFirstName.text.toString()
        val lastName = editTextLastName.text.toString()
        val dob = editTextDOB.text.toString()
        val email = editTextEmail.text.toString()
        val phoneNumber = editTextPhoneNumber.text.toString()

        val student = Student(
            firstName = firstName,
            lastName = lastName,
            dateOfBirth = dob,
            email = email,
            phoneNumber = phoneNumber
        )

        val call = service.addStudent(student)

        call.enqueue(object : Callback<Void> {
            override fun onResponse(call: Call<Void>, response: Response<Void>) {
                if (response.isSuccessful) {
                    // Handle successful response here
                } else {
                    // Handle unsuccessful response here
                }
            }

            override fun onFailure(call: Call<Void>, t: Throwable) {
                // Handle failure here
            }
        })
    }

    /*private fun saveStudentInfo() {
        val firstName = editTextFirstName.text.toString()
        val lastName = editTextLastName.text.toString()
        val dob = editTextDOB.text.toString()
        val email = editTextEmail.text.toString()
        val phoneNumber = editTextPhoneNumber.text.toString()

        // Create a Retrofit instance
        val retrofit = Retrofit.Builder()
            .baseUrl(APIUrl.BASE_URL) // BASE_URL is the base URL of your API
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        // Create an instance of the APIService interface
        val apiService = retrofit.create(APIService::class.java)

        // Make the API call to add a student
        val call = apiService.insertData(firstName, lastName, dob, email, phoneNumber)

        call.enqueue(object : Callback<Array<String>> {
            override fun onResponse(call: Call<Array<String>>, response: Response<Array<String>>) {
                if (response.isSuccessful) {
                    val resultArray = response.body()
                    if (resultArray != null && resultArray.isNotEmpty()) {
                        val result = resultArray[0]
                        // Handle successful response here using 'result'
                    } else {
                        // Empty or null response array
                    }
                } else {
                    // Handle unsuccessful response here
                }
            }


            override fun onFailure(call: Call<Array<String>>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }*/

}