package com.example.myfirstroom.ui.details

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.myfirstroom.ui.main.ProgressPage
import com.example.myfirstroom.R
import com.example.myfirstroom.model.Student
import com.example.myfirstroom.ui.main.MainViewModel

class NewStudent : AppCompatActivity() {

    var student: Student? = null

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
        saveStudent.setOnClickListener() {
            if (myStudId.text.isEmpty()){
                myStudId.setError("Please Enter Id")
            }
            else if (nsFirstName.text.isEmpty()) {
                nsFirstName.setError("please enter the firstname");
            } else if (nsLastName.text.isEmpty()) {
                nsLastName.setError("please enter the lastname");
            } else {
                val newStu = Student(myStudId.text.toString().toInt(),
                    nsFirstName.text.toString(),
                    nsLastName.text.toString())

                vm.insertStudents(newStu)
                Toast.makeText(this, "success", Toast.LENGTH_LONG).show()
            }

        }
        val cancelAtivity: Button = findViewById(R.id.btn_cancel)

        cancelAtivity.setOnClickListener(){
            startActivity(goBack)
        }
    }
}