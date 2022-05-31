package com.example.myfirstroom

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

//This is the first file We make
//ROOM will automatically generate tables for the entity
@Entity(tableName = "students")
data class Students(@PrimaryKey
                    var studentId: Int?,
                    @ColumnInfo(name = "firstname")
                    val firstName:String,
                    @ColumnInfo(name = "lastname")
                    var lastName:String
                    )

