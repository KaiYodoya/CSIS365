package com.csis365.assignment1

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ListFruit : AppCompatActivity() {

    private lateinit var userNameFruit: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.list_fruit)


        // User info
        val user = intent.getStringExtra("value")

        if (user != null) {
            Log.d("Login", user)
            userNameFruit = findViewById(R.id.userNameFruit)
            userNameFruit.setText("User name is: " + user)
        }


        // RecyclerView set up
        val recyclerview = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerview.layoutManager = LinearLayoutManager(this)

        // call retrofit
        val service = FruitService.create()
        service.getAllFruit().enqueue(object : Callback<List<Fruit>> {
            override fun onResponse(call: Call<List<Fruit>>, response: Response<List<Fruit>>) {
                Log.i("allFruit", "onResponse()")

                // if retrofit success, "response" should have info of all fruit
                if (response.isSuccessful){
                    val adapter = ListFruitAdapter(response.body()!!, this@ListFruit)
                    recyclerview.adapter = adapter

                    adapter.setOnItemClickListener(object: ListFruitAdapter.onItemClickListener{

                        override fun onItemClick(position: Int) {

                            //Toast.makeText(this@ListFruit, "You clicked on item no.$position", Toast.LENGTH_SHORT).show()

                        }

                    })


                }
            }

            override fun onFailure(call: Call<List<Fruit>>, t: Throwable) {
                Log.e("allFruit", "onFailure()")
            }
        })


    }

}