package com.example.myfirstroom

import android.app.Application
import androidx.lifecycle.*
import androidx.lifecycle.LiveData
import kotlinx.coroutines.launch

class MainViewModel(app: Application):AndroidViewModel(app) {

    private val repo: StudentRepository
    val allStudents : LiveData<List<Student>>?
    init {
        repo = StudentRepository(app)
        allStudents = repo.selectAllStudents()
    }
    //set of functions

    //fetch all students
    fun getAllStudents() = viewModelScope.launch{
        repo.selectAllStudents()
    }
    fun insertStudents(student: Student) = viewModelScope.launch{
        repo.insertStudent(student)

    }
    fun updateStudents(student: Student) = viewModelScope.launch{
        repo.updateStudents(student)
    }
    fun deleteStudents(student: Student) = viewModelScope.launch{
        repo.deleteStudent(student)
    }
    fun searchStudents(query: String) = viewModelScope.launch {
        repo.searchStudents(query)
    }
    fun sortByName() = viewModelScope.launch {
        repo.sortByName()
    }
}