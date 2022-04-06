package com.example.myapplication2_7

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var tvHelloWorld: TextView
    private lateinit var btnViewDetails: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvHelloWorld = findViewById(R.id.tv_hello_world)
        btnViewDetails = findViewById(R.id.btn_view_detail)

        btnViewDetails.setOnClickListener {
            // tvHelloWorld.text = "Modified text"
            val secondActivityIntent = Intent(this, SecondActivity::class.java)
            startActivity(secondActivityIntent)
        }
    }
}