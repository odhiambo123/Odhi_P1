package com.example.myfirstroom

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.SearchView

class Search : AppCompatActivity() {
    lateinit var searchView: SearchView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)
        //searchView = findViewById(R.id.menu_search)

        //var myQuery: CharSequence = searchView.query

    }
}