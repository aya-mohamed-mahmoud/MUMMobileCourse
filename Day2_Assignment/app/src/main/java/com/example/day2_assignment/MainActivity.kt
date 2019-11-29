package com.example.day2_assignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var availableMeals = arrayListOf("Hamburger", "Pizza", "Mexican", "American", "Chinese")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun addFoodAction(view: View) {
        //using kotlin way
        availableMeals.add("${addFoodEditText.text}")
        availableMeals.forEach {
            println("The element is $it")

        }
    }

    fun decideOtherMeal(view: View) {
        randomMealTextView.text = availableMeals.random()
    }


}
