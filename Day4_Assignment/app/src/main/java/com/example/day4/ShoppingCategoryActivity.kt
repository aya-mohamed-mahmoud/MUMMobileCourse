package com.example.day4

import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_shopping_category.*


class ShoppingCategoryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping_category)

        val intent = getIntent()
        val intentData = intent.getSerializableExtra("userName")
        var txt = intentData.toString()

        var tv1 = findViewById<TextView>(R.id.user_name)

        tv1.text = "Hello "+txt

        iv_click_me1.setOnClickListener {
            // your code to perform when the user clicks on the ImageView
            Toast.makeText(this, "You clicked on Beauty Category.", Toast.LENGTH_SHORT).show()
        }

        iv_click_me2.setOnClickListener {
            // your code to perform when the user clicks on the ImageView
            Toast.makeText(this, "You clicked on Cloth Category.", Toast.LENGTH_SHORT).show()
        }
        iv_click_me3.setOnClickListener {
            // your code to perform when the user clicks on the ImageView
            Toast.makeText(this, "You clicked on Food Category.", Toast.LENGTH_SHORT).show()
        }
        iv_click_me4.setOnClickListener {
            // your code to perform when the user clicks on the ImageView
            Toast.makeText(this, "You clicked on Electronics Category.", Toast.LENGTH_SHORT).show()
        }
    }
}
