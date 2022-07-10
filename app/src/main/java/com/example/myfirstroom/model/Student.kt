package com.example.myfirstroom.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

//This is the first file We make
//ROOM will automatically generate tables for the entity
@Entity(tableName = "students")
data class Student(@PrimaryKey
                    var studentId: Int?,
                   @ColumnInfo(name = "firstname")
                    val firstName:String,
                   @ColumnInfo(name = "lastname")
                    var lastName:String
                    )

