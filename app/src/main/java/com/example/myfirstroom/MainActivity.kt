package com.example.myfirstroom

import android.app.SearchManager
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.Menu
import android.widget.Button
import android.widget.ProgressBar
import android.widget.SearchView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.progressindicator.CircularProgressIndicator

open class MainActivity : AppCompatActivity() {
    var studentList = ArrayList<Student>()

    //vm object
    lateinit var vm: MainViewModel

    lateinit var adapter: StudentAdapter

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        vm = MainViewModel(application)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        //create an adapter with data source
        adapter = StudentAdapter({ position -> onCardClick(position) }, studentList)

        //take the views we adapter and then assing it to the custom adapter we created
        recyclerView.adapter = adapter
        val sortbtn: Button = findViewById(R.id.sort_btn)
        val searchbtn : Button = findViewById(R.id.search_btn)
        val plus: FloatingActionButton = findViewById(R.id.plus_btn)
        val progressBar : ProgressBar =  findViewById(R.id.progress_circular)

        plus.setOnClickListener()
        {
            val myIntent1 = Intent(this, NewStudent::class.java)

            startActivity(myIntent1)
        }

        sortbtn.setOnClickListener(){
            vm.sortByName()

        }
        searchbtn.setOnClickListener(){
            val myIntent = Intent(this, Search::class.java)
            startActivity(myIntent)
        }

        vm.allStudents?.observe(this) { studentList ->
            getStudents(studentList)
        }

    }

    fun onCardClick(position: Int) {
        //delay(10000L)
        println("position:::$position")
        val myIntent = Intent(this, EditEntity::class.java)
        myIntent.putExtra("Id", studentList[position].studentId)
        myIntent.putExtra("Fname", studentList[position].firstName)
        myIntent.putExtra("Lname", studentList[position].lastName)
        startActivity(myIntent)
    }

    fun getStudents(studentList: List<Student>) {
        this.studentList.clear()
        this.studentList.addAll(studentList)
        adapter.notifyDataSetChanged()
    }

    fun mySearch(query: String?) {

    }

}

