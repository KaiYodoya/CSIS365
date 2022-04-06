package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {

    var userName: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Creating variable
        userName = "Sam"                // var: mutable
        val userId: Int = 123           // val: immutable

        userName = newName()            // alt + enter // need to create newName function below

        invokeCallback{
            Log.w("tag", "Helo")    // alt + enter -> auto complete
        }
    }

    // call from ctrl + o
    override fun onResume() {
        super.onResume()
    }

    private fun invokeCallback(callback: () -> Unit) {
        if(userName == NULL)
        callback.invoke()
    }

    private fun newName(): String {
        return "Stutsman"
    }
}