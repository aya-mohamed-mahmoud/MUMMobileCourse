package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TableRow
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun addAndroidVersion(view: View) {

        // Create a new table row.
        val tableRow = TableRow(getApplicationContext())

        // Set new table row layout parameters.
        val layoutParams = TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT)
        tableRow.setLayoutParams(layoutParams)

        var androidVersionTextView = TextView(this)
        androidVersionTextView.textSize = 18f
        androidVersionTextView.setBackgroundResource(R.color.colorAccent)
        androidVersionTextView.setTextColor(getResources().getColor(R.color.white));
        androidVersionTextView.text = "${android_version.text.toString()}"

        var codeNameTextView = TextView(this)
        codeNameTextView.textSize = 18f
        codeNameTextView.setBackgroundResource(R.color.colorAccent)
        codeNameTextView.setTextColor(getResources().getColor(R.color.white));
        codeNameTextView.text = "${code_name.text.toString()}"
        println(codeNameTextView.text)

        // add values into row by calling addView()
        tableRow.addView(androidVersionTextView)

        // add values into row by calling addView()
        tableRow.addView(codeNameTextView)

        // Finally add the created row row into layout
        table_layout.addView(tableRow) // id from Layout_file

    }
}
