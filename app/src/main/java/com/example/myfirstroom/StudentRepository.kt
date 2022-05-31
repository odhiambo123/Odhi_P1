package com.example.myfirstroom

import android.content.Context
import androidx.lifecycle.LiveData

class StudentRepository(context: Context) {

    var db:StudentsDao? = AppDatabase.getInstance(context)?.studentDao()!!

    //fetch all students
    fun getAllStudents(): LiveData<List<Students>>?{
        return db?.selectStudents()
    }
    fun insertStudents(students: Students){
        db?.insertStudent(students)
    }
    fun updateStudents(students: Students){
        db?.updateStudent(students)
    }
    fun deleteStudents(students: Students){
        db?.deleteStudent(students)
    }
    fun searchStudents(query: String){
        db?.mySearch(query)
    }
    fun sortStudents(students: Students){
        db?.sortByName()
    }

}