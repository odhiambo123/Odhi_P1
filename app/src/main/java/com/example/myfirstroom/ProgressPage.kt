package com.example.myfirstroom

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import kotlinx.coroutines.delay
import java.lang.Thread.sleep
import java.sql.Time
import java.sql.Timestamp
import kotlin.concurrent.timer
import kotlin.concurrent.timerTask
import kotlin.system.measureTimeMillis

class ProgressPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_progress_page)

sharewithMain()

    }
    fun sharewithMain(){

        val myIntent1 = Intent(this, MainActivity::class.java)
        //val meWaiting = Intent(this, ProgressPage::class.java)
        val timer = object: CountDownTimer(3000, 1000) {
            override fun onTick(millisUntilFinished: Long) {}

            override fun onFinish() {startActivity(myIntent1)}
        }
        timer.start()
        }
}