package com.example.myfirstroom

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class NewStudent : AppCompatActivity() {

    var student: Students? = null

    lateinit var vm : MainViewModel

    lateinit var myStudId :TextView
    lateinit var nsFirstName : TextView
    lateinit var nsLastName : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_student)

        vm = MainViewModel(application)
        myStudId = findViewById(R.id.stud_id)
        nsFirstName= findViewById(R.id.enter_fname)
        nsLastName= findViewById(R.id.enter_lname)
        val goBack = Intent(this, ProgressPage::class.java)

        val saveStudent: Button = findViewById(R.id.btn_save)
        saveStudent.setOnClickListener(){
            val newStu = Students(myStudId.text.toString().toInt(), nsFirstName.text.toString(),nsLastName.text.toString())

            if (myStudId.text.isNotEmpty() && nsFirstName.text.isNotEmpty() && nsLastName.text.isNotEmpty()) {

                Toast.makeText(this, "success", Toast.LENGTH_LONG).show()
                vm.insertStudents(newStu)
            }else {
                Toast.makeText(this, "Not Saving Empty input", Toast.LENGTH_LONG).show()
            }
           startActivity(goBack)
        }
        val cancelAtivity: Button = findViewById(R.id.btn_cancel)

        cancelAtivity.setOnClickListener(){
            startActivity(goBack)
        }
    }
}