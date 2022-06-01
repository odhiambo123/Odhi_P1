package com.example.myfirstroom

import android.app.SearchManager
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.widget.Button
import android.widget.ProgressBar
import android.widget.SearchView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.NestedScrollView
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import java.lang.Thread.sleep

open class MainActivity : AppCompatActivity() {
    var studentList = ArrayList<Students>()
    //viewModel Object
    lateinit var vm : MainViewModel
    //Adapter
    lateinit var adapter: StudentAdapter
    //Nested Scroll view
    lateinit var nestedScrollView: NestedScrollView
    //PROGRESSBAR
    lateinit var progressBar: ProgressBar


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        nestedScrollView = findViewById(R.id.nestedscrollview)
        progressBar = findViewById(R.id.progress_circular)

        vm  = MainViewModel(application)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)



        //create an adapter with data source
        adapter = StudentAdapter({position -> onCardClick(position) }, studentList)

        //take the views we adapter and then assing it to the custom adapter we created
        recyclerView.adapter = adapter
    val sortbtn : Button = findViewById(R.id.sort_btn)
    //val searchbtn : FloatingActionButton = findViewById(R.id.search_btn)
    val plus: FloatingActionButton = findViewById(R.id.plus_btn)
        
    sortbtn.setOnClickListener(){
        vm.sortStudents()

    }

    plus.setOnClickListener()
        {
            val myIntent1 = Intent(this, NewStudent::class.java)

            startActivity(myIntent1)
        }

        vm.allStudents?.observe(this, { studentList ->
            getStudents(studentList)
        })

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

    fun getStudents(studentList: List<Students>){
        this.studentList.clear()
        this.studentList.addAll(studentList)
        adapter.notifyDataSetChanged()
    }
    fun mySearch(query: String?) {

    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.options_menu, menu)

        // Associate searchable configuration with the SearchView
        val searchManager = getSystemService(Context.SEARCH_SERVICE) as SearchManager
        (menu.findItem(R.id.search).actionView as SearchView).apply {
            setSearchableInfo(searchManager.getSearchableInfo(componentName))

        }

        return true
    }
}

