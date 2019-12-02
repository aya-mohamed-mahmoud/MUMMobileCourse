package com.example.day4

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_create_new_account.*

class CreateNewAccount : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_new_account)
    }

    fun createNewAccountAction(view: View) {
        var firstName = firstName?.text.toString()
        var lastName = lastName?.text.toString()
        var email = email?.text.toString()
        var password = password?.text.toString()

        if (firstName != "" && lastName != "" && email != "" && password != "") {
            var user = User(firstName, lastName, email, password)

            Toast.makeText(this, "Account created successfully.", Toast.LENGTH_SHORT).show()

            val intentData = Intent()
            //---set the data to pass back
            intentData.putExtra("user", user)
            setResult(Activity.RESULT_OK, intentData)
            //---close the activity---
            finish()
        }
        else{
            Toast.makeText(this, "Enter all data to register", Toast.LENGTH_SHORT).show()

        }
    }
}
