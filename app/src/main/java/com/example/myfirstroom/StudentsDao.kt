package com.example.myfirstroom

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
//this is the second Class we make
//data access object
interface StudentsDao {
    //helps to give the contract

    //create
    @Insert
    fun insertStudent(student: Students)

    //read
    @Query(value = "select * from students")
    fun selectStudents(): LiveData<List<Students>>

    @Query(value = "SELECT * FROM students ORDER BY firstname ASC")
    fun sortByName(): LiveData<List<Students>>

    @Query(value = "SELECT * FROM students WHERE firstname = :query OR lastname = :query")
    fun mySearch(query:String):LiveData<List<Students>>

    //updateStudent
    @Update
    fun updateStudent(student: Students)

    //delete
    @Delete
    fun deleteStudent(student: Students)



}