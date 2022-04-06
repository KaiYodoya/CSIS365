package com.example.myapplication2_9

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class FullNameActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_full_name)

        // var tvFullName = findViewById(R.tv_full_name)

        val fullName: String? = intent.getStringExtra("name")

        Log.d("asdf", fullName!!)
    }
}