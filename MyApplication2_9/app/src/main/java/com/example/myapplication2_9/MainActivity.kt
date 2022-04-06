package com.example.myapplication2_9

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    private lateinit var btnProceed: Button
    private lateinit var etFirstName: EditText
    private lateinit var etLastName: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnProceed = findViewById(R.id.btn_proceed)
        etFirstName = findViewById(R.id.etFirstName)
        etLastName = findViewById(R.id.etLastName)

        btnProceed.setOnClickListener{
            Log.d("asdf", "Button has been pressed.")
            Log.i("asdf", "First name is " + etFirstName.text.toString())
            Log.v("asdf", "Last name is ${etLastName.text.toString()}")

            val fullName = etFirstName.text.toString() + etLastName.text.toString()
            Log.w("asdf", fullName)

            val intent = Intent(this, FullNameActivity::class.java)
            intent.putExtra("name", fullName)


            startActivity(intent)
        }
    }
}