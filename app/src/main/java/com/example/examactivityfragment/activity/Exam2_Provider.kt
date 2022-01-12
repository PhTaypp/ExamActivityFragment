package com.example.examactivityfragment.activity

import android.content.ContentValues
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import com.example.examactivityfragment.R
import com.example.examactivityfragment.provider.ContentProviderP

class Exam2_Provider : AppCompatActivity(R.layout.activity_exam2_provider) {


    override fun onStart() {
        super.onStart()
        val btnAdd = findViewById<AppCompatButton>(R.id.btnAdd)
        val btnNext = findViewById<AppCompatButton>(R.id.btn_next)
        val textName = findViewById<EditText>(R.id.edtName)
        val textPhone = findViewById<EditText>(R.id.edtPhoneNumber)
        btnAdd.setOnClickListener {
            val name = textName.text.toString()
            val phone = textPhone.text.toString()
            onClickAdd(name, phone)
        }
        btnNext.setOnClickListener{
            val intentShowData = Intent(this, ShowDataProvider::class.java)
            startActivity(intentShowData)
        }
    }
    private fun onClickAdd(name: String, phone: String){
        val value = ContentValues()
        value.put(ContentProviderP.name, name)
        value.put(ContentProviderP.phone, phone)
        this.contentResolver?.insert(ContentProviderP.CONTENT_URI, value)
        Toast.makeText(this, "ADD $name - $phone", Toast.LENGTH_LONG).show()
    }
}