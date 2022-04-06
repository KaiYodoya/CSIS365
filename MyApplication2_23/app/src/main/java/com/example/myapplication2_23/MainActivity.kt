package com.example.myapplication2_23

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvItems: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvItems = findViewById(R.id.rv_items)
        rvItems.layoutManager = LinearLayoutManager(this)

        // constructor
        rvItems.adapter = MyItemAdapter(  //if there is red text, alt + enter to fix
            listOf(
                "alpha",
                "bravo",
                "charlie",
                "delta",
                "alpha",
                "bravo",
                "charlie",
                "delta",
                "alpha",
                "bravo",
                "charlie",
                "delta",
                "alpha",
                "bravo",
                "charlie",
                "delta",
                "alpha",
                "bravo",
                "charlie",
                "delta",
                "alpha",
                "bravo",
                "charlie",
                "delta",
                "alpha",
                "bravo",
                "charlie",
                "delta",
            )
        )
    }
}