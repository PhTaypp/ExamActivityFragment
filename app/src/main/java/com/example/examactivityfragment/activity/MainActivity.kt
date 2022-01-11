package com.example.examactivityfragment.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.AppCompatButton
import com.example.examactivityfragment.R

class MainActivity : AppCompatActivity(){
    lateinit var btnWay1 : AppCompatButton
    lateinit var btnWay2 : AppCompatButton
    lateinit var btnExam2 : AppCompatButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
        btnWay1.setOnClickListener{
            val intent1 = Intent(this@MainActivity, UseInterActivity::class.java)
            startActivity(intent1)
        }
        btnWay2.setOnClickListener{
            val intent2 = Intent(this@MainActivity, UseInterActivity2::class.java)
            startActivity(intent2)
        }
        btnExam2.setOnClickListener{
            val intentExam2 = Intent(this@MainActivity, Exam2_Provider::class.java)
            startActivity(intentExam2)
        }
    }

    private fun init(){
        btnWay1 = findViewById(R.id.btn_way1)
        btnWay2 = findViewById(R.id.btn_way2)
        btnExam2 = findViewById(R.id.btn_Exam2)
    }

}