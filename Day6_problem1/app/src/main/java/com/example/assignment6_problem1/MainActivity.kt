package com.example.assignment6_problem1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioButton
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*
import android.widget.CheckBox
import java.text.SimpleDateFormat
import java.util.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        submit.setOnClickListener {
            var score : Double = 0.0

            var checkbox1 = findViewById(R.id.answer1) as CheckBox

            // this is worng answer
            if (checkbox1.isChecked) {
               //Toast.makeText(applicationContext, "You have chosen checkbox1", Toast.LENGTH_LONG).show()
        }
            var checkbox2 = findViewById(R.id.answer2) as CheckBox

            if (checkbox2.isChecked) {
                score += 25
                //Toast.makeText(applicationContext, "You have chosen checkbox2", Toast.LENGTH_LONG).show()
            }
            var checkbox3 = findViewById(R.id.answer3) as CheckBox

            if (checkbox3.isChecked) {
                score += 25
                //Toast.makeText(applicationContext, "You have chosen checkbox3", Toast.LENGTH_LONG).show()
            }

            // to get selected radio button
            val selectedId = rg.getCheckedRadioButtonId()

            var radioButton = findViewById(selectedId) as RadioButton

            var selected = radioButton.getText().toString();

            if(selected.toString().equals("No")){
                score += 50
            }

            val sdf = SimpleDateFormat("dd/M/yyyy hh:mm:ss")
            val currentDate = sdf.format(Date())
            System.out.println(" C DATE is  "+currentDate)

            // 1. Create an object for AlertDialog by passing the current context object
            val builder = AlertDialog.Builder(this@MainActivity)

            // 2. Set the basic information for the builder object
            builder.setTitle("Alert Message")

            if(score >=50){
                builder.setMessage("Congratulation your score is "+ score +" submitted time is "+ currentDate)
            }
            else{
                builder.setMessage("you didn't pass your score is "+ score +" submitted time is "+ currentDate)
            }

            builder.setIcon(R.drawable.alerticon)

            builder.setPositiveButton("OK") { dialogInterface, which ->
                dialogInterface.dismiss() // dismiss the dialog

            }

            // 5. Finally, make the alert dialog using builder
            val dialog: AlertDialog = builder.create()
            // 6. Display the alert dialog on app interface
            dialog.show()
        }

        reset.setOnClickListener {
            var checkbox1 = findViewById(R.id.answer1) as CheckBox
            var checkbox2 = findViewById(R.id.answer2) as CheckBox
            var checkbox3 = findViewById(R.id.answer3) as CheckBox

            if(checkbox1.isChecked){
                checkbox1.isChecked=false
            }
            if(checkbox2.isChecked){
                checkbox2.isChecked=false
            }
            if(checkbox3.isChecked){
                checkbox3.isChecked=false
            }

           rg.clearCheck()

        }

    }


}