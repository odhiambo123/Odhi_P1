package com.example.myfirstroom

import android.content.Context
import androidx.lifecycle.LiveData

class StudentRepository(context: Context) {
    var db:StudentsDao = AppDatabase.getInstance(context)?.studentDao()!!

    //fetch all students
    fun selectAllStudents(): LiveData<List<Student>>{
        return db.selectAllStudents()
    }

    fun insertStudent(student: Student){
        db.insertStudent(student)
    }

    fun sortByName(){
        db.sortByName()
    }
    fun searchStudents(query: String){
        db.mySearch(query)
    }

    fun updateStudents(student: Student){
        db.updateStudent(student)
    }
    fun deleteStudent(student: Student){
        db.deleteStudent(student)
    }

}