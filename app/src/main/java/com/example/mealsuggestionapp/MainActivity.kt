package com.example.mealsuggestionapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val timeInput = findViewById<EditText>(R.id.timeInput)
        val suggestButton = findViewById<Button>(R.id.suggestButton)
        val mealSuggestions = findViewById<TextView>(R.id.mealSuggestion)
        val resetButton = findViewById<Button>(R.id.resetButton)
        val mealImage = findViewById<ImageView>(R.id.mealImage)


        suggestButton.setOnClickListener {
            val input = timeInput.text.toString().trim().lowercase()
            var suggestion = ""
            var imageResId = 0

            if (input == "morning") {
                suggestion = "Breakfast: Eggs"
                imageResId = R.drawable.eggs
            } else if (input == "mid-morning") {
                suggestion = "Light snack: Fruit"
                imageResId = R.drawable.fruits
            } else if (input == "afternoon") {
                suggestion = "Lunch: Sandwich"
                imageResId = R.drawable.sandwich
            } else if (input == "afternoon snack") {
                suggestion = "Quick Bite: Cake"
                imageResId = R.drawable.cake
            } else if (input == "dinner") {
                suggestion = "Main Course: Pasta"
                imageResId = R.drawable.pasta
            } else if (input == "after dinner snack") {
                suggestion = "Dessert: iCe Cream"
                imageResId = R.drawable.icecream
            } else {
                suggestion = "Invalid input! Please enter a valid time of he day."
                imageResId = 0
            }

            mealSuggestions.text = suggestion

            if (imageResId != 0) {
                mealImage.setImageResource(imageResId)
            } else {
                mealImage.setImageDrawable(null)
            }
        }

        resetButton.setOnClickListener {
            timeInput.text.clear()
            mealSuggestions.text = ""
            mealImage.setImageDrawable(null)
       }
    }

  }

