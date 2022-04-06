package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var tvHello: TextView
    private lateinit var tvGoodbye: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvHello = findViewById(R.id.tv_Hello)
        tvGoodbye = findViewById(R.id.tv_Goodbye)

        tvHello.text = "Modified Text"
        tvGoodbye.text = "Modified Text"
    }
}