package com.example.myfirstroom

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class EditEntity : AppCompatActivity() {
    lateinit var vm :MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_entity)

        vm = MainViewModel(application)
        val id: TextView = findViewById(R.id.stud_id)
        val fname: EditText = findViewById(R.id.fname)
        val lname: EditText = findViewById(R.id.lname)

        val fromMain = Intent(this, ProgressPage::class.java)
        //val goBack = Intent(this, MainActivity::class.java)
        val updateStudent: Button = findViewById(R.id.btn_update)
        val deleteStudent: Button = findViewById(R.id.btn_delete)
        val cancelExit: Button = findViewById(R.id.btn_cancel)

        id.text = intent.getIntExtra("Id",0).toString()
        fname.setText(intent.getStringExtra("Fname"))
        lname.setText(intent.getStringExtra("Lname"))

        updateStudent.setOnClickListener{
            vm.updateStudents(Students(id.text.toString().toInt(), fname.text.toString(), lname.text.toString()))

            startActivity(fromMain)
        }


        cancelExit.setOnClickListener {
            startActivity(fromMain)
        }


        deleteStudent.setOnClickListener {
            vm.deleteStudents(Students(id.text.toString().toInt(), fname.text.toString(), lname.text.toString()))
            //startActivity(goBack)

            startActivity(fromMain)

        }
    }
}