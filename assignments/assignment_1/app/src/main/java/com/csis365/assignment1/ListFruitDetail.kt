package com.csis365.assignment1

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ListFruitDetail : AppCompatActivity(){

    lateinit var genus: TextView
    lateinit var name: TextView
    lateinit var id: TextView
    lateinit var family: TextView
    lateinit var order: TextView

    lateinit var nutritions: TextView
    lateinit var carbohydrates: TextView
    lateinit var protein: TextView
    lateinit var fat: TextView
    lateinit var calories: TextView
    lateinit var sugar: TextView

    lateinit var backToList: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.list_fruit_detail)

        var intent = intent
        val genusReceived = intent.getStringExtra("genus")
        val nameReceived = intent.getStringExtra("name")
        val idReceived = intent.getIntExtra("id", -1)
        val familyReceived = intent.getStringExtra("family")
        val orderReceived = intent.getStringExtra("order")

        val carbohydratesReceived = intent.getDoubleExtra("carbohydrates", -1.0)
        val proteinReceived = intent.getDoubleExtra("protein", -1.0)
        val fatReceived = intent.getDoubleExtra("fat", -1.0)
        val caloriesReceived = intent.getDoubleExtra("calories", -1.0)
        val sugarReceived = intent.getDoubleExtra("sugar", -1.0)


        if (idReceived != -1)
        {
            genus = findViewById(R.id.genus)
            genus.text = "genus: " + genusReceived

            name = findViewById(R.id.name)
            name.text = "name: " + nameReceived

            id = findViewById(R.id.id)
            id.text = "id: " + idReceived.toString()

            family = findViewById(R.id.family)
            family.text = "family: " + familyReceived

            order = findViewById(R.id.order)
            order.text = "order: " + orderReceived

            nutritions = findViewById(R.id.nutritions)

            carbohydrates = findViewById(R.id.carbohydrates)
            carbohydrates.text = "carbohydrates: " + carbohydratesReceived.toString()

            protein = findViewById(R.id.protein)
            protein.text = "protein: " + proteinReceived.toString()

            fat = findViewById(R.id.fat)
            fat.text = "fat: " + fatReceived.toString()

            calories = findViewById(R.id.calories)
            calories.text = "calories: " + caloriesReceived.toString()

            sugar = findViewById(R.id.sugar)
            sugar.text = "sugar: " + sugarReceived.toString()
        }
        else {
            Log.i("Detail", "id = -1 : Invalid fruit")
        }



        // button to go back to main list
        backToList = findViewById(R.id.btnBackToList)
        backToList.setOnClickListener {
            Log.d("Detail", "Button has been pressed.")

            val intentListFruit = Intent(this, ListFruit::class.java)
            startActivity(intentListFruit)

        }

    }
}