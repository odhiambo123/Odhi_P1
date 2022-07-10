package com.example.myfirstroom.persistence

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.myfirstroom.model.Student

//6 points here
// 1 holder calss. ANNOTATION
// 2 ENTITIES
// 3. abstract and extend room database
// 4 container function that returns Dao  ABSTRACT AND RETURN DAO
// 5 SINGLETON
// 6 in-memory database builder: it acquires an instance of the room database
// singleton: need to be created only once .

//1 ANNOTATION  //2 ENTITIES
@Database(entities = [Student::class], version = 1, exportSchema = false)
//3  ABSTRACT AND EXTEND
abstract class AppDatabase : RoomDatabase(){
    //4 ABSTRACT AND RETURN DAO
    abstract fun studentDao(): StudentsDao
    //5 SINGLETON
    companion object {
        var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase? {
            if (INSTANCE == null){
                //6 acquire an instance of RoomDB BUILDER
                synchronized(AppDatabase::class){
                    INSTANCE = Room.databaseBuilder(context.applicationContext, AppDatabase::class.java,
                        "students.db").fallbackToDestructiveMigration().allowMainThreadQueries().build()
                }
            }
            return INSTANCE

        }

        fun destroyInstance(){
            INSTANCE = null
        }


    }

}
//AppDatabase.getInstance()