package com.example.day4

import android.app.Activity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_shopping_category.*


class ShoppingCategoryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping_category)


        val categories = arrayOf<String>("Beauty","Cloth","Electronics","Food")


        val imageId = arrayOf<Int>(
            R.drawable.beauty, R.drawable.cloth, R.drawable.electronics, R.drawable.food
        )
        val myListAdapter = MyListAdapter(this,categories,imageId)
        listView.adapter = myListAdapter

        listView.setOnItemClickListener(){adapterView, view, position, id ->
            val itemAtPos = adapterView.getItemAtPosition(position)
            val itemIdAtPos = adapterView.getItemIdAtPosition(position)
            Toast.makeText(this, "Click on item at $itemAtPos its item id $itemIdAtPos", Toast.LENGTH_SHORT).show()
        }
    }
}

class MyListAdapter(private val context: Activity, private val title: Array<String>, private val imgid: Array<Int>)
    : ArrayAdapter<String>(context, R.layout.my_list, title) {

    override fun getView(position: Int, view: View?, parent: ViewGroup): View {
        val inflater = context.layoutInflater
        val rowView = inflater.inflate(R.layout.my_list, null, true)

        val titleText = rowView.findViewById(R.id.title) as TextView
        val imageView = rowView.findViewById(R.id.icon) as ImageView

        titleText.text = title[position]
        imageView.setImageResource(imgid[position])

        return rowView
    }

}

