package com.example.myfirstroom

import android.app.Application
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.*
import androidx.lifecycle.LiveData
import androidx.room.Query
import kotlinx.coroutines.launch

class MainViewModel(app: Application):AndroidViewModel(app) {

    private val repo: StudentRepository
    val allStudents : LiveData<List<Students>>?
    init {
        repo = StudentRepository(app)
        allStudents = repo.getAllStudents()
    }
    //set of functions

    //fetch all students
    fun getAllStudents() = viewModelScope.launch{
        repo.getAllStudents()
    }
    fun insertStudents(students: Students) = viewModelScope.launch{
        repo.insertStudents(students)

    }
    fun updateStudents(students: Students) = viewModelScope.launch{
        repo.updateStudents(students)
    }
    fun deleteStudents(students: Students) = viewModelScope.launch{
        repo.deleteStudents(students)
    }
    fun searchStudents(query: String) = viewModelScope.launch {
        repo.searchStudents(query)
    }
    fun sortStudents() = viewModelScope.launch {
        repo.sortStudents()
    }
}