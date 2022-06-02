package com.example.myfirstroom

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
//this is the second Class we make
//data access object
interface StudentsDao {
    //helps to give the contract
    //read
    @Query("select * from students")
    fun selectAllStudents(): LiveData<List<Student>>
    //create
    @Insert
    fun insertStudent(student: Student)

    @Query(value = "SELECT * FROM students ORDER BY lastname ASC")
    fun sortByName(): LiveData<List<Student>>

    @Query("SELECT * FROM students WHERE firstname like :query OR lastname like :query")
    fun mySearch(query:String): LiveData<List<Student>>
    //updateStudent
    @Update
    fun updateStudent(student: Student)
    //delete
    @Delete
    fun deleteStudent(student: Student)

}